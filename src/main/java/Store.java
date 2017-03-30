import org.sql2o.*;
import java.util.List;

public class Store{

  private String phone_number;
  private String location;
  private int id;

  public Store(String phone_number, String location){
    this.phone_number = phone_number;
    this.location = location;
  }

  public String getPhoneNumber(){
    return phone_number;
  }

  public String getLocation(){
    return location;
  }


  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stores(phone_number, location) VALUES (:phone_number, :location)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("phone_number", this.phone_number)
        .addParameter("location", this.location)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Store> all() {
    String sql = "SELECT * FROM stores";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Store.class);
    }
  }





}
