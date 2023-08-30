package com.ncsgroup.user_service.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionJDBC {
  public static void closeResources(Connection connection, PreparedStatement statement) {
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static void closeResources(Connection connection, PreparedStatement statement, ResultSet resultSet) {
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }

}
