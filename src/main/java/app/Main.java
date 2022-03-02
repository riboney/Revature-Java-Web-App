package app;

import app.models.Pk;
import app.utils.PkType;
import app.utils.PkUtils;
import io.javalin.Javalin;
import io.javalin.http.ExceptionHandler;
import io.javalin.http.Handler;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    private static List<Pk> allPokemons;
    private static List<Pk> displayPokemons;
    private static String POKEMON_FILE = "pokemons.csv";

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        allPokemons = PkUtils.initializePks(POKEMON_FILE);
        displayPokemons = PkUtils.clonePkList(allPokemons);

        app.get("/", homeHandler);
        app.post("/", filterByPkTypeHandler);
        app.post("/pokemon", queryByPkNameHandler);
        app.get("/pokemon/{pokedex}", linkToPkHandler);
        app.exception(NullPointerException.class, npeHandler);
    }

    private static Handler homeHandler = ctx -> {
        ctx.render("home.jte", Collections.singletonMap("pokemons", displayPokemons));
    };

    private static Handler filterByPkTypeHandler = ctx -> {
        String rawType = ctx.formParam("type");
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
