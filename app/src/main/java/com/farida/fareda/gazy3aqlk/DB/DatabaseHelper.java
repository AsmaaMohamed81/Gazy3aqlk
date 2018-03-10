package com.farida.fareda.gazy3aqlk.DB;

/**
 * Created by anupamchugh on 19/10/15.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.ByteArrayOutputStream;

public class DatabaseHelper extends SQLiteAssetHelper  {
    // Table Name
    public static final String TABLE_NAME ="aqlakk" ;

    // Table columns
    public static final String _ID = "_id";
    public static final String TITLE = "title";
    public static final String DESC = "description";
    public static final String CAT = "cat";
    public static final String IMAGE = "image";


    // Database Information
    static final String DB_NAME = "aqlak.db";

    // database version
    static final int DB_VERSION = 2;

    // Creating table query
    private static final String CREATE_TABLE = "create table "
            + TABLE_NAME
            + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TITLE + " TEXT NOT NULL, "
            + DESC + " TEXT, "
            + CAT + " TEXT,"
            + IMAGE + " BLOB" + ")";

    Drawable drawable;
    ByteArrayOutputStream bytearrayoutputstream;
    byte[] BYTE1,BYTE2,BYTE;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME,context.getExternalFilesDir(null).getAbsolutePath() ,null, DB_VERSION);
    }

//
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_TABLE);
//
//
//
//
////        db.execSQL("INSERT INTO elhmreryi (title, description,cat,image) VALUES('elmy', 'ddddd0','elmy','')");
//
//
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
