import java.time.LocalDateTime;

import org.junit.*;
import static org.junit.Assert.*;

public class VocabWordTest {

  @Test
  public void vocabWord_instantiatesCorrectly_true() {
    VocabWord myVocabWord = new VocabWord("school", "noun");
    assertEquals(true, myVocabWord instanceof VocabWord);
  }
}
