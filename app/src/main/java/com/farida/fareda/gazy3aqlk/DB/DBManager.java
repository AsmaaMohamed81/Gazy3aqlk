package com.farida.fareda.gazy3aqlk.DB;

/**
 * Created by anupamchugh on 19/10/15.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

    public void insert(String name, String desc ,String cate) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.TITLE, name);
        contentValue.put(DatabaseHelper.DESC, desc);
        contentValue.put(DatabaseHelper.CAT, cate);

        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch(String cat) {

        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.TITLE ,DatabaseHelper.DESC};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns,DatabaseHelper.CAT+ " =?", new String[]{cat}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();


        }
        return cursor;
    }

    public List<Model> fetchtit(String cat) {
        List<Model> list= new ArrayList<>();

        String[] columns = new String[] {  DatabaseHelper.TITLE };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns,DatabaseHelper.CAT+ " =?", new String[]{cat}, null, null, null, null);
        Model dataModel = null;

        while(cursor.moveToNext()){

            dataModel= new Model();

            String m1=cursor.getString(cursor.getColumnIndexOrThrow("title"));

            dataModel.setTitle(m1);

            list.add(dataModel);
        }

        for (Model mo:list ) {

            Log.i("Hellomo",""+mo.getTitle());
        }


        return list;

    }





    
    public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.TITLE, name);
        contentValues.put(DatabaseHelper.DESC, desc);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

}
