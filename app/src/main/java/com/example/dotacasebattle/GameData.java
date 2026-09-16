package com.example.dotacasebattle;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    public static List<Hero> getStrengthHeroes() {
        List<Hero> list = new ArrayList<>();
        list.add(new Hero("Axe", "str", 0));
        list.add(new Hero("Pudge", "str", 1));
        list.add(new Hero("Earthshaker", "str", 2));
        list.add(new Hero("Tiny", "str", 3));
        list.add(new Hero("Kunkka", "str", 4));
        list.add(new Hero("Sven", "str", 0));
        list.add(new Hero("Wraith King", "str", 1));
        list.add(new Hero("Dragon Knight", "str", 2));
        return list;
    }

    public static List<Hero> getAgilityHeroes() {
        List<Hero> list = new ArrayList<>();
        list.add(new Hero("Juggernaut", "agi", 0));
        list.add(new Hero("Phantom Assassin", "agi", 1));
        list.add(new Hero("Slark", "agi", 2));
        list.add(new Hero("Faceless Void", "agi", 3));
        list.add(new Hero("Anti-Mage", "agi", 4));
        list.add(new Hero("Drow Ranger", "agi", 0));
        list.add(new Hero("Mirana", "agi", 1));
        return list;
    }

    public static List<Hero> getIntelligenceHeroes() {
        List<Hero> list = new ArrayList<>();
        list.add(new Hero("Crystal Maiden", "int", 0));
        list.add(new Hero("Lina", "int", 1));
        list.add(new Hero("Invoker", "int", 2));
        list.add(new Hero("Storm Spirit", "int", 3));
        list.add(new Hero("Zeus", "int", 4));
        list.add(new Hero("Lion", "int", 0));
        return list;
    }

    public static List<Hero> getUniversalHeroes() {
        List<Hero> list = new ArrayList<>();
        list.add(new Hero("Abaddon", "uni", 0));
        list.add(new Hero("Bane", "uni", 1));
        list.add(new Hero("Batrider", "uni", 2));
        list.add(new Hero("Beastmaster", "uni", 3));
        list.add(new Hero("Brewmaster", "uni", 4));
        list.add(new Hero("Broodmother", "uni", 1));
        return list;
    }

    public static List<Hero> getHeroesByAttribute(String attribute) {
        switch (attribute) {
            case "str": return getStrengthHeroes();
            case "agi": return getAgilityHeroes();
            case "int": return getIntelligenceHeroes();
            case "uni": return getUniversalHeroes();
            default: return new ArrayList<>();
        }
    }
}
