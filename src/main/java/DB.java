import org.sql2o.*;

public class DB {
  public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/nimbus", null, null);
}

/*
CREATE TABLE users (user_id serial PRIMARY KEY, user_admin boolean, user_password varchar, user_fullname varchar, user_email varchar, user_date_created varchar, user_birthday varchar, user_address varchar);
*/
