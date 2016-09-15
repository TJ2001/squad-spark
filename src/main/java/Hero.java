import java.util.ArrayList;
import java.util.List;

public class Hero {
  private String mName;
  private String mAbility;
  private String mUniverse;
  private static List<Hero> instances = new ArrayList<Hero>();
  private int mId;

  public Hero(String name, String ability, String universe) {
    mName = name;
    mAbility = ability;
    mUniverse = universe;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public String getAbility() {
    return mAbility;
  }

  public String getUniverse(){
    return mUniverse;
  }

  public static List<Hero> all(){
    return instances;
  }

  public static void clear(){
    instances.clear();
  }


  public int getId() {
    return mId;
  }

  public static Hero find(int id){
    return instances.get(id - 1);
  }
}
