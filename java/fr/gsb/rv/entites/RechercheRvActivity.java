package fr.gsb.rv.entites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;


public class RechercheRvActivity extends MenuRvActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche);

        Spinner monthSpinner = findViewById(R.id.monthSpinner);
        Spinner yearSpinner = findViewById(R.id.yearSpinner);
        Button validerButton = findViewById(R.id.button6);
        Button buttonRetour = findViewById(R.id.button9);

        List<String> months = new ArrayList<>();
        for (int i = 01; i <= 12; i++) {
            months.add(String.valueOf(i));
        }
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        List<String> years = new ArrayList<>();
        for (int i = 1990; i <= 2030; i++) {
            years.add(String.valueOf(i));
        }
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RechercheRvActivity.this, ListeRvActivity.class) ;
                String anneeSelectionne = yearSpinner.getSelectedItem().toString();
                String moisSelectionne = monthSpinner.getSelectedItem().toString();

                intent.putExtra("annee",anneeSelectionne);
                intent.putExtra("mois",moisSelectionne);
                startActivity(intent);
            }
        });

        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RechercheRvActivity.this, MenuRvActivity.class);
                startActivity(intent);
            }
        });

    }
}