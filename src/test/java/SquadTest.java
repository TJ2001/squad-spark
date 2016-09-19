import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {
  //
  // @After
  // public void virginize() {
  //   Squad.clear();
  // }

  @Before
  public void setUp(){
    DB.sql2o = new Sql2o("jdbc:postresql://localhost:5432/to_do_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteHeroesQuery = "DELETE FROM heroes *;";
      String deleteSquadsQuery = "DELETE FROM squads *;";
      con.createQuery(deleteHeroesQuery).executeUpdate();
      con.createQuery(deleteSquadsQuery).executeUpdate();
    }
  }

  @Test
  public void Squad_instantiatesCorrectly_true() {
    Squad testSquad = new Squad("Superman");
    assertEquals(true, testSquad instanceof Squad);
  }

  @Test
  public void getTeam_teamInstantiatesWithTeam_Avengers() {
    Squad testSquad = new Squad("Avengers");
    assertEquals("Avengers", testSquad.getTeam());
  }

  @Test
  public void all_returnsAllInstancesOfSquad_true() {
    Squad testSquadOne = new Squad("Avengers");
    Squad testSquadTwo = new Squad("X-men");
    assertEquals(true, Squad.all().contains(testSquadOne));
    assertEquals(true, Squad.all().contains(testSquadTwo));
  }
  //
  // @Test
  // public void clear_emptiesAllSquadsFromList_0() {
  //   Squad testSquad = new Squad("Avengers");
  //   Squad.clear();
  //   assertEquals(Squad.all().size(), 0);
  // }

  @Test
  public void getId_squadInstantiatesWithAnId_1() {
    Squad testSquad = new Squad("Avengers");
    assertEquals(1, testSquad.getId());
  }

  // @Test
  // public void find_returnsSquadWithSameId_testSquadTwo() {
  //   Squad testSquadOne = new Squad("Avengers");
  //   Squad testSquadTwo = new Squad("X-men");
  //   assertEquals(Squad.find(testSquadTwo.getId()), testSquadTwo);
  // }

  // @Test
  // public void getHeroes_initiallyReturnsEmptyList_ArrayList() {
  //   Squad testSquad = new Squad("Avengers");
  //   assertEquals(0, testSquad.getHeroes().size());
  // }

  // @Test
  // public void addHeroes_addHeroToList_true(){
  //   Squad.clear();
  //   Hero testHero = new Hero("Superman", "Strength, Flight, Laser Eyes", "DC");
  //   Squad testSquad = new Squad("Avengers");
  //   testSquad.addHero(testHero);
  //   assertTrue(testSquad.getHeroes().contains(testHero));
  // }

  @Test
  public void equals_returnTrueIfNamesAretheSame() {
    Squad firstSquad = new Squad("Avengers");
    Squad secondSquad = new Squad("X-men");
    assertTrue(firstSquad.equals(secondSquad));
  }

  // @Override
  // public boolean equals(Object otherSquad) {
  //   if (!(otherSquad instanceof Squad)) {
  //     return false;
  //   } else {
  //     Squad newSquad = (Squad) otherSquad;
  //     return this.getTeam().equals(newSquad.getTeam());
  //   }
  // }

  @Test
  public void getHeros_retrievesALlHerosFromDatabase_heroesList() {
    Squad mySquad = new Squad("Household chores");
    mySquad.save();
    Hero firstHero = new Hero("Mow the lawn", mySquad.getId());
    firstHero.save();
    Hero secondHero = new Hero("Do the dishes", mySquad.getId());
    secondHero.save();
    Hero[] tasks = new Hero[] { firstHero, secondHero };
    assertTrue(mySquad.getHeroes().containsAll(Arrays.asList(heroes)));
  }


}
