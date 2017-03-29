import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("doctor-form", "templates/doctor-add.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/create-user", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("doctor-form", "templates/doctor-add.vtl");
      object.update(desc);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    patch("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("doctor-form", "templates/doctor-add.vtl");
      object.update(desc);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
