package fr.gsb.rv.entites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import fr.gsb.rv.modeles.ModeleGSB;

public class VisuRvActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visu);

        Intent intent = getIntent();
        int rapportNum = intent.getIntExtra("rapportNum", -1);

        ModeleGSB modeleGSB = ModeleGSB.getInstance();
        RapVisite rapport = modeleGSB.getRapportByNum(rapportNum);

        if (rapport != null) {
            TextView visu1 = findViewById(R.id.visu1);
            visu1.setText("Numéro de rapport : " + rapport.getNumRV() + "\n");

            TextView visu2 = findViewById(R.id.visu2);
            visu2.setText("Date de visite : " + rapport.getDate_visite());

            TextView visu3 = findViewById(R.id.visu3);
            visu3.setText("Rédacteur : " + rapport.getVisiteur());

            TextView visu4 = findViewById(R.id.visu4);
            visu4.setText("Praticien visité : " + rapport.getPraticien());

            TextView visu5 = findViewById(R.id.visu5);
            visu5.setText("Motif de visite : " + rapport.getMotif());

            TextView visu6 = findViewById(R.id.visu6);
            visu6.setText("Bilan : " + rapport.getBilan());

            TextView visu7 = findViewById(R.id.visu7);
            visu7.setText("Coefficient de confiance : " + rapport.getCoeffConf());

        }
    }
}

