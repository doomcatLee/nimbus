
import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;


public class OrderTest{

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Order_instantiates_correctly(){
    Order order = new Order(1, 10);
    assertTrue(order instanceof Order);
  }
}
