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

import static com.ncsgroup.user_service.constant.Constant.QueryOfMysql.*;

@Slf4j
public class UserDaoImpl implements UserDao {
  @Override
  public User create(String id, String email, String phone, String accountId, String fullNameId) {
    User user = new User();
    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      statement = connection.prepareStatement(CREATE_USER);
      statement.setString(1, id);
      statement.setString(2, email);
      statement.setString(3, phone);
      statement.setString(4, accountId);
      statement.setString(5, fullNameId);
      int rowsAffected = statement.executeUpdate();
      connection.commit();
      log.info("(create) successfully");

      if (rowsAffected > 0) {
        user.setId(id);
        user.setEmail(email);
        user.setPhone(phone);
      }

    } catch (SQLException e) {
      log.error("(create) exception: {}", e.getMessage());
      try {
        assert connection != null;
        connection.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }
    } finally {
      ConnectionJDBC.closeResources(connection, statement);
    }
    return user;
  }


  @Override
  public User findById(String userId) {
    User user = new User();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      statement = connection.prepareStatement(GET_USER_BY_ID);
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
      log.error("(find) exception: {}", e.getMessage());
      try {
        assert connection != null;
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

    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      statement = connection.prepareStatement(DELETE_USER);
      statement.setString(1, userId);
      statement.executeUpdate();
      connection.commit();
      log.info("(delete) id: {} successfully", userId);

    } catch (SQLException e) {
      log.error("(delete) exception: {}", e.getMessage());
      try {

        assert connection != null;
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

    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);
      statement = connection.prepareStatement(UPDATE_USER_BY_ID);
      statement.setString(1, email);
      statement.setString(2, phone);
      statement.setString(3, id);
      statement.executeUpdate();
      connection.commit();
      log.info("(update) id: {} successfully", id);

    } catch (SQLException e) {
      log.error("(update) exception: {}", e.getMessage());
      try {
        assert connection != null;
        connection.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }

    } finally {
      ConnectionJDBC.closeResources(connection, statement);
    }
  }

}
