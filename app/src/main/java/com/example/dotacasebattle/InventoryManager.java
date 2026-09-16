package com.example.dotacasebattle;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private static final String PREF_NAME = "DotaInventory";
    private static final String KEY_HEROES = "owned_heroes";
    private SharedPreferences prefs;
    private Gson gson = new Gson();

    public InventoryManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void addHero(Hero hero) {
        List<Hero> heroes = getHeroes();
        heroes.add(hero);
        saveHeroes(heroes);
    }

    public void removeHero(int index) {
        List<Hero> heroes = getHeroes();
        if (index >= 0 && index < heroes.size()) {
            heroes.remove(index);
            saveHeroes(heroes);
        }
    }

    public List<Hero> getHeroes() {
        String json = prefs.getString(KEY_HEROES, null);
        if (json == null) return new ArrayList<>();
        Type type = new TypeToken<ArrayList<Hero>>(){}.getType();
        return gson.fromJson(json, type);
    }

    private void saveHeroes(List<Hero> heroes) {
        prefs.edit().putString(KEY_HEROES, gson.toJson(heroes)).apply();
    }
}
