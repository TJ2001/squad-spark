// import java.util.Map;
// import java.util.HashMap;
// import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
// import static spark.Spark.*;
//
// public class App {
//   public static void main(String[] args) {
//     staticFileLocation("/public");
//     String layout = "templates/layout.vtl";
//
//     get("/", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("template", "templates/index.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/squads", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("squads", Squad.all());
//       model.put("template", "templates/squads.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/squads/new", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("template", "templates/squads-form.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/squads", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       String team = request.queryParams("team");
//       Squad newSquad = new Squad(team);
//       System.out.println(newSquad);
//       // model.put("squad", newSquad);
//       // model.put("template", "templates/squads.vtl");
//       response.redirect("/squads/" + newSquad.getId());
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/squads/:id", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       Squad squad = Squad.find(Integer.parseInt(request.params(":id"
//       )));
//       model.put("squad", squad);
//       model.put("template", "templates/squad.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     get("/squads/:id/heroes/new", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
//       model.put("squad", squad);
//       model.put("template", "templates/hero-form.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/heroes", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       Integer squadId = Integer.parseInt(request.queryParams("squadId"));
//       Squad squad = Squad.find(squadId);
//
//       String name = request.queryParams("name");
//       String ability = request.queryParams("ability");
//       String universe = request.queryParams("universe");
//       Hero newHero = new Hero(name, ability, universe);
//       squad.addHero(newHero);
//
//       model.put("squad", squad);
//       response.redirect("/squads/" + squadId);
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//   }
// }
