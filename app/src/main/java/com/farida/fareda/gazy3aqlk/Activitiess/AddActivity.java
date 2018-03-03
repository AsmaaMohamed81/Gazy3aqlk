package com.farida.fareda.gazy3aqlk.Activitiess;

/**
 * Created by anupamchugh on 19/10/15.
 */
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.farida.fareda.gazy3aqlk.DB.DBManager;
import com.farida.fareda.gazy3aqlk.R;

import java.io.ByteArrayOutputStream;


public class AddActivity extends Activity implements OnClickListener {

    private static final int SELECT_PICTURE = 100;
    private static final String TAG = "gggg";

    private Button addTodoBtn;
    private EditText subjectEditText;
    private EditText descEditText,cat;

    private DBManager dbManager;
    ImageView btnSelectImage;

    byte[] photo;
    private Bitmap bp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Item");

        setContentView(R.layout.activity_add_record);

        subjectEditText = (EditText) findViewById(R.id.title_edittext);
        descEditText = (EditText) findViewById(R.id.description_edittext);
        btnSelectImage = (ImageView) findViewById(R.id.btnSelectImage);

        //   cat = (EditText) findViewById(R.id.cat);


        addTodoBtn = (Button) findViewById(R.id.add_item);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);
        btnSelectImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_item:
                getValues();


                final String name = subjectEditText.getText().toString();
                final String desc = descEditText.getText().toString();
                //     final String catt = cat.getText().toString();


                dbManager.insert(name, desc,photo,MainActivity.nameTable);

                Intent main = new Intent(AddActivity.this, ListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);

                Toast.makeText(getApplicationContext(),"Saved successfully", Toast.LENGTH_LONG).show();



                break;

            case R.id.btnSelectImage:
              ;

                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK
                        ,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 2);

                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 2:
                if(resultCode == RESULT_OK){
                    Uri choosenImage = data.getData();

                    if(choosenImage !=null){

                        bp=decodeUri(choosenImage, 50);
                        btnSelectImage.setImageBitmap(bp);
                    }
                }
        }
    }

    protected Bitmap decodeUri(Uri selectedImage, int REQUIRED_SIZE) {

        try {

            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o);

            // The new size we want to scale to
            // final int REQUIRED_SIZE =  size;

            // Find the correct scale value. It should be the power of 2.
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true) {
                if (width_tmp / 2 < REQUIRED_SIZE
                        || height_tmp / 2 < REQUIRED_SIZE) {
                    break;
                }
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 2;
            }

            // Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o2);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Convert bitmap to bytes
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    private byte[] profileImage(Bitmap b){

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 0, bos);
        return bos.toByteArray();

    }
    private void getValues(){
        photo = profileImage(bp);
    }




}