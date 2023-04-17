package com.horvath.david.beadando;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final  String ADATBAZIS_NEVE = "beadando.db";
    public static final  String TABLA_NEVE = "beadando_table";
    public static final  String oszlop_1 = "ID";
    public static final  String oszlop_2 = "NEV";
    public static final  String oszlop_3 = "VAROS";
    public static final  String oszlop_4 = "UTCAHSZ";

    public DatabaseHelper(Context context) {

        super(context, ADATBAZIS_NEVE, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + TABLA_NEVE +" (ID INTEGER PRIMARY KEY AUTOINCREMENT ,NEV TEXT,VAROS TEXT,UTCAHSZ TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_NEVE);
        onCreate(sqLiteDatabase);
    }

    public boolean adatFelvesz(String NEV, String VAROS, String UTCAHSZ){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(oszlop_2,NEV);
        contentValues.put(oszlop_3,VAROS);
        contentValues.put(oszlop_4,UTCAHSZ);

       long siker= db.insert(TABLA_NEVE,null,contentValues);
        if(siker == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor lekerdezes(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur = db.rawQuery("select * from "+TABLA_NEVE,null);
        return cur;
    }


    public boolean adatModositas(String id,String nev,String varos,String utcahsz){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(oszlop_1,id);
        contentValues.put(oszlop_2,nev);
        contentValues.put(oszlop_3,varos);
        contentValues.put(oszlop_4,utcahsz);

        db.update(TABLA_NEVE,contentValues, "ID = ?",new String[]{id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLA_NEVE, "ID = ?",new String[]{id});
    }



}
