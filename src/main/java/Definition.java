import java.util.ArrayList;

public class Definition {
  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  private String mDefinition;
  private int mId;
  private ArrayList<Definition> mDefinitions;

  public Definition(String definition) {
    mDefinition = definition;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getDefinition() {
    return mDefinition;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Definition> all() {
    return instances;
  }
}
