package com.example.dotacasebattle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class InventoryFragment extends Fragment {

    private InventoryManager manager;
    private HeroAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);

        manager = new InventoryManager(requireContext());
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        TextView tvEmpty = view.findViewById(R.id.tvEmpty);

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<Hero> heroes = manager.getHeroes();
        adapter = new HeroAdapter(heroes, index -> {
            manager.removeHero(index);
            refreshList(tvEmpty);
        });
        recyclerView.setAdapter(adapter);

        refreshList(tvEmpty);
        return view;
    }

    private void refreshList(TextView tvEmpty) {
        List<Hero> heroes = manager.getHeroes();
        adapter.updateData(heroes);
        tvEmpty.setVisibility(heroes.isEmpty() ? View.VISIBLE : View.GONE);
    }
}
