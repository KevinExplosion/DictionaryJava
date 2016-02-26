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
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("vocabWords/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/wordDefinition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/wordDefinition/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      VocabWord myVocabWord = VocabWord.find(Integer.parseInt(request.params(":id")));
      ArrayList<Definition> definitions = myVocabWord.getDefinitions();
      model.put("vocabWord", myVocabWord);
      model.put("definitions", definitions);
      model.put("template", "templates/vocabWords.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/vocabWords", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      VocabWord vocabWord = new VocabWord(name);
      model.put("vocabWords", VocabWord.all());
      model.put("vocabWord", vocabWord);
      model.put("template", "templates/vocabWords.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/wordDefinitions/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      VocabWord vocabWord = VocabWord.find(Integer.parseInt(request.queryParams("vocabWordId")));
      ArrayList<Definition> definitions = vocabWord.getDefinitions();
      String description = request.queryParams("description");
      Definition newDefinition = new Definition(description);
      definitions.add(newDefinition);
      model.put("definitions", definitions);
      model.put("vocabWord", vocabWord);
      model.put("template", "templates/wordDefinitions.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
