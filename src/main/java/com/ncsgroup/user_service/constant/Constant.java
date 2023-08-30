package com.ncsgroup.user_service.constant;

public class Constant {

  public static final class ExceptionStatusConstant {
    public static final int BAD_REQUEST = 400;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int CONFLICT = 409;
    public static final int UNAUTHORIZED = 401;
  }

  public static class LanguageConstants {
    public static final String LANGUAGE = "Accept-Language";

    public static final String DEFAULT_LANGUAGE = "en";

    public static final String SUCCESS = "success";
  }

  public static final class MessagesResponse {
    public static final String INVALID_EMAIL = "com.ncsgroup.login.annotation.ValidationEmail";

    public static final String INVALID_PHONE_NUMBER = "com.ncsgroup.login.annotation.ValidationPhoneNumber";

  }

  public static class ConfigConstant{
    public static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
    public static final String URL = "jdbc:postgresql://localhost:5432/JDBC";
    public static final String USER_NAME = "postgres";
    public static final String PASSWORD = "postgres";
  }
  public static class QueryOfMysql{
    public static final String CREATE_USER = "insert into users  (id, email, phone, account_id, full_name_id) values  (?,?,?,?,?)";
    public static final String GET_USER_BY_ID = "select * from users where id = ?";
    public static final String DELETE_USER = "delete from users where id = ?";
    public static final String UPDATE_USER_BY_ID = "update users set email = ?, phone = ? where id = ?";
    public static final String CREATE_ACCOUNT = "insert into account (id, username, password) values (?,?,?)";
    public static final String DELETE_ACCOUNT = "delete from account where id = ?";
    public static final String UPDATE_ACCOUNT = "update account set username = ?, \"password\" = ? where id = ?";
    public static final String EXIST_BY_USER_NAME = "select count(*) from account where username = ?";
    public static final String CREATE_FULL_NAME = "insert into full_name (id, first_name, middle_name, last_name) values (?,?,?,?)";
    public static final String DELETE_FULL_NAME = "delete from full_name where id = ?";

    public static final String UPDATE_FULL_NAME = "update full_name set first_name = ?, middle_name = ?, last_name = ? where id = ?";
  }

}
