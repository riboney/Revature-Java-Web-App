package app.models;

import app.utils.PkType;

import java.net.MalformedURLException;
import java.net.URL;

public class Pk {

    private final int pokedex;
    private final String name;
    private final PkType type1;
    private final PkType type2;
    private final int hp;
    private final int attack;
    private final int defense;
    private final URL image;

    private Pk(Builder builder){
        this.pokedex = builder.pokedex;
        this.name = builder.name;
        this.type1 = builder.type1;
        this.type2 = builder.type2;
        this.hp = builder.hp;
        this.attack = builder.attack;
        this.defense = builder.defense;
        this.image = createImageURL();
    }

    private URL createImageURL(){
        String imageBaseURL = "https://img.pokemondb.net/sprites/silver/normal/";
        String imageURL = imageBaseURL + name.toLowerCase() + ".png";
        try {
            return new URL(imageURL);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Image URL not valid!");
        }
    }

    public int getPokedex() {
        return pokedex;
    }

    public String getName() {
        return name;
    }

    public PkType getType1() {
        return type1;
    }

    public PkType getType2() {
        return type2;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public URL getImageURL() {
        return image;
    }

    @Override
    public String toString() {
        return this.name +
                " Pokedex #: " + pokedex +
                " Type1: " + type1 +
                ", Type2: " + type2 +
                ", hp: " + hp +
                ", attack: " + attack +
                ", defense: " + defense;
    }

    // src: https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java
    public static class Builder {
        private int pokedex;
        private String name;
        private PkType type1;
        private PkType type2;
        private int hp;
        private int attack;
        private int defense;

        // Todo: ensure pokedex is unique among all pokemon
        public Builder pokedex(int pokedex){
            this.pokedex = pokedex;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type1(PkType type1) {
            this.type1 = type1;
            return this;
        }

        public Builder type2(PkType type2) {
            this.type2 = type2;
            return this;
        }

        public Builder hp(int hp) {
            if(hp > 0){
                this.hp = hp;
                return this;
            }
            else throw new IllegalArgumentException("HP cannot be lower than 0!");
        }

        public Builder attack(int attack) {
            if(attack > 0){
                this.attack = attack;
                return this;
            }
            else throw new IllegalArgumentException("Attack cannot be lower than 0!");
        }

        public Builder defense(int defense) {
            if(defense > 0){
                this.defense = defense;
                return this;
            }
            else throw new IllegalArgumentException("Defense cannot be lower than 0!");
        }

        // TODO: come up with better way to validate
        private void validate(){
            if(pokedex == 0) throw new IllegalStateException("Pokedex number is required");
            if(name == null) throw new IllegalStateException("Name is required");
            if(type1 == null) throw new IllegalStateException("Type1 is required");
            if(type2 == null) throw new IllegalStateException("Type2 is required");
            if(hp == 0) throw new IllegalStateException("HP is required");
            if(attack == 0) throw new IllegalStateException("Attack value is required");
            if(defense == 0) throw new IllegalStateException("Defense value is required");
        }

        public Pk build(){
            validate();
            return new Pk(this);
        }

        // src: https://stackoverflow.com/a/16216853
        // why we shouldn't use Clone: http://www.javapractices.com/topic/TopicAction.do?Id=71
        public Builder(Pk pkCopy){
            this.pokedex = pkCopy.getPokedex();
            this.name = pkCopy.getName();
            this.type1 = pkCopy.getType1();
            this.type2 = pkCopy.getType2();
            this.hp = pkCopy.getHp();
            this.attack = pkCopy.getAttack();
            this.defense = pkCopy.getDefense();
        }

        // need explicit no-arg constructor
        public Builder(){}
    }
}
