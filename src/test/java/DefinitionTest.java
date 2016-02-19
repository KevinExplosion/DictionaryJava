import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("A place you attend to learn");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void definition_instantiatesAsDefinition() {
    Definition myDefinition = new Definition("A place of learning");
    assertEquals("A place of learning", myDefinition.getDefinition());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("A place of learning");
    Definition secondDefinition = new Definition("Gaining new knowledge");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }
}
