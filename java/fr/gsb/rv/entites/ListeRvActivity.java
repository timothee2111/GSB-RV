package fr.gsb.rv.entites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import fr.gsb.rv.modeles.ModeleGSB;

public class ListeRvActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listerapports);

        Intent intent = getIntent();
        String anneeSelectionne = intent.getStringExtra("annee");
        String moisSelectionne = intent.getStringExtra("mois");

        ModeleGSB modeleGSB = ModeleGSB.getInstance();
        ArrayList<RapVisite> filtreRVs = modeleGSB.FiltrationRV(anneeSelectionne, moisSelectionne);

        ListView listerapports = findViewById(R.id.listerapports);

        ArrayList<String> rvStringList = new ArrayList<>();
        for (RapVisite rv : filtreRVs){
            rvStringList.add( rv.getNumRV() + "\nDate rapport: " + rv.getDate_visite() + "\nRédacteur: " + rv.getVisiteur() );
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rvStringList);
        listerapports.setAdapter(adapter);

        listerapports.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RapVisite clickedRapport = filtreRVs.get(position);
                Intent intent = new Intent(ListeRvActivity.this, VisuRvActivity.class);
                intent.putExtra("rapportNum", clickedRapport.getNumRV());
                startActivity(intent);
            }
        });
    }
}


