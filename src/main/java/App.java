import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

//home page
    get("/", (request, resopnse) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("vocabWords", VocabWord.all());
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/vocabWord", (request, response) ->{
      HashMap<String, Object> model = new HashMap<String, Object>();
      String term = request.queryParams("vocabWord");
      VocabWord vocabWord = new VocabWord(term);
      model.put("vocabWords", VocabWord.all());
      model.put("template", "templates/words.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
