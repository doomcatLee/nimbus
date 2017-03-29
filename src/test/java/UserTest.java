
import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class UserTest {

  @Test
  public void getId_tasksInstantiateWithAnID() {
    User newUser = new User("keith", "email", "01-19-1988", "1234 street");
    newUser.save();
    assertTrue(newUser.userId() > 0);
  }
}
