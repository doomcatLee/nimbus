import java.util.List;
import java.util.ArrayList;
import java.time.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.sql2o.*;

public class User {
  private int           user_id;
  private boolean       user_admin;
  private String        user_password;
  private String        user_name;
  private String        user_email;
  private String        user_date_created;
  private String        user_birthday;
  private String        user_address;


  public User(String user_name, String user_password, String user_email, String user_birthday, String user_address){
    this.user_admin = true;
    this.user_name = user_password;
    this.user_name = user_name;
    this.user_email = user_email;
    Date makeDate = new Date();
    this.user_date_created = new SimpleDateFormat("MM-dd-yyyy").format(makeDate);
    this.user_birthday = user_birthday;
    this.user_address = user_address;
  }

  public void save(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO users(user_admin, user_password, user_name, user_email, user_date_created, user_birthday, user_address) VALUES (:user_admin, :user_password, :user_name, :user_email, :user_date_created, :user_birthday, :user_address);";
      this.user_id = (int) con.createQuery(sql, true)
        .addParameter("user_admin", this.user_admin)
        .addParameter("user_password", this.user_password)
        .addParameter("user_name", this.user_name)
        .addParameter("user_email", this.user_email)
        .addParameter("user_date_created", this.user_date_created)
        .addParameter("user_birthday", this.user_birthday)
        .addParameter("user_address", this.user_address)
        .executeUpdate()
        .getKey();
    }
  }

  // public void update(String column, String columnValue){
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "UPDATE users SET :column = columnValue WHERE id = :userId";
  //     con.createQuery(sql)
  //       .addParameter("column", column)
  //       .addParameter("columnValue", columnValue)
  //       .addParameter("userId", user_id)
  //       .executeUpdate()
  //       .getKey();
  //   }
  // }

  // public static User find(int userId){
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT * FROM users WHERE user_id = :userId";
  //     return con.createQuery(sql)
  //       .addParameter("userId", userId)
  //       .executeUpdate()
  //       .getKey();
  //   }
  // }

  public int userId(){
    return user_id;
  }
  public String userName(){
    return user_name;
  }
  public String userBirthday(){
    return user_birthday;
  }
}
