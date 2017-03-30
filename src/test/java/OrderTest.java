
import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;


public class OrderTest{

  @Test
  public void Order_instantiates_correctly(){
    Order order = new Order(1, 10);
    assertTrue(order instanceof Order);
  }
}
