
import java.time.LocalDateTime;
import org.junit.*;
import java.util.List;
import static org.junit.Assert.*;

public class UserTest {


  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void getId_tasksInstantiateWithAnID() {
    User newUser = new User(true, "password","keith", "email", "01-19-1988", "1234 street");
    assertTrue(newUser instanceof User);
  }

  @Test
  public void test_all_the_getters(){
    User newUser = new User(true, "password","keith", "email", "01-19-1988", "1234 street");
    assertEquals(true, newUser.isAdmin());
    assertEquals("password", newUser.getUserPassword());
    assertEquals("keith", newUser.getUserName());
    assertEquals("email", newUser.getUserEmail());
    assertEquals("01-19-1988", newUser.getUserBirthday());
    assertEquals("1234 street", newUser.getUserAddress());
  }

  

  @Test
  public void save_works(){
    User newUser = new User(true, "password","keith", "email", "01-19-1988", "1234 street");
    newUser.save();
    assertTrue(newUser.all() instanceof List<?>);
  }

  @Test
  public void find_works(){
    User newUser = new User(true, "password","keith", "email", "01-19-1988", "1234 street");
    newUser.save();
    assertTrue(newUser.find(newUser.getUserId()) instanceof User);

  }
}
