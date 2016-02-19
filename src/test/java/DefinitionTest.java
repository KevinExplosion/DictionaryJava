import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("noun", "a place of learning");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void definition_instantiatesWithDefinition() {
    Definition myDefinition = new Definition("noun", "a place of learning");
    assertEquals("a place of learning", myDefinition.getDefinition());
  }

  @Test
  public void definition_instantiatesWithPartOfSpeech() {
    Definition myDefinition = new Definition("noun", "a place of learning");
    assertEquals("noun", myDefinition.getPartOfSpeech());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("noun", "a place of learning");
    Definition secondDefinition = new Definition("verb", "gaining new knowledge");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }
}
