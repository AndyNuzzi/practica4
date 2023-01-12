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
    private static Set<Integer> candidates;

    public DataLoader(Context context){
        this.context= context;
        this.candidates= new HashSet<>();
    }

    public void deleteInfo(){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(context, "gestion", null, 1);
        SQLiteDatabase BD= admin.getWritableDatabase();
        BD.execSQL("delete from earings");
        BD.close();
    }

    private static int getID(){
        int id = 0;
        int i = 0;

        do {
            id = i + 1;

        } while (candidates.contains(id));

        candidates.add(id);

        return id;
    }

    public static Earing getEaringFromDB(){
        int imageResource=0;
        Earing earing = new Earing("", "", imageResource);

        int earID = getID();

        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(context, "gestion", null, 1);
        SQLiteDatabase BD= admin.getWritableDatabase();
        Cursor earingRaw= BD.rawQuery
                ("select name, description, imageResource from earings where id=" + earID, null);

        if( earingRaw != null && earingRaw.moveToFirst() ) {
            String name = earingRaw.getString(0);
            String description = earingRaw.getString(1);
            imageResource = Integer.parseInt(earingRaw.getString(2));

            earing =  new Earing(name, description, imageResource);
        }

        return earing;
    }

    public void LoadEarings(){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(context, "gestion", null, 1);
        SQLiteDatabase BD= admin.getWritableDatabase();

        ContentValues earings= new ContentValues();

        earings.put("id", 1);
        earings.put("name", context.getString(R.string.pendiente1));
        earings.put("description", context.getString(R.string.description_pendiente1));
        earings.put("imageResource", R.drawable.img1);
        BD.insert("earings", null, earings);
        earings.clear();

        BD.close();
    }
}
