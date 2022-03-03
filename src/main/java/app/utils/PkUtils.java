package app.utils;

import app.models.Pk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PkUtils {

    public static List<Pk> mapManyToPk(List<String[]> values){
        return values
                .stream()
                .map(PkUtils::mapSingleToPK)
                .filter(item -> item != null)
                .collect(Collectors.toList());
    }

    // TODO: Improve value mapping (use JSON instead of array?)
    public static Pk mapSingleToPK(String[] values){
        //  Expected values order: #,Name,Type 1,Type 2,HP,Attack,Defense, Image
        if(values.length < 8) throw new IllegalArgumentException("Values doesn't match correct format!");
        else if(values[1].toLowerCase().contains("mega")) return null;
        else {
            String type2 = values[3].isEmpty() ? "NONE":values[3];
            return new Pk.Builder()
                    .pokedex(Integer.parseInt(values[0]))
                    .name(values[1])
                    .type1(PkType.valueOf(values[2].toUpperCase()))
                    .type2(PkType.valueOf(type2.toUpperCase()))
                    .hp(Integer.parseInt(values[5]))
                    .attack(Integer.parseInt(values[6]))
                    .defense(Integer.parseInt(values[7]))
                    .build();
        }
    }

    // Deep copy List<Pk>
    // Why I used this and not clone(): http://www.javapractices.com/topic/TopicAction.do?Id=71
    public static List<Pk> clonePkList(List<Pk> pkList){
        return pkList
                .stream()
                .map(pk -> new Pk.Builder(pk).build())
                .collect(Collectors.toList());
    }

    // src: https://stackoverflow.com/a/48839294
    public static Pk findSinglePk(List<Pk> pkList, Predicate<Pk> searchConditions){

        Supplier npe = () -> new NullPointerException("Pokemon not found!");

        return pkList
                .stream()
                .filter(searchConditions)
                .findFirst()
                .orElseThrow(npe);
    }

    public static List<Pk> filterPkList(List<Pk> pkList, Predicate<Pk> filter){
        return pkList
                .stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    // Todo: improve this method
    public static List<Pk> initializePks(String filename){
        String[] defaultPokemon = {"25","Pikachu","ELECTRIC","NONE",
                "35","55","40", "https://img.pokemondb.net/sprites/silver/normal/pikachu.png"};

        Optional<List<String[]>> rawValues =
                Optional.ofNullable(CSVReader.getListFromFile(filename));

        // Todo: upgrade to JDK version to use List.of(...)
        List<String[]> fallbackValue = new ArrayList<>();
        fallbackValue.add(defaultPokemon);

        return mapManyToPk(rawValues.orElse(fallbackValue));
    }
}
