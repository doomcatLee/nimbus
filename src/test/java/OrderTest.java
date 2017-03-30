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

  @Test
  public void test_getters(){
    Order order = new Order(5,4);
    assertEquals(5, order.getInvoice());
    assertEquals(4, order.getTotalPrice());
  }

  @Test
  public void check_if_save_works(){
    Order order = new Order(5,4);
    order.save();
    assertEquals(true, order.all().get(0) instanceof Order);
  }

  @Test
  public void check_if_all_works(){
    Order order = new Order(5,4);
    order.save();
    assertTrue(order.all() instanceof List<?>);
  }

  @Test
  public void check_if_find_works(){
    Order order = new Order(5,4);
    order.save();
    assertTrue(order.find(order.getId()) instanceof Order);
  }

}
