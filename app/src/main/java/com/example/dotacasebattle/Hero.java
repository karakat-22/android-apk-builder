package com.example.dotacasebattle;

public class Hero {
    public String name;
    public String attribute; // "str", "agi", "int", "uni"
    public int rarity; // 0-Обычный, 1-Редкий, 2-Эпический, 3-Мифический, 4-Легендарный

    public Hero(String name, String attribute, int rarity) {
        this.name = name;
        this.attribute = attribute;
        this.rarity = rarity;
    }

    public String getRarityName() {
        switch (rarity) {
            case 0: return "Обычный";
            case 1: return "Редкий";
            case 2: return "Эпический";
            case 3: return "Мифический";
            case 4: return "Легендарный";
            default: return "Неизвестный";
        }
    }
}
