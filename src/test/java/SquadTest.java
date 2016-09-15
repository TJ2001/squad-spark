import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

  @After
  public void virginize() {
    Squad.clear();
  }

  @Test
  public void Squad_instantiatesCorrectly_true() {
    Squad testSquad = new Squad("Superman");
    assertEquals(true, testSquad instanceof Squad);
  }

  @Test
  public void getOrganization_organizationInstantiatesWithOrganization_Avengers() {
    Squad testSquad = new Squad("Avengers");
    assertEquals("Avengers", testSquad.getOrganization());
  }

  @Test
  public void all_returnsAllInstancesOfSquad_true() {
    Squad testSquadOne = new Squad("Avengers");
    Squad testSquadTwo = new Squad("X-men");
    assertEquals(true, Squad.all().contains(testSquadOne));
    assertEquals(true, Squad.all().contains(testSquadTwo));
  }

  @Test
  public void clear_emptiesAllSquadsFromList_0() {
    Squad testSquad = new Squad("Avengers");
    Squad.clear();
    assertEquals(Squad.all().size(), 0);
  }

  @Test
  public void getId_squadInstantiatesWithAnId_1() {
    Squad testSquad = new Squad("Avengers");
    assertEquals(1, testSquad.getId());
  }

  // @Test
  // public void find_returnsSquadFromId_Avengers() {
  //   Squad.clear();
  //   Squad testSquad = new Squad("Avengers");
  //   assertEquals("Avengers", Squad.find(testSquad.getId()));
  // }

  @Test
  public void find_returnsSquadWithSameId_Avengers() {
    Squad testSquadOne = new Squad("Avengers");
    Squad testSquadTwo = new Squad("X-men");
    assertEquals(Squad.find(testSquadTwo.getId()), testSquadTwo);
  }

  @Test
  public void getHeroes_initiallyReturnsEmptyList_ArrayList() {
    Squad testSquad = new Squad("Avengers");
    assertEquals(0, testSquad.getHeroes().size());
  }

  // @Test
  // public void addHeroes_addHeroToList_true(){
  //   Squad.clear();
  //   Hero testHero = new Hero("Captain America");
  //   Squad testSquad = new Squad("Avengers");
  //   testSquad.addHero(testHero);
  //   assertTrue(testSquad.getTasks().contains(testHero));
  // }
}
