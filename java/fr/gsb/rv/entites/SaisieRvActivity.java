package fr.gsb.rv.entites;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import fr.gsb.rv.modeles.ModeleGSB;
import fr.gsb.rv.technique.Session;

public class SaisieRvActivity extends AppCompatActivity {

    private EditText editTextDateVisite;
    private EditText editTextPraticien;
    private EditText editTextMotif;
    private EditText editTextBilan;
    private Spinner spinnerCoeffConf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saisie);

        editTextDateVisite = findViewById(R.id.editTextDateVisite);
        editTextPraticien = findViewById(R.id.editTextPraticien);
        editTextMotif = findViewById(R.id.editTextMotif);
        editTextBilan = findViewById(R.id.editTextBilan);
        spinnerCoeffConf = findViewById(R.id.coeffConf);

        List<String> coeffConfList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            coeffConfList.add(String.valueOf(i));
        }

        ArrayAdapter<String> coeffConfAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, coeffConfList);
        coeffConfAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCoeffConf.setAdapter(coeffConfAdapter);
    }
}



