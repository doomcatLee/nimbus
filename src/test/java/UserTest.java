
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
