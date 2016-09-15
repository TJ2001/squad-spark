import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {
  private Hero mHero;

  @Before
  public void initialize() {
    mHero = new Hero("Superman", "Strength, Flight, Laser Eyes", "DC");
  }

  @After
  public void virginize() {
    Hero.clear();
  }

  @Test
  public void Hero_instantiatesCorrectly_true() {
    assertEquals(true, mHero instanceof Hero);
  }

  @Test
  public void getName_returnsName_Superman() {
    assertEquals("Superman", mHero.getName());
  }

  @Test
  public void getAbility_returnsAbility_Strength(){
    assertEquals("Strength, Flight, Laser Eyes", mHero.getAbility());
  }

  @Test
  public void getUniverse_returnsUniverse_DC(){
    assertEquals("DC", mHero.getUniverse());
  }

  @Test
  public void all_returnsAllInstancesOfHero_true(){
    Hero anotherHero = new Hero("Spiderman", "Strength, Agility, Climbing", "Marvel");
    assertEquals(true, Hero.all().contains(mHero));
    assertEquals(true, Hero.all().contains(anotherHero));
  }

  @Test
  public void clear_emptiesAllHerosFromList_0() {
    Hero.clear();
    assertEquals(0, Hero.all().size());
  }

  @Test
  public void getId_returnsInstantiateWithAnId_1(){
    assertEquals(1, mHero.getId());
  }

  @Test
  public void find_returnsHeroWithSameId_AnotherHero(){
    Hero anotherHero = new Hero("Spiderman", "Strength, Agility, Climbing", "Marvel");
    assertEquals(anotherHero, Hero.find(anotherHero.getId()));
  }
}
