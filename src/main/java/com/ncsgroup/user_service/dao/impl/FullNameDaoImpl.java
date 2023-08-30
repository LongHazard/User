package com.ncsgroup.user_service.dao.impl;

import com.ncsgroup.user_service.dao.FullNameDao;
import com.ncsgroup.user_service.dao.HikariConfiguration;
import com.ncsgroup.user_service.dto.response.FullNameResponse;
import com.ncsgroup.user_service.entity.FullName;
import com.ncsgroup.user_service.utils.ConnectionJDBC;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ncsgroup.user_service.constant.Constant.QueryOfMysql.*;

@Slf4j
public class FullNameDaoImpl implements FullNameDao {
  @Override
  public FullName create(String fullNameId, String firstName, String middleName, String lastName) {

    FullName fullName = new FullName();
    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      statement = connection.prepareStatement(CREATE_FULL_NAME);
      statement.setString(1, fullNameId);
      statement.setString(2, firstName);
      statement.setString(3, middleName);
      statement.setString(4, lastName);
      int rowsAffected = statement.executeUpdate();
      connection.commit();
      log.info("(create) successfully");

      if (rowsAffected > 0) {
        fullName.setId(fullNameId);
        fullName.setFirstName(firstName);
        fullName.setMiddleName(middleName);
        fullName.setLastName(lastName);
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
    return fullName;
  }


  @Override
  public void delete(String fullNameId) {

    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      statement = connection.prepareStatement(DELETE_FULL_NAME);
      statement.setString(1, fullNameId);
      statement.executeUpdate();
      connection.commit();
      log.info("(delete) id: {} successfully", fullNameId);

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
  public FullNameResponse update(String fullNameId, String firstName, String middleName, String lastName) {
    FullNameResponse fullNameResponse = new FullNameResponse();

    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);
      statement = connection.prepareStatement(UPDATE_FULL_NAME);
      statement.setString(1, firstName);
      statement.setString(2, middleName);
      statement.setString(3, lastName);
      statement.setString(4, fullNameId);
      int rowsAffected = statement.executeUpdate();
      connection.commit();
      log.info("(update) id: {} successfully", fullNameId);

      if (rowsAffected > 0) {
        fullNameResponse.setId(fullNameId);
        fullNameResponse.setFirstName(firstName);
        fullNameResponse.setMiddleName(middleName);
        fullNameResponse.setLastName(lastName);
      }

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

    return fullNameResponse;
  }

}
