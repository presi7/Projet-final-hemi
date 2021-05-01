package vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetfinal.R;

public class ResultatfinalActivity extends AppCompatActivity {

    private Button btn_vibrer;
    private Vibrator Levibreur;
    private TextView sContenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultatfinal);

        Levibreur = (Vibrator) getSystemService( Context.VIBRATOR_SERVICE);
        btn_vibrer = (Button) findViewById(R.id.btn_vibrer);

        btn_vibrer.setOnCreateContextMenuListener(this);
        sContenu = (TextView) findViewById(R.id.nb_vibration);

        btn_vibrer.setOnClickListener( new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = sContenu.getText().toString();
                //convertion de cette valeur en entier et miliseconde
                int letemp = Integer.parseInt(nombre) * 30;
                Levibreur.vibrate(letemp);
                sContenu.setText("ok");

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
                Intent apropos = new Intent(ResultatfinalActivity.this, AproposActivity.class);
                startActivity(apropos);
                return true;
            case R.id.menu_contact:
                Intent contact = new Intent(ResultatfinalActivity.this, ContactActivity.class);
                startActivity(contact);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}