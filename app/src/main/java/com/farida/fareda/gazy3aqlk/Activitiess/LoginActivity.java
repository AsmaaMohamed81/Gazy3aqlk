package com.farida.fareda.gazy3aqlk.Activitiess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.farida.fareda.gazy3aqlk.R;

public class LoginActivity extends AppCompatActivity {
    EditText name, pass;

    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.pass);
        log = (Button) findViewById(R.id.log);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameL = name.getText().toString();
                String passL = pass.getText().toString();

                if (nameL.equals("admain") && passL.equals("1234")) {

                    Intent o = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(o);
                } else {
                    Toast.makeText(LoginActivity.this, "You are not admain ", Toast.LENGTH_SHORT).show();
                    Intent o = new Intent(LoginActivity.this, UserActivity.class);
                    startActivity(o);

                }
            }
        });


    }
}
