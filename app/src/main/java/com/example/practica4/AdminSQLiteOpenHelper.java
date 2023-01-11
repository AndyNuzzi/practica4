package com.example.practica4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase miBBDD) {
        miBBDD.execSQL("create table earings(id int primary key, name text, description text, imageResource int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase miBBDD, int i, int i1) {

    }
}
