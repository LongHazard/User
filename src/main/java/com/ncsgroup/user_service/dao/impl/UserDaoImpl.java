package com.ncsgroup.user_service.dao.impl;

import com.ncsgroup.user_service.dao.HikariConfiguration;
import com.ncsgroup.user_service.dao.UserDao;
import com.ncsgroup.user_service.entity.User;
import com.ncsgroup.user_service.utils.ConnectionJDBC;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class UserDaoImpl implements UserDao {
  @Override
  public void create(String id, String email, String phone, String accountId, String fullNameId) {
    String sql = "insert into users  (id, email, phone, account_id, full_name_id) values  (?,?,?,?,?)";
    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      statement = connection.prepareStatement(sql);
      statement.setString(1, id);
      statement.setString(2, email);
      statement.setString(3, phone);
      statement.setString(4, accountId);
      statement.setString(5, fullNameId);
      statement.executeUpdate();
      connection.commit();
      log.info("(create) successfully");

    } catch (SQLException e) {
      e.printStackTrace();
      try {
        connection.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }
    } finally {
      ConnectionJDBC.closeResources(connection, statement);
    }
  }


  @Override
  public User findById(String userId) {
    User user = new User();
    String sql = "select * from users where id = ?";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      statement = connection.prepareStatement(sql);
      statement.setString(1, userId);
      resultSet = statement.executeQuery();
      log.info("(find) successfully");

      while (resultSet.next()) {
        user.setId(resultSet.getString("id"));
        user.setEmail(resultSet.getString("email"));
        user.setPhone(resultSet.getString("phone"));
        user.setAccountId(resultSet.getString("account_id"));
        user.setFullNameId(resultSet.getString("full_name_id"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
      try {
        connection.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }
    } finally {
      ConnectionJDBC.closeResources(connection, statement, resultSet);
    }
    return user;
  }

  @Override
  public void delete(String userId) {
    String sql = "delete from users where id = ?";
    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      statement = connection.prepareStatement(sql);
      statement.setString(1, userId);
      statement.executeUpdate();
      connection.commit();
      log.info("(delete) id: {} successfully", userId);

    } catch (SQLException e) {
      log.error("(delete) exception: {}", e.getMessage());
      try {

        connection.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }

    } finally {
      ConnectionJDBC.closeResources(connection, statement);
    }
  }

  @Override
  public void update(String id, String email, String phone) {
    String sql = "update users set email = ?, phone = ? where id = ?";
    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);
      statement = connection.prepareStatement(sql);
      statement.setString(1, email);
      statement.setString(2, phone);
      statement.setString(3, id);
      statement.executeUpdate();
      connection.commit();
      log.info("(update) id: {} successfully", id);

    } catch (SQLException e) {
      log.error("(update) exception: {}", e.getMessage());
      try {
        connection.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }

    } finally {
      ConnectionJDBC.closeResources(connection, statement);
    }
  }

}
