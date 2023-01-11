package com.example.practica4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class DataLoader extends AppCompatActivity {

    private static Context context;
    private static Set<Integer> earings;

    public DataLoader(Context context){
        this.context= context;
        this.earings= new HashSet<>();
    }

    public void deleteInfo(){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(context, "gestion", null, 1);
        SQLiteDatabase BD= admin.getWritableDatabase();
        BD.execSQL("delete from earings");
        BD.close();
    }


    public static Earing getEaringFromDB(){
        int imageResource=0;

        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(context, "gestion", null, 1);
        SQLiteDatabase BD= admin.getWritableDatabase();
        Cursor earingRaw= BD.rawQuery
                ("select id, name, description, imageResource from earings", null);
        earingRaw.moveToFirst();
        imageResource = Integer.parseInt(earingRaw.getString(3));
        String description = earingRaw.getString(2);
        int id = Integer.parseInt(earingRaw.getString(0));

        return new Earing(id, earingRaw.getString(1), description, imageResource);
    }

    public void LoadEarings(){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(context, "gestion", null, 1);
        SQLiteDatabase BD= admin.getWritableDatabase();

        ContentValues earings= new ContentValues();
        ContentValues answer= new ContentValues();

        earings.put("id", 1);
        earings.put("name", context.getString(R.string.pendiente1));
        earings.put("description", context.getString(R.string.description_pendiente1));
        earings.put("imageResource", R.drawable.img1);
        BD.insert("earings", null, earings);
        earings.clear();

        BD.close();
    }
}
