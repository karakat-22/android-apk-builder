package com.example.sampleapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    public interface OnDeleteListener {
        void onDelete(int index);
    }

    private List<Hero> heroes;
    private OnDeleteListener deleteListener;

    public HeroAdapter(List<Hero> heroes, OnDeleteListener listener) {
        this.heroes = heroes;
        this.deleteListener = listener;
    }

    public void updateData(List<Hero> newHeroes) {
        this.heroes = newHeroes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(android.R.layout.simple_list_item_2, parent, false);
        // Для простоты используем стандартный layout.
        // В реальном проекте создайте свой item_hero.xml
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hero hero = heroes.get(position);
        holder.tvName.setText(hero.name);

        int color;
        switch (hero.rarity) {
            case 0: color = Color.parseColor("#9e9e9e"); break; // Серый
            case 1: color = Color.parseColor("#4caf50"); break; // Зелёный
            case 2: color = Color.parseColor("#2196f3"); break; // Синий
            case 3: color = Color.parseColor("#9c27b0"); break; // Фиолетовый
            case 4: color = Color.parseColor("#ff9800"); break; // Золотой
            default: color = Color.WHITE;
        }
        holder.tvName.setTextColor(color);
        holder.tvRarity.setText(hero.getRarityName());
        holder.tvRarity.setTextColor(color);
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvRarity;

        ViewHolder(View v) {
            super(v);
            tvName = v.findViewById(android.R.id.text1);
            tvRarity = v.findViewById(android.R.id.text2);
        }
    }
}
