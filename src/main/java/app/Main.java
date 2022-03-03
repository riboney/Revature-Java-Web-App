package app;

import app.models.Pk;
import app.utils.PkType;
import app.utils.PkUtils;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;
import io.javalin.Javalin;
import io.javalin.http.ExceptionHandler;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.template.JavalinJte;

import java.nio.file.Paths;
import java.util.*;

public class Main {

    private static List<Pk> allPokemons;
    private static List<Pk> displayPokemons;
    private static String currentFilter;
    private static String POKEMON_FILE = "pokemons.csv";
    private static boolean isDevSystem;

    public static void main(String[] args) {
        isDevSystem = System.getenv("ENV_VAR") != null && System.getenv("ENV_VAR").equals("prod") ? false:true;
        JavalinJte.configure(createTemplateEngine());
        System.out.println(isDevSystem);
        Javalin app = Javalin.create().start(getHerokuAssignedPort());
        allPokemons = PkUtils.initializePks(POKEMON_FILE);
        displayPokemons = PkUtils.clonePkList(allPokemons);
        currentFilter = "ALL";

        app.get("/", homeHandler);
        app.post("/", filterByPkTypeHandler);
        app.post("/pokemon", queryByPkNameHandler);
        app.get("/pokemon/{pokedex}", linkToPkHandler);
        app.exception(NullPointerException.class, npeHandler);
    }

    // https://javalin.io/tutorials/heroku
    private static int getHerokuAssignedPort() {
        String herokuPort = System.getenv("PORT");
        if (herokuPort != null) {
            return Integer.parseInt(herokuPort);
        }
        return 7000;
    }

    // src: https://javalin.io/tutorials/jte
    private static TemplateEngine createTemplateEngine() {
        if (isDevSystem) {
            DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(Paths.get("src", "main", "jte"));
            return TemplateEngine.create(codeResolver, ContentType.Html);
        } else {
            return TemplateEngine.createPrecompiled(Paths.get("jte-classes"), ContentType.Html);
        }
    }

    private static Handler homeHandler = ctx -> {
        Map<String, Object> params = new HashMap<>();
        params.put("pokemons", displayPokemons);
        params.put("currentFilter", currentFilter);
        ctx.render("home.jte", params);
    };

    private static Handler filterByPkTypeHandler = ctx -> {
        String rawType = ctx.formParam("type");
        currentFilter = rawType.toUpperCase();
        displayPokemons = rawType.equalsIgnoreCase("all") ?
                PkUtils.clonePkList(allPokemons) :
                PkUtils.filterPkList(allPokemons, pokemon -> pokemon.getType1() == PkType.valueOf(rawType));

        ctx.redirect("/");
    };

    private static Handler queryByPkNameHandler = ctx -> {
        Pk pk = PkUtils.findSinglePk(allPokemons, pokemon -> pokemon.getName().equalsIgnoreCase(ctx.formParam("name")));
        ctx.redirect("/pokemon/" + pk.getPokedex());
    };

    private static Handler linkToPkHandler = ctx -> {
      int pokedex = Integer.parseInt(ctx.pathParam("pokedex"));
      Pk pk = PkUtils.findSinglePk(allPokemons, pokemon -> pokemon.getPokedex() == pokedex);

      ctx.render("pokemon.jte", Collections.singletonMap("pokemon", pk));
    };

    private static ExceptionHandler npeHandler = (exception, ctx) -> {
        System.out.println("Exception message: " + exception.getMessage());
        ctx.render("error.jte", Collections.singletonMap("error", exception.getMessage()));
    };
}
