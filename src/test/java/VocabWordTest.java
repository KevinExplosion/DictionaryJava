import java.time.LocalDateTime;

import org.junit.*;
import static org.junit.Assert.*;

public class VocabWordTest {

  @Test
  public void vocabWord_instantiatesCorrectly_true() {
    VocabWord myVocabWord = new VocabWord("school");
    assertEquals(true, myVocabWord instanceof VocabWord);
  }

  @Test
  public void vocabWord_instantiatesWithTerm_true() {
    VocabWord myVocabWord = new VocabWord("school");
    assertEquals("school", myVocabWord.getTerm());
  }

  @Test
  public void all_returnsAllInstancesOfVocabWord_true() {
    VocabWord firstVocabWord = new VocabWord("school");
    VocabWord secondVocabWord = new VocabWord("learn");
    assertTrue(VocabWord.all().contains(firstVocabWord));
    assertTrue(VocabWord.all().contains(secondVocabWord));
  }

  @Test
  public void newId_vocabWordInstantiatesWithAnId_true() {
    VocabWord myVocabWord = new VocabWord("school");
    assertEquals(VocabWord.all().size(), myVocabWord.getId());
  }

  @Test
  public void find_returnsNullWhenNoVocabWordFound_null() {
    assertTrue(VocabWord.find(999) == null);
  }
}
