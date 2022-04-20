package com.example.dblite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBconnexion extends SQLiteOpenHelper {
    
    public DBconnexion(Context context){
        super(context,"Data.db", null, 1);
    }
    public void insertAdmin(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Name", name);
        db.insert("Admin", null, cv);
    }

    public void deleteRow(Integer id){
        SQLiteDatabase db=this.getWritableDatabase();
        String[] s= new String[]{String.valueOf(id)};
        db.delete("Admin", "ID=?", s);
    }

    public void update(String name, Integer id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("update Admin set Name='"+name+"'where ID="+String.valueOf(id));
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Admin (ID INTEGER PRIMARY KEY, Name TEXT)");
    }
    @SuppressLint("Range")
    public ArrayList getAll(){
        ArrayList list= new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM Admin", null);
        c.moveToFirst();
        while(c.isAfterLast()==false){
            list.add(c.getString(c.getColumnIndex("ID"))+" : "+c.getString(c.getColumnIndex("Name")));
            c.moveToNext();
        }
        return  list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Admin");
        onCreate(db);
    }
}
