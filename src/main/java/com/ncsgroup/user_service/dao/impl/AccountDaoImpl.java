package com.ncsgroup.user_service.dao.impl;

import com.ncsgroup.user_service.dao.AccountDao;
import com.ncsgroup.user_service.dao.HikariConfiguration;
import com.ncsgroup.user_service.entity.Account;
import com.ncsgroup.user_service.utils.ConnectionJDBC;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class AccountDaoImpl implements AccountDao {
  @Override
  public Account create(String id, String username, String password) {
    String sql = "insert into account (id, username, password) values (?,?,?)";
    Account account = new Account();
    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      statement = connection.prepareStatement(sql);
      statement.setString(1, id);
      statement.setString(2, username);
      statement.setString(3, password);
      int rowsAffected = statement.executeUpdate();
      connection.commit();
      log.info("(create) successfully");

      if(rowsAffected > 0){
        account.setId(id);
        account.setUsername(username);
        account.setPassword(password);
      }

//      account = findById(id);

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
    return account;
  }

  @Override
  public Account findById(String id) {
    Account account = new Account();
    String sql = "select * from account where id = ?";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      statement = connection.prepareStatement(sql);
      statement.setString(1, id);
      resultSet = statement.executeQuery();
      log.info("(find) successfully");

      while (resultSet.next()) {
        account.setId(resultSet.getString("id"));
        account.setUsername(resultSet.getString("username"));
        account.setPassword(resultSet.getString("password"));
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
    return account;
  }

  @Override
  public boolean validateExistByAccount(String username) {
    String sql = "select count(*) from account where username = ?";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, username);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        int count = resultSet.getInt(1);
        return count > 0;
      }

    } catch (SQLException e) {

      log.error("(validateExistByAccount) exception: {}", e.getMessage());
      try {
        connection.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }

    } finally {
      ConnectionJDBC.closeResources(connection, preparedStatement, resultSet);
    }
    return false;
  }

  @Override
  public void delete(String accountId) {
    String sql = "delete from account where id = ?";
    Connection connection = null;
    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, accountId);
      statement.executeUpdate();
      connection.commit();
      log.info("(delete) id: {} successfully", accountId);

    } catch (SQLException e) {
      log.error("(delete) exception: {}", e.getMessage());
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
  }

  @Override
  public void update(String accountId, String username, String password) {
    String sql = "update account set username = ?, \"password\" = ? where id = ?";
    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);
      statement = connection.prepareStatement(sql);
      statement.setString(1, username);
      statement.setString(2, password);
      statement.setString(3, accountId);
      statement.executeUpdate();
      connection.commit();
      log.info("(update) id: {} successfully", accountId);

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
