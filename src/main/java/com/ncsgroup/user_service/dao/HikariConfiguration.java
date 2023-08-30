package com.ncsgroup.user_service.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class HikariConfiguration {
  // khai báo 1 biến instance
  private static HikariConfiguration instance = new HikariConfiguration();

  // tạo constructor là private để không thể tạo ra các instance mới từ bên ngoài
  private HikariConfiguration() {
  }

  // getInstance() kiểm tra xem đã tồn tại instance
  public static HikariConfiguration getInstance() {
    if (instance == null) {
      instance = new HikariConfiguration();
    }
    return instance;
  }

  // khởi tạo cấu hình cho HIKARI một lần duy nhất
  static {
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setDriverClassName("org.postgresql.Driver");
    hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/JDBC");
    hikariConfig.setUsername("postgres");
    hikariConfig.setPassword("postgres");
    // tắt tự động commit
    hikariConfig.setAutoCommit(false);
    // tên cho Pool kết nối
    hikariConfig.setPoolName("Pool");
    // kích thước tối đa của pool kết nối
    hikariConfig.setMaximumPoolSize(20);
    // thời gian chờ tạo kết nối
    hikariConfig.setConnectionTimeout(3000);
    hikariDataSource = new HikariDataSource(hikariConfig);
  }

  private static HikariDataSource hikariDataSource;

  // Pt được sử dụng để lấy 1 kết nối từ pool kết nối đã được cấu hình
  public Connection getConnection() throws SQLException {
    return hikariDataSource.getConnection();
  }
}


