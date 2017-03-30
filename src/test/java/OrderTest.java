import java.util.List;
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

  @Test
  public void addItem_works(){
    Order order = new Order(1, 10);
    order.addItem("a1");
    assertEquals("a1", order.returnItems().get(0));
  }

  @Test
  public void returnItems_work(){
    Order order = new Order(1, 10);
    assertTrue(order.returnItems() instanceof List<?>);
  }
}
