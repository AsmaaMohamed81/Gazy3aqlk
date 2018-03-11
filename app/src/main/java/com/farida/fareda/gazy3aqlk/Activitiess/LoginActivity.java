package com.farida.fareda.gazy3aqlk.Activitiess;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.farida.fareda.gazy3aqlk.MOdle.Model;
import com.farida.fareda.gazy3aqlk.R;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText name, pass;

    Button log;
    TextView skip ,aboutus;

    Model model;

    List<Model> Array ;

    public static String [] title={
            "1",
            "2 ",

    };
    public static String [] desc={
            "1",
            "2 ",

    };
    public static String [] cat={
            "elmy",
            "adby ",

    };

//    Drawable img1 = getResources().getDrawable(R.drawable.det);
//    Drawable img2 = getResources().getDrawable(R.drawable.logo);

    Drawable drawable;
    ByteArrayOutputStream bytearrayoutputstream;
    byte[] BYTE1,BYTE2,BYTE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        name = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.pass);
        log = (Button) findViewById(R.id.log);
        skip=(TextView)findViewById(R.id.skip);
        aboutus=(TextView)findViewById(R.id.aboutus);






        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameL = name.getText().toString();
                String passL = pass.getText().toString();

                if (nameL.equals("admain") && passL.equals("1234")) {

                    Intent o = new Intent(LoginActivity.this, AdmainMainActivity.class);
                    startActivity(o);
                } else {
                    Toast.makeText(LoginActivity.this, "You are not admain ", Toast.LENGTH_LONG).show();
                    Intent o = new Intent(LoginActivity.this, MainActivity.class);
                    
                    startActivity(o);

                }
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(LoginActivity.this, MainActivity.class);

                startActivity(o);

            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(LoginActivity.this, AboutUs.class);

                startActivity(o);

            }
        });


    }

//    private byte[] convertTobyte(Drawable b){
//
//        //drawable = getResources().getDrawable(R.drawable.logo);
//        Bitmap bitmap1 = ((BitmapDrawable)b).getBitmap();
//        bytearrayoutputstream = new ByteArrayOutputStream();
//        bitmap1.compress(Bitmap.CompressFormat.JPEG,70,bytearrayoutputstream);
//        BYTE = bytearrayoutputstream.toByteArray();
//        return BYTE;
//    }
}
