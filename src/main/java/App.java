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
      model.put("template", "templates/index.vtl");
      model.put("create-user", "templates/create-user.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/admin", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/admin.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/create-user", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Boolean userAdmin = Boolean.parseBoolean(request.queryParams("userAdmin"));
      String userPassword = request.queryParams("userPassword");
      String userName = request.queryParams("userName");
      String userEmail = request.queryParams("userEmail");
      String userBirthday = request.queryParams("userBirthday");
      String userAddress = request.queryParams("userAddress");
      User newUser = new User(userAdmin, userPassword, userName, userEmail, userBirthday, userAddress);
      newUser.save();
      String adminUrl = String.format("/admin-backend/%d", newUser.getUserId());
      String userUrl = String.format("/user-backend/", newUser.getUserId());
      if(userAdmin){
        response.redirect(adminUrl);
      } else {
        response.redirect(userUrl);
      }
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/admin-backend", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      User findUser = User.find(Integer.parseInt(request.params("id")));
      model.put("template", "templates/backend.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // post("/edit-user", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   String userName = request.queryParams("userName");
    //   String userEmail = request.queryParams("userEmail");
    //   String userBirthday = request.queryParams("userBirthday");
    //   String userAddress = request.queryParams("userAddress");
    //   User newUser = new User(userName, userEmail, userBirthday, userAddress);
    //   newUser.update();
    //   model.put("template", "templates/index.vtl");
    //   model.put("edit-user", "templates/edit-user.vtl");
    //   model.put("new-user", newUser);
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    // get("/create-user/new/", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //
    //   model.put("template", "templates/index.vtl");
    //   model.put("new-user", newUser);
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    // get("/create-user/new/:id", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //
    //   model.put("template", "templates/index.vtl");
    //   model.put("new-user", newUser);
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

  }
}
