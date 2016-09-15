import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

  @Test
  public void Hero_instantiatesCorrectly_true() {
    Hero testHero = new Hero("Superman", "Strength, Flight, Laser Eyes", "DC");
    assertEquals(true, testHero instanceof Hero);
  }

  @Test
  public void getName_returnsName_Superman() {
    Hero testHero = new Hero("Superman", "Strength, Flight, Laser Eyes", "DC");
    assertEquals("Superman", testHero.getName());
  }
}
