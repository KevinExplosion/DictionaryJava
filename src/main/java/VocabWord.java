import java.util.ArrayList;

public class VocabWord {
  private static ArrayList<VocabWord> instances = new ArrayList<VocabWord>();

  private String mName;
  private int mId;
  private ArrayList<Definition> mDefinitions;

  public VocabWord(String name){
    mName = name;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getName() {
    return mName;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<VocabWord> all() {
    return instances;
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public static VocabWord find(int id) {
    try {
      return instances.get(id -1);
    }
    catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }
}
