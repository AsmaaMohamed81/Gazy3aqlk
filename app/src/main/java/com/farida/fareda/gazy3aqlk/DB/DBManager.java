package com.farida.fareda.gazy3aqlk.DB;

/**
 * Created by anupamchugh on 19/10/15.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.farida.fareda.gazy3aqlk.MOdle.Model;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();


        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String desc ,byte[] imageBytes, String cate) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.TITLE, name);
        contentValue.put(DatabaseHelper.DESC, desc);
        contentValue.put(DatabaseHelper.CAT, cate);
        contentValue.put(DatabaseHelper.IMAGE, imageBytes);

        Toast.makeText(context, "sucesss", Toast.LENGTH_SHORT).show();


        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }
//    public void addContacts(Model model){
//        database=dbHelper.getReadableDatabase();
//
//        ContentValues values=new ContentValues();
//        values.put(DatabaseHelper.TITLE, model.getTitle());
//        values.put(DatabaseHelper.DESC, model.getDesc() );
//        values.put(DatabaseHelper.CAT, model.getCat() );
//        values.put(DatabaseHelper.IMAGE, model.getImg() );
//
//
//
//        database.insert(DatabaseHelper.TABLE_NAME, null, values);
//        database.close();
//    }

//    public Cursor fetch(String cat) {
//        List<Model> contactList = new ArrayList<Model>();
//
//
//        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.TITLE ,DatabaseHelper.DESC,
//                DatabaseHelper.IMAGE};
//        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns,DatabaseHelper.CAT+ " =?"
//                , new String[]{cat}, null, null, null, null);
//        if (cursor.moveToFirst()) {
//            do {
//                Model model = new Model();
//
//                model.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("_id"))));
//
//
//                model.setTitle(cursor.getString(cursor.getColumnIndexOrThrow("title")));
//                model.setImg(cursor.getBlob(cursor.getColumnIndexOrThrow("image")));
//
//
//                // Adding contact to list
//                contactList.add(model);
//            } while (cursor.moveToNext());
//        }
//
//        // return contact list
//        return cursor;
//    }
//
//    public List<Model> fetchtit(String cat) {
//        List<Model> list= new ArrayList<>();
//
//        String[] columns = new String[] {  DatabaseHelper.TITLE };
//        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns,DatabaseHelper.CAT+ " =?", new String[]{cat}, null, null, null, null);
//        Model dataModel = null;
//
//        while(cursor.moveToNext()){
//
//            dataModel= new Model();
//
//            String m1=cursor.getString(cursor.getColumnIndexOrThrow("title"));
//
//            dataModel.setTitle(m1);
//
//            list.add(dataModel);
//        }
//
//        for (Model mo:list ) {
//
//            Log.i("Hellomo",""+mo.getTitle());
//        }
//
//
//        return list;
//
//    }

    public List<Model> getAllContacts(String cat) {
        List<Model> contactList = new ArrayList<Model>();

        String[] columns = new String[] {  DatabaseHelper._ID, DatabaseHelper.TITLE ,DatabaseHelper.DESC,
                DatabaseHelper.IMAGE };
        database=dbHelper.getWritableDatabase();


        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns,DatabaseHelper.CAT+ " =?", new String[]{cat}, null, null, null, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Model model = new Model();

                model.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("_id"))));
                model.setDesc(cursor.getString(cursor.getColumnIndexOrThrow("description")));



                model.setTitle(cursor.getString(cursor.getColumnIndexOrThrow("title")));
                model.setImg(cursor.getBlob(cursor.getColumnIndexOrThrow("image")));


                // Adding contact to list
                contactList.add(model);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }






    public int update(long _id, String name, String desc,byte[] imageBytes) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.TITLE, name);
        contentValues.put(DatabaseHelper.DESC, desc);
        contentValues.put(DatabaseHelper.IMAGE, imageBytes);

        int i = database.update(DatabaseHelper.TABLE_NAME,
                contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

}