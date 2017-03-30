import java.util.List;
import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class StoreTest{


  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void store_instantiates_correctly(){
    Store store = new Store("503-392-3392", "Portland, OR");
    assertTrue(store instanceof Store);
  }

  @Test
  public void store_getters_work(){
    Store store = new Store("503-392-3392", "Portland, OR");
    assertEquals("503-392-3392", store.getPhoneNumber());
    assertEquals("Portland, OR", store.getLocation());
  }

  @Test
  public void save_method_works(){
    Store store = new Store("503-392-3392", "Portland, OR");
    store.save();
    assertEquals(true, store.all().get(0) instanceof Store);
  }
}
