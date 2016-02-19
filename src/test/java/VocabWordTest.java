import java.time.LocalDateTime;

import org.junit.*;
import static org.junit.Assert.*;

public class VocabWordTest {

  @Test
  public void vocabWord_instantiatesCorrectly_true() {
    VocabWord myVocabWord = new VocabWord("school", "noun");
    assertEquals(true, myVocabWord instanceof VocabWord);
  }

  @Test
  public void vocabWord_instantiatesWithVocabularyWord_true() {
    VocabWord myVocabWord = new VocabWord("school", "noun");
    assertEquals("school", myVocabWord.getVocabWord());
  }

  @Test
  public void vocabWord_instantiatesWithPartOfSpeech_true() {
    VocabWord myVocabWord = new VocabWord("school", "noun");
    assertEquals("noun", myVocabWord.getPartOfSpeech());
  }

  @Test
  public void all_returnsAllInstancesOfVocabWord_true() {
    VocabWord firstVocabWord = new VocabWord("school", "noun");
    VocabWord secondVocabWord = new VocabWord("learn", "verb");
    assertTrue(VocabWord.all().contains(firstVocabWord));
    assertTrue(VocabWord.all().contains(secondVocabWord));
  }

  @Test
  public void newId_vocabWordInstantiatesWithAnId_true() {
    VocabWord myVocabWord = new VocabWord("school", "noun");
    assertEquals(VocabWord.all().size(), myVocabWord.getId());
  }

  @Test
  public void find_returnsNullWhenNoVocabWordFound_null() {
    assertTrue(VocabWord.find(999) == null);
  }
}
