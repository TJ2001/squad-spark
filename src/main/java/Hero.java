import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;


public class Hero {
  private String name;
  private String ability;
  private String universe;
  // private static List<Hero> instances = new ArrayList<Hero>();
  private int id;
  private int squadId;

  public Hero(String name, String ability, String universe) {
    this.name = name;
    this.ability = ability;
    this.universe = universe;
    this.squadId = squadId;
    // instances.add(this);
    // mId = instances.size();
  }

  public String getName() {
    return name;
  }

  public String getAbility() {
    return ability;
  }

  public String getUniverse(){
    return universe;
  }

  public int getSquadId() {
    return squadId;
  }

  public int getId() {
    return id;
  }

  public static List<Hero> all() {
    String sql = "SELECT id, name FROM heroes";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Hero.class);
    }
  }

  @Override
  public boolean equals(Object otherHero) {
    if(!(otherHero instanceof Hero)) {
      return false;
    } else {
      Hero newHero = (Hero) otherHero;
      return this.getName().equals(newHero.getName()) &&
      this.getId() == newHero.getId() &&
      this.getSquadId() == newHero.getSquadId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO heroes (name, squadId) VALUES (:name, :squadId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("squadId", this.squadId)
        .executeUpdate()
        .getKey();
    }
  }

  public static Hero find(int id){
    // return instances.get(id - 1);
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM heroes where id=:id";
      Hero hero = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Hero.class);
      return hero;
    }
  }
}
