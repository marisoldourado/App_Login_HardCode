package br.edu.ifsp.arq.dmos5_2020s1.login_hardcode.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import br.edu.ifsp.arq.dmos5_2020s1.login_hardcode.R;


public class LoginValidateActivity extends AppCompatActivity {

    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_validate);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewMessage = findViewById(R.id.txtview_message);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        validateLogin(b);
    }

    private void validateLogin(Bundle b) {

        Double enrollment = b.getDouble("EXTRA_ENROLLMENT");
        Double password = b.getDouble("EXTRA_PASSWORD");

        if(enrollment == 1710354 && password == 4530171) {
            textViewMessage.setText(getString(R.string.welcome) + " " + "1710354");
        }
        else {
            textViewMessage.setText(getString(R.string.login_error));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
