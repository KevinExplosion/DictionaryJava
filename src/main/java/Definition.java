import java.util.ArrayList;

public class Definition {
  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  private String mDefinition;
  private String mPartOfSpeech;
  private int mId;

  public Definition(String partOfSpeech, String definition) {
    mDefinition = definition;
    mPartOfSpeech = partOfSpeech;
    instances.add(this);
    mId = instances.size();
  }

  public String getDefinition() {
    return mDefinition;
  }

  public String getPartOfSpeech() {
    return mPartOfSpeech;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

  public static Definition find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }
}
