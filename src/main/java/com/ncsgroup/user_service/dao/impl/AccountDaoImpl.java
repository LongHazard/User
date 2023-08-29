package com.ncsgroup.user_service.dao.impl;

import com.ncsgroup.user_service.dao.AccountDao;
import com.ncsgroup.user_service.dao.HikariConfiguration;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class AccountDaoImpl implements AccountDao {
  @Override
  public void create(String id, String username, String password) {
    String sql = String.format("insert into account (id, username, password) values ('%s', '%s', '%s')", id, username, password);

    Connection connection = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);
      // tạo Statement để thao tác với cơ sở dữ liệu
      Statement statement = connection.createStatement();
      statement.executeUpdate(sql);

      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
      try {
        connection.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }
    } finally {
      if (connection != null) {
        try {
          connection.setAutoCommit(true);
          connection.close();
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  @Override
  public boolean validateExistByAccount(String username) {
    String sql = String.format("select * from account where username = ?", username);

    Connection connection = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);
      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery(sql);
      log.info("(validateExistByAccount) successfully");
      if (resultSet.next()) return true;

    } catch (SQLException e) {

      log.error("(validateExistByAccount) exception: {}", e.getMessage());
      try {
        connection.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }

    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
      }
    }
    return false;
  }

  @Override
  public void delete(Long accountId) throws SQLException {

  }

  @Override
  public void update(Long accountId, String username, String password) throws SQLException {

  }
}
