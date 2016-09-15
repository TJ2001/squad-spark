import java.util.List;
import java.util.ArrayList;

public class Squad {
  private String mTeam;
  private static ArrayList<Squad> instances = new ArrayList<Squad>();
  private int mId;
  private List<Hero> mHeroes;

  public Squad(String team) {
    mTeam = team;
    instances.add(this);
    mId = instances.size();
    mHeroes = new ArrayList<Hero>();
  }

  public String getTeam() {
    return mTeam;
  }

  public static ArrayList<Squad> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Squad find(int id) {
    return instances.get(id - 1);
  }

  public List<Hero> getHeroes() {
    return mHeroes;
  }

  public void addHero(Hero hero) {
    mHeroes.add(hero);
  }
}
