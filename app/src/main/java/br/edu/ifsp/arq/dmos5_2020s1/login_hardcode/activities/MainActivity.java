package br.edu.ifsp.arq.dmos5_2020s1.login_hardcode.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.arq.dmos5_2020s1.login_hardcode.R;
import br.edu.ifsp.arq.dmos5_2020s1.login_hardcode.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtEnrollment;
    private EditText edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEnrollment = findViewById(R.id.edittext_enrollment);
        edtPassword = findViewById(R.id.edittext_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnLogin) {
            getCredentials();
        }
    }

    private void getCredentials() {
        double enrollment;
        double password;
        User user;

        try {
            enrollment = Double.parseDouble(edtEnrollment.getText().toString());
            password = Double.parseDouble(edtPassword.getText().toString());
        }catch (NumberFormatException ex) {
            Toast.makeText(this, getString(R.string.fields_validade), Toast.LENGTH_LONG).show();
            return;
        }

        if(enrollment == 0 && password==0) {
            Toast.makeText(this, getString(R.string.fields_validade), Toast.LENGTH_LONG).show();
            return;
        }

        user = new User(enrollment,password);
        Intent intent = new Intent(this, LoginValidateActivity.class);

        // UTILIZANDO BUNDLE
        Bundle b = new Bundle();
        b.putDouble("EXTRA_ENROLLMENT", user.getEnrollment());
        b.putDouble("EXTRA_PASSWORD", user.getPassword());

        intent.putExtras(b);
        startActivity(intent);

    }
}
