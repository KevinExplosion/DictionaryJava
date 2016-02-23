import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) ->{
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("vocabWords", VocabWord.all());
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("vocabWords/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/vocabWord-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/vocabWords/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      VocabWord vocabWord = VocabWord.find(Integer.parseInt(request.params(":id")));
      ArrayList<Definition> definitions = vocabWord.getDefinitions();
      model.put("vocabWord", vocabWord);
      model.put("definitions", definitions);
      model.put("template", "templates/vocabWord.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Word word = new Word(name);
      model.put("words", Word.all());
      model.put("word", word);
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
      ArrayList<Definition> definitions = word.getDefinitions();
      String description = request.queryParams("description");
      Definition newDefinition = new Definition(description);
      definitions.add(newDefinition);
      model.put("definitions", definitions);
      model.put("word", word);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
