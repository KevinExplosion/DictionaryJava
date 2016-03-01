import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/definitions", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("definitions", Definition.all());
      model.put("template", "templates/definitions.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("definitions/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/vocabWords", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("vocabWords", VocabWord.all());
      model.put("template", "templates/vocabWords.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("vocabWords/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/vocabWord-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get ("/vocabWords/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap< String, Object>();

      VocabWord vocabWord = VocabWord.find(Integer.parseInt(request.params(":id")));
      model.put("vocabWord", vocabWord);

      model.put("template", "templates/vocabWord.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("vocabWords/:id/definition/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      VocabWord vocabWord = VocabWord.find(Integer.parseInt(request.params(":id")));
      ArrayList<Definition> definitions = vocabWord.getDefinitions();
      model.put("vocabWord", vocabWord);
      model.put("definitions", definitions);
      model.put("template", "templates/vocabWord-definitions-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definitions", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      VocabWord vocabWord = VocabWord.find(Integer.parseInt(request.queryParams("vocabWordId")));
      ArrayList<Definition> definitions = vocabWord.getDefinitions();

      String description = request.queryParams("description");
      Definition newDefinition = new Definition(description);

      vocabWord.addDefinition(newDefinition);

      model.put("definitions", definitions);
      model.put("vocabWord", vocabWord);
      model.put("template", "templates/vocabWord.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/vocabWords", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      VocabWord vocabWord = new VocabWord(name);
      model.put("vocabWord", vocabWord);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/definitions/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Definition definition = Definition.find(Integer.parseInt(request.params(":id")));
      model.put("definition", definition);
      model.put("template", "templates/definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
