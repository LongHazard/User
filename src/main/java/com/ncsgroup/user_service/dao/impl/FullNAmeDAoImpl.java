package com.ncsgroup.user_service.dao.impl;

import com.ncsgroup.user_service.dao.FullNameDao;
import com.ncsgroup.user_service.dao.HikariConfiguration;
import com.ncsgroup.user_service.entity.FullName;
import com.ncsgroup.user_service.utils.ConnectionJDBC;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class FullNAmeDAoImpl implements FullNameDao {
  @Override
  public FullName create(String fullNameId, String firstName, String middleName, String lastName) {
    String sql = "insert into full_name (id, first_name, middle_name, last_name) values (?,?,?,?)";
    FullName fullName = new FullName();
    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      statement = connection.prepareStatement(sql);
      statement.setString(1, fullNameId);
      statement.setString(2, firstName);
      statement.setString(3, middleName);
      statement.setString(4, lastName);
      int rowsAffected =  statement.executeUpdate();
      connection.commit();
      log.info("(create) successfully");

      if(rowsAffected > 0){
        fullName.setId(fullNameId);
        fullName.setFirstName(firstName);
        fullName.setMiddleName(middleName);
        fullName.setLastName(lastName);
      }

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
    return fullName;
  }

  @Override
  public FullName findById(String id) {
    FullName fullName = new FullName();
    String sql = "select * from full_name where id = ?";
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
        fullName.setId(resultSet.getString("id"));
        fullName.setFirstName(resultSet.getString("first_name"));
        fullName.setMiddleName(resultSet.getString("middle_name"));
        fullName.setLastName(resultSet.getString("last_name"));
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
    return fullName;
  }


  @Override
  public void delete(String fullNameId) {
    String sql = "delete from full_name where id = ?";
    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);

      statement = connection.prepareStatement(sql);
      statement.setString(1, fullNameId);
      statement.executeUpdate();
      connection.commit();
      log.info("(delete) id: {} successfully", fullNameId);

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
  public void update(String fullNameId, String firstName, String middleName, String lastName) {
    String sql = "update full_name set first_name = ?, middle_name = ?, last_name = ? where id = ?";
    Connection connection = null;
    PreparedStatement statement = null;

    try {
      connection = HikariConfiguration.getInstance().getConnection();
      connection.setAutoCommit(false);
      statement = connection.prepareStatement(sql);
      statement.setString(1, firstName);
      statement.setString(2, middleName);
      statement.setString(3, lastName);
      statement.setString(4, fullNameId);
      statement.executeUpdate();
      connection.commit();
      log.info("(update) id: {} successfully", fullNameId);

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
