package com.farida.fareda.gazy3aqlk.Activitiess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.farida.fareda.gazy3aqlk.R;

public class MainActivity extends AppCompatActivity {
Button elmy ,kalma,shakhsyat,kawny,egtma3y,doaa,skafy,ta3lam;

    static String nameTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admain_main);

        elmy=(Button)findViewById(R.id.elmy);
        kalma=(Button)findViewById(R.id.kalma);
        shakhsyat=(Button)findViewById(R.id.shakhsyat);
        kawny=(Button)findViewById(R.id.kawny);
        egtma3y=(Button)findViewById(R.id.egtma3y);
        doaa=(Button)findViewById(R.id.doaa);
        skafy=(Button)findViewById(R.id.skafy);
        ta3lam=(Button)findViewById(R.id.ta3lam);


        elmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTable = "elmy";

                Intent i = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(i);

            }
        });

        kalma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTable = "kalma";

                Intent ii = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(ii);

            }
        });

        shakhsyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTable = "shakhsyat";

                Intent ii = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(ii);

            }
        });

        kawny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTable = "kawny";

                Intent ii = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(ii);

            }
        });
        egtma3y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTable = "egtma3y";

                Intent ii = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(ii);

            }
        });
        doaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTable = "doaa";

                Intent ii = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(ii);

            }
        });
        skafy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTable = "skafy";

                Intent ii = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(ii);

            }
        });
        ta3lam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTable = "ta3lam";

                Intent ii = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(ii);

            }
        });
    }
}
