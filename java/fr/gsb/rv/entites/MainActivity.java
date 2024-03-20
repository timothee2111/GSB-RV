package fr.gsb.rv.entites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import fr.gsb.rv.modeles.ModeleGSB;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        Button annulerButton = findViewById(R.id.button2);
        Button validerButton = findViewById(R.id.button1);

        annulerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText("");
                editText2.setText("");
            }
        });

        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matricule = editText1.getText().toString();
                String mdp = editText2.getText().toString();

                ModeleGSB modeleGsb = ModeleGSB.getInstance();
                Visiteur visiteurConnecte = modeleGsb.seConnecter(matricule, mdp);

                if (visiteurConnecte != null) {
                    Toast.makeText(MainActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MenuRvActivity.class);
                    intent.putExtra("matriculeVisiteur", matricule);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Identifiant ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


