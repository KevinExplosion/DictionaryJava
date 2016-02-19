import java.util.ArrayList;

public class VocabWord {

  private String mVocabWord;
  private String mPartOfSpeech;

  public VocabWord(String vocabWord, String partOfSpeech){
    mVocabWord = vocabWord;
    mPartOfSpeech = partOfSpeech;
  }

  public String getVocabWord() {
    return mVocabWord;
  }
}
