package com.farida.fareda.gazy3aqlk.Activitiess;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.farida.fareda.gazy3aqlk.Adapter.Adapter;
import com.farida.fareda.gazy3aqlk.DB.DBManager;
import com.farida.fareda.gazy3aqlk.MOdle.Model;
import com.farida.fareda.gazy3aqlk.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    Adapter mAdapter;
    RecyclerView mRecyclerView;

    Model mModel;

    List<Model> mArrayList;
    DBManager dbManager;

    Drawable drawable;
    ByteArrayOutputStream bytearrayoutputstream;
    byte[] BYTE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        mArrayList =new ArrayList<Model>();


        mRecyclerView = (RecyclerView) findViewById(R.id.recyc);

        dbManager =new DBManager(UserActivity.this);

        dbManager.open();

//      //  InputStream iStream = null;
//        drawable = getResources().getDrawable(R.drawable.logo);
//
//       Bitmap bitmap1 = ((BitmapDrawable)drawable).getBitmap();
//        bytearrayoutputstream = new ByteArrayOutputStream();
//
//
//        bitmap1.compress(Bitmap.CompressFormat.JPEG,70,bytearrayoutputstream);
//
//        BYTE = bytearrayoutputstream.toByteArray();

       // db.addContacts(new Contact(f_name, photo));
//        dbManager.addContacts(new Model("ss","fdfd","elmy",BYTE));
//        dbManager.addContacts(new Model("ss","fdfd","elmy",BYTE));
      //  mArrayList=dbManager.fetchtit("elmy");

        mArrayList=dbManager.getAllContacts();

        mAdapter =new Adapter(UserActivity.this,mArrayList);


        Log.i("HIteshdata",""+mArrayList);
        RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(reLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }


    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        final int width = !drawable.getBounds().isEmpty() ? drawable
                .getBounds().width() : drawable.getIntrinsicWidth();

        final int height = !drawable.getBounds().isEmpty() ? drawable
                .getBounds().height() : drawable.getIntrinsicHeight();

        final Bitmap bitmap = Bitmap.createBitmap(width <= 0 ? 1 : width,
                height <= 0 ? 1 : height, Bitmap.Config.ARGB_8888);

        Log.v("Bitmap width - Height :", width + " : " + height);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    //COnvert and resize our image to 400dp for faster uploading our images to DB
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
}
