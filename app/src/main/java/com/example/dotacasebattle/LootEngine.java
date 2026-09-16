package com.example.sampleapp;

import java.util.List;
import java.util.Random;

public class LootEngine {
    private static final int[] RARITY_CHANCES = {50, 25, 15, 8, 2};

    public static Hero openCase(String attribute) {
        int rarity = rollRarity();
        List<Hero> heroes = GameData.getHeroesByAttribute(attribute);

        // Фильтруем героев по выпавшей редкости
        List<Hero> filtered = new java.util.ArrayList<>();
        for (Hero h : heroes) {
            if (h.rarity == rarity) filtered.add(h);
        }

        // Если героев такой редкости нет — берём любого из пула
        if (filtered.isEmpty()) return heroes.get(new Random().nextInt(heroes.size()));

        return filtered.get(new Random().nextInt(filtered.size()));
    }

    private static int rollRarity() {
        int roll = new Random().nextInt(100) + 1;
        int cumulative = 0;
        for (int i = 0; i < RARITY_CHANCES.length; i++) {
            cumulative += RARITY_CHANCES[i];
            if (roll <= cumulative) return i;
        }
        return 0;
    }
}
