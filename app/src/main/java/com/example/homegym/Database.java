package com.example.homegym;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedHashMap;
import java.util.Map;

public class Database extends SQLiteOpenHelper {
    private static final String DatabaseName = "HOME_GYM.db";
    private static final String TABLE_NAME="GYM";
    private static final String Col_0 = "ID";
    private static final String Col_1 = "Usernname";
    private static final String Col_2 = "Password";
    public static Cursor res;
    public static LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

    public Database(Context context) {
        super(context, DatabaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"("+Col_0+" INTEGER PRIMARY KEY AUTOINCREMENT,"+Col_1+" TEXT ,"+Col_2+" TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    public void insertData(String username,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1,username);
        contentValues.put(Col_2,password);

        db.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public LinkedHashMap<String, String> verifyData() {
        SQLiteDatabase db = this.getWritableDatabase();
        res = db.rawQuery("select * from "+TABLE_NAME,null);
        while(res.moveToNext()) {
            map.put(res.getString(1), res.getString(2));
        }
        return map;
    }
}
