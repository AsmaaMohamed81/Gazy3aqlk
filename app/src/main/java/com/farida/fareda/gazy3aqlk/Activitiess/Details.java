package com.farida.fareda.gazy3aqlk.Activitiess;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.farida.fareda.gazy3aqlk.R;

/**
 * Created by m on 3/10/2018.
 */

public class Details extends AppCompatActivity {

    TextView title,desc;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);

        title= (TextView) findViewById(R.id.detail_title);
        desc=(TextView) findViewById(R.id.detail_desc);
        img=(ImageView)findViewById(R.id.detail_img);


        Intent u = getIntent();

        title.setText(u.getStringExtra("title"));
        desc.setText(u.getStringExtra("desc"));
        img.setImageBitmap(convertToBitmap(u.getByteArrayExtra("img")));






    }

    private Bitmap convertToBitmap(byte[] b){

        return BitmapFactory.decodeByteArray(b, 0, b.length);

    }
}
