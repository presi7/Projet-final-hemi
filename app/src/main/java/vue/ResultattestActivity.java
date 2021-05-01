package vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetfinal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ResultattestActivity extends AppCompatActivity {

    private TextView rep1;
    private CheckBox cb1_oui, cb1_non;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultattest);
        rep1 = (TextView) findViewById(R.id.rep1);
        cb1_oui = (CheckBox) findViewById(R.id.cb1_oui);
       // cb_non = (CheckBox) findViewById(R.id.cb_non);
        FloatingActionButton fab = findViewById(R.id.fab_btn);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ResultattestActivity.this,"Veuillez appelez sur ce numero",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_CALL,Uri.parse("tel: "));
                i.setData(Uri.parse("tel:774801247"));
                startActivity(i);
            }
        });

    }

    public void checked(View v){
        if (cb1_oui.isChecked()){
            rep1.setText("le test est positif");
        }
        else{
            rep1.setText("Le test est negatif");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.resultattest_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_apropos:
                Intent apropos = new Intent(ResultattestActivity.this, AproposActivity.class);
                startActivity(apropos);
                return true;
            case R.id.menu_contact:
                Intent contact = new Intent(ResultattestActivity.this, ContactActivity.class);
                startActivity(contact);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}