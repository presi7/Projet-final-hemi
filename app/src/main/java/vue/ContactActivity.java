package vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projetfinal.R;

public class ContactActivity extends AppCompatActivity {
    private EditText objet, txtsms, txtTel;
    private Button btn_envoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initActivity();
    }

    //Initialistion
    private void initActivity(){
        //recuperation des objets graphiques
        txtTel =(EditText) findViewById(R.id.txtTel);
        txtsms =(EditText) findViewById(R.id.txtsms);
        btn_envoi = (Button) findViewById(R.id.btn_envoi);
        //gestion de l'evenement clic sur bouton envoyer
        createOnClickEnvoiButton();
    }
    //clic sur bouton envoi: envoi de sms
    private void createOnClickEnvoiButton(){
        btn_envoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage(txtTel.getText().toString(), null, txtsms.getText().toString(), null, null);
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
                Intent apropos = new Intent(ContactActivity.this, AproposActivity.class);
                startActivity(apropos);
                return true;
            case R.id.menu_contact:
                Intent contact = new Intent(ContactActivity.this, ContactActivity.class);
                startActivity(contact);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
}
}