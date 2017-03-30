
import java.time.LocalDateTime;
import org.junit.*;
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
  public void test_for_save_method(){
    User newUser = new User(true, "password","keith", "email", "01-19-1988", "1234 street");

  }
}
