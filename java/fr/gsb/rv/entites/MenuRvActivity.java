package fr.gsb.rv.entites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;

public class MenuRvActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_activity);


        Button buttonSaisir = findViewById(R.id.button3);
        Button buttonConsulter = findViewById(R.id.button4);
        Button buttonRetour = findViewById(R.id.button7);

        buttonSaisir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRvActivity.this, SaisieRvActivity.class);
                startActivity(intent);
            }
        });

        buttonConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRvActivity.this, RechercheRvActivity.class);
                startActivity(intent);
            }
        });

        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRvActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

