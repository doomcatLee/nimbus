import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource{

  @Override
  protected void before(){
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/nimbus_test", null, null);
  }

  @Override
  protected void after(){
    try(Connection con = DB.sql2o.open()){
      String deleteOrdersQuery = "DELETE FROM orders *;";
      String deleteFromUsers = "DELETE FROM users *;";
      con.createQuery(deleteOrdersQuery).executeUpdate();
      con.createQuery(deleteFromUsers).executeUpdate();
    }
  }
}
