import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class HeroTest {
  // private Hero mHero;
  //
  // @Before
  // public void initialize() {
  //   mHero = new Hero("Superman", "Strength, Flight, Laser Eyes", "DC");
  // }
  //
  // @After
  // public void virginize() {
  //   Hero.clear();
  // }

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/to_do_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM tasks *;";
      String deleteSquadsQuery = "DELETE FROM squads *;";
      con.createQuery(sql).executeUpdate();
      con.createQuery(deleteSquadsQuery).executeUpdate();
    }
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAretheSame() {
    Hero firstHero = new Hero("Batman", "Wealth, Intelligence, Focus", "DC");
    Hero secondHero = new Hero("Spiderman", "Strength, Agility, Climbing", "Marvel");
    assertTrue(firstHero.equals(secondHero));
  }

  @Test
  public void Hero_instantiatesCorrectly_true() {
    Hero firstHero = new Hero("Batman", "Wealth, Intelligence, Focus", "DC");
    assertEquals(true, firstHero instanceof Hero);
  }

  @Test
  public void getName_returnsName_Superman() {
    Hero firstHero = new Hero("Batman", "Wealth, Intelligence, Focus", "DC");
    assertEquals("Superman", firstHero.getName());
  }

  @Test
  public void getAbility_returnsAbility_Strength(){
    Hero firstHero = new Hero("Batman", "Wealth, Intelligence, Focus", "DC");
    assertEquals("Strength, Flight, Laser Eyes", firstHero.getAbility());
  }

  @Test
  public void getUniverse_returnsUniverse_DC(){
    Hero firstHero = new Hero("Batman", "Wealth, Intelligence, Focus", "DC");
    assertEquals("DC", firstHero.getUniverse());
  }

  @Test
  public void all_returnsAllInstancesOfHero_true(){
    Hero firstHero = new Hero("Batman", "Wealth, Intelligence, Focus", "DC");
    firstHero.save();
    Hero secondHero = new Hero("Spiderman", "Strength, Agility, Climbing", "Marvel");
    secondHero.save();
    assertEquals(true, Hero.all().get(0).equals(firstHero));
    assertEquals(true, Hero.all().get(1).equals(secondHero));
  }

  // @Test
  // public void clear_emptiesAllHerosFromList_0() {
  //   Hero.clear();
  //   assertEquals(0, Hero.all().size());
  // }

  @Test
  public void getId_returnsInstantiateWithAnId_1(){
    Hero myHero = new Hero("Batman", "Wealth, Intelligence, Focus", "DC");
    myHero.save();
    assertTrue(myHero.getId() > 0);
  }

  @Test
  public void find_returnsHeroWithSameId_AnotherHero(){
    Hero firstHero = new Hero("Batman", "Wealth, Intelligence, Focus", "DC");
    firstHero.save();
    Hero anotherHero = new Hero("Spiderman", "Strength, Agility, Climbing", "Marvel");
    anotherHero.save();
    assertEquals(Hero.find(anotherHero.getId()), anotherHero);
  }

  @Test
  public void save_returnsTrueIfNamesAreTheSame() {
    Hero myHero = new Hero("Batman", "Wealth, Intelligence, Focus", "DC");
    myHero.save();
    assertTrue(Hero.all().get(0).equals(myHero));
  }

  @Test
  public void save_assignsIdToObject() {
    Hero myHero = new Hero("Batman", "Wealth, Intelligence, Focus", "DC");
    myHero.save();
    Hero savedHero = Hero.all().get(0);
    assertEquals(myHero.getId(), savedHero.getId());
  }
}
