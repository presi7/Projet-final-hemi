package vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetfinal.MyHelper;
import com.example.projetfinal.R;

public class InfospersonnelActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_valider, btn_maps;
    private String Nom,Prenom,Adresse,Email,Telephone;
    private EditText et_nom,et_prenom,et_adresse,et_mail,et_tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infospersonnel);
        btn_valider = (Button) findViewById(R.id.btn_valider);
        btn_maps = (Button)findViewById( R.id.btn_maps );

        et_nom=(EditText) findViewById(R.id.et_nom);
        et_prenom=(EditText) findViewById(R.id.et_prenom);
        et_adresse=(EditText) findViewById(R.id.et_adresse);
        et_tel=(EditText) findViewById(R.id.et_tel);
        et_mail=(EditText) findViewById(R.id.et_mail);


        MyHelper myHelper = new MyHelper( InfospersonnelActivity.this );
        myHelper.callCreateDatabase();

        btn_maps.setOnClickListener( this );
        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_nom.getText().toString().isEmpty() && !et_prenom.getText().toString().isEmpty() && !et_mail.getText().toString().isEmpty() && !et_tel.getText().toString().isEmpty())
                {
                    Toast.makeText(InfospersonnelActivity.this,"Bienvenue dans votre Test COVID",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(InfospersonnelActivity.this, QcmActivity.class);
                    startActivity(intent);
                    finish();

                    Nom=et_nom.getText().toString();
                    Prenom=et_nom.getText().toString();
                    Adresse=et_adresse.getText().toString();
                    Telephone=et_tel.getText().toString();
                    Email=et_mail.getText().toString();

                    intent.putExtra("Value",Nom);
                    intent.putExtra("Value",Prenom);
                    intent.putExtra("Value",Adresse);
                    intent.putExtra("Value",Telephone);
                    intent.putExtra("Value",Email);

            }
                else {
                    Toast.makeText(InfospersonnelActivity.this,"erreur!!!!!!Veillez remplir tous les champs",Toast.LENGTH_LONG).show();

                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.testcovid_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_apropos:
                Intent apropos = new Intent(InfospersonnelActivity.this, AproposActivity.class);
                startActivity(apropos);
                return true;
            case R.id.menu_contact:
                Intent contact = new Intent(InfospersonnelActivity.this, ContactActivity.class);
                startActivity(contact);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
   }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_maps:
                Intent i = new Intent(this, MapsActivity.class);
                startActivity( i );
        }

    }
}

