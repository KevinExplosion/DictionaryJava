import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class ChangeTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

// Unit testing
  // @Test
  // public void changeCalculator_convertsTwentyfivePenniesTo_OneQuarter() {
  //   Change testChange = new Change();
  //   Integer[] change = {1, 0, 0, 0};
  //   Integer[] tillContents = {100, 100, 100, 100};
  //   assertEquals(change, testChange.changeCalculator(25, tillContents));
  // }


  //Integration testing
    @Test
    public void rootTest() {
        goTo("http://localhost:4567/change");
        assertThat(pageSource()).contains("Input the number of cents");
    }

    // @Test
    // public void fillFormTest() {
    //     goTo("http://localhost:4567/change");
    //     fill("#changeInput").with("33");
    //     submit("#submit");
    //     assertThat(pageSource()).contains("Your change for");
    // }
}