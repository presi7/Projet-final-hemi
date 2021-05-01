package vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.projetfinal.R;

public class TestcovidActivity extends AppCompatActivity {
    private Button btn_test;
    private Button btn_dernierrst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testcovid);
        btn_test = (Button) findViewById(R.id.btn_test);
        btn_dernierrst = (Button) findViewById(R.id.btn_dernierrst);

        btn_dernierrst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestcovidActivity.this, ResultatfinalActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestcovidActivity.this, InfospersonnelActivity.class);
                startActivity(intent);
                finish();
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
                Intent apropos = new Intent(TestcovidActivity.this, AproposActivity.class);
                startActivity(apropos);
                return true;
            case R.id.menu_contact:
                Intent contact = new Intent(TestcovidActivity.this, ContactActivity.class);
                startActivity(contact);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}