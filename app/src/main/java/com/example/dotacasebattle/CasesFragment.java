package com.example.dotacasebattle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class CasesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cases, container, false);

        Button btnStrength = view.findViewById(R.id.btnStrength);
        Button btnAgility = view.findViewById(R.id.btnAgility);
        Button btnIntelligence = view.findViewById(R.id.btnIntelligence);
        Button btnUniversal = view.findViewById(R.id.btnUniversal);

        btnStrength.setOnClickListener(v -> openCase("str"));
        btnAgility.setOnClickListener(v -> openCase("agi"));
        btnIntelligence.setOnClickListener(v -> openCase("int"));
        btnUniversal.setOnClickListener(v -> openCase("uni"));

        return view;
    }

    private void openCase(String attribute) {
        Hero hero = LootEngine.openCase(attribute);
        InventoryManager manager = new InventoryManager(requireContext());
        manager.addHero(hero);

        Toast.makeText(requireContext(),
            "Выпал: " + hero.name + " [" + hero.getRarityName() + "]",
            Toast.LENGTH_LONG).show();
    }
}
