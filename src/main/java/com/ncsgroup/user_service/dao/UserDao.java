package com.ncsgroup.user_service.dao;

import com.ncsgroup.user_service.entity.User;

public interface UserDao {
  User create(String id, String email, String phone, String accountId, String fullNameId);

  User findById(String userId);

  void delete(String userId);

  void update(String id,  String email, String phone);
}
