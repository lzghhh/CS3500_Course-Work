import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EpsilonTest {

  @Test
  public void testSomething() { 
    Flight f = new BasicFlight(42, "BOS", "NYC", 5);
    Epsilon eps = new Epsilon();
    eps.addFlight(f);

    int res1 = eps.reserve(42, Arrays.asList("Ben"));
    int res2 = eps.reserve(42, Arrays.asList("Amit"));
    int res3 = eps.reserve(42, Arrays.asList("Clark"));
    try {
      eps.reserve(42, Arrays.asList("Yakko", "Wakko", "Dot"));
      fail("...why would this fail be here?...");
    } catch (IllegalStateException e) {
      eps.cancel(res1);
      eps.reserve(42, Arrays.asList("Yakko", "Wakko", "Dot"));
      assertEquals(0, eps.getRemainingSeats(42));
    }
  }
}