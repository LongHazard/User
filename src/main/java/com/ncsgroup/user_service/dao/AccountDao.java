package com.ncsgroup.user_service.dao;

import java.sql.SQLException;

public interface AccountDao {
  void create(String id, String username, String password) ;

  boolean validateExistByAccount(String username);

  void delete(Long accountId) throws SQLException;

  void update(Long accountId, String username, String password) throws SQLException;
}
