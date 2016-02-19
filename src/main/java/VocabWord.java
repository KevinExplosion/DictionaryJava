import java.util.ArrayList;

public class VocabWord {
  private static ArrayList<VocabWord> instances = new ArrayList<VocabWord>();

  private String mVocabWord;
  private String mPartOfSpeech;
  private int mId;
  private ArrayList<Definition> mDefinitions;

  public VocabWord(String vocabWord, String partOfSpeech){
    mVocabWord = vocabWord;
    mPartOfSpeech = partOfSpeech;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getVocabWord() {
    return mVocabWord;
  }

  public String getPartOfSpeech() {
    return mPartOfSpeech;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<VocabWord> all() {
    return instances;
  }

  public static VocabWord find(int id) {
    try {
      return instances.get(id -1);
    }
    catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }
}
