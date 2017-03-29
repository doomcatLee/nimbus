import java.util.List;
import java.time.LocalDatetime;
import org.sql2o.*;

public class User {
  private int     userId;
  private boolean userAdmin;
  private String  userName;
  private String  userEmail;
  private int     userDateCreated;
  private int     userBirthday;
  private String  userAddress;


  public User(String userName, String userEmail, int userBirthday, String userAddress){
    this.userName = userName;
    this.userEmail = userEmail;
    this.userBirthday = userBirthday;
    this.userAddress = userAddress;
  }

  public void save(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO users(userName, userAdmin, userEmail, userDateCreated, userBirthday, userAddress) VALUES (:uN, :uE, :uDC, :uB, :uA);";
      this.userId = (int) con.createQuery(sql, true)
        .addParameter("uN", this.userName)
        .addParameter("uN", this.userAdmin)
        .addParameter("uE", this.userEmail)
        .addParameter("uDC", this.userDateCreated)
        .addParameter("uB", this.userBirthday)
        .addParameter("uA", this.userAddress)
        .executeUpdate()
        .getKey();
    }
  }

  public void update(String column, String columnValue){
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE users SET :column = columnValue WHERE id = :userId";
      con.createQuery(sql)
        .addParameter("column", column)
        .addParameter("columnValue", columnValue)
        .addParameter("userId", userId)
        .executeUpdate()
        .getKey();
    }
  }

  public int userId(){
    return userId;
  }
  public String userName(){
    return userName;
  }
  public String userBirthday(){
    return userName;
  }
  public String userName(){
    return userName;
  }
}
