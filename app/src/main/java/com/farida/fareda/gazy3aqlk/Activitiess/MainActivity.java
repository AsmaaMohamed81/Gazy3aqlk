package com.farida.fareda.gazy3aqlk.Activitiess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.farida.fareda.gazy3aqlk.R;

public class MainActivity extends AppCompatActivity {
Button elmy ,adby;

    static String nameTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elmy=(Button)findViewById(R.id.elmy);
        adby=(Button)findViewById(R.id.adby);

        elmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTable = "elmy";

                Intent i = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(i);

            }
        });

        adby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTable = "adby";

                Intent ii = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(ii);

            }
        });
    }
}
