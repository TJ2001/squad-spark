import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;


public class Squad {
  private String team;
  private int id;

  public Squad(String team) {
    this.team = team;
  }


  public String getTeam() {
    return team;
  }

  public static List<Squad> all() {
    String sql = "SELECT id, team FROM squads";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Squad.class);
    }
  }

  // public static void clear() {
  //   instances.clear();
  // }

  public int getId() {
    return id;
  }

  public static Squad find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM squads where id=:id";
      Squad squad = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Squad.class);
        return squad;
    }
  }

  public List<Hero> getHeroes() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM tasks where squadId=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Hero.class);
    }
  }

  @Override
  public boolean equals(Object otherSquad) {
    if (!(otherSquad instanceof Squad)) {
      return false;
    } else {
      Squad newSquad = (Squad) otherSquad;
      return this.getTeam().equals(newSquad.getTeam()) &&
      this.getId() == newSquad.getId();
    }
  }
  // public static Squad find(int id) {
  //   // return instances.get(id - 1);
  // }
  //


  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO squads (team) VALUES (:team)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("team", this.team)
        .executeUpdate()
        .getKey();
    }
  }


  // public void addHero(Hero hero) {
    // mHeroes.add(hero);
  // }


}
