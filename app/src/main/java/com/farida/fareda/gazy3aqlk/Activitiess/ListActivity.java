package com.farida.fareda.gazy3aqlk.Activitiess;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.farida.fareda.gazy3aqlk.Adapter.dataAdapter;
import com.farida.fareda.gazy3aqlk.DB.DBManager;
import com.farida.fareda.gazy3aqlk.DB.DatabaseHelper;
import com.farida.fareda.gazy3aqlk.MOdle.Model;
import com.farida.fareda.gazy3aqlk.R;

import java.util.ArrayList;

public class ListActivity extends ActionBarActivity {

    private DBManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    private dataAdapter data;

    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.TITLE, DatabaseHelper.DESC ,DatabaseHelper.IMAGE};

    final int[] to = new int[] { R.id.id, R.id.title, R.id.desc ,R.id.imgwww};

    private Model dataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);

        dbManager = new DBManager(this);
        dbManager.open();
        //    Cursor cursor = dbManager.fetch("elmy");

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

//        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
//        adapter.notifyDataSetChanged();
//
//        listView.setAdapter(adapter);

        final ArrayList<Model> contacts = new ArrayList<>(dbManager.getAllContacts(AdmainMainActivity.nameTable));
        data=new dataAdapter(this, contacts);

        listView.setAdapter(data);

//        ShowRecords();

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {

                dataModel = contacts.get(position);


//                TextView idTextView = (TextView) view.findViewById(R.id.id);
//                TextView titleTextView = (TextView) view.findViewById(R.id.title);
//                TextView descTextView = (TextView) view.findViewById(R.id.desc);
//                ImageView img = (ImageView) view.findViewById(R.id.imgwww);


//                String id = idTextView.getText().toString();
//                String title = titleTextView.getText().toString();
//                String desc = descTextView.getText().toString();
                //  String cat = cattt.getText().toString();

                String title = dataModel.getTitle();
                String desc=dataModel.getDesc();

                int id =dataModel.getId();





                Intent modify_intent = new Intent(getApplicationContext(), ModifyActivity.class);
                modify_intent.putExtra("title", title);
                modify_intent.putExtra("desc", desc);
                modify_intent.putExtra("id", String.valueOf(id));


                startActivity(modify_intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_item) {

            Intent add_mem = new Intent(this, AddActivity.class);
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        dbManager.close();

    }

    private Bitmap convertToBitmap(byte[] b){

        return BitmapFactory.decodeByteArray(b, 0, b.length);

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


    private void ShowRecords(){
        final ArrayList<Model> contacts = new ArrayList<>(dbManager.getAllContacts("elmy"));
        data=new dataAdapter(this, contacts);

        listView.setAdapter(data);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dataModel = contacts.get(position);

                Toast.makeText(getApplicationContext(),String.valueOf(dataModel.getCat()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}