import java.util.ArrayList;

public class Definition {
  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  private String mDescription;
  private String mPartOfSpeech;
  private int mId;

  public Definition(String partOfSpeech, String description) {
    mDescription = description;
    mPartOfSpeech = partOfSpeech;
    instances.add(this);
    mId = instances.size();
  }

  public String getDescription() {
    return mDescription;
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
