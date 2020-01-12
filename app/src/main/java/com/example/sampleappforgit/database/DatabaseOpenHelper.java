package com.example.sampleappforgit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper
{
    public static String DATABASE_NAME = "MoneyTraker.db";
    public static int VERSION = 1;
    public static String TABLE_NAME = "MoneyTraker";
    public static String COL_DATE = "Date";
    public static String COL_TYPE = "Type";
    public static String COL_INCOME = "Income";
    public static String COL_EXPENSES = "Expenses";

    private SQLiteDatabase db;


    public static String money_traker = "create table MoneyTraker(Date integer, Type text, Income integer, Expenses integer)";
    public DatabaseOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,VERSION);
    }

    public void openDatabase(){

        db = getWritableDatabase();
    }

    public void closeDatabase(){

        db.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
     db.execSQL(money_traker);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public long insert(String date,String type,String income,String expenses){

        openDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_DATE,date);
        values.put(COL_TYPE,type);
        values.put(COL_INCOME,income);
        values.put(COL_EXPENSES,expenses);

        long id =db.insert(TABLE_NAME,null,values);
        closeDatabase();
        return id;
    }

    public Cursor getData(){
        openDatabase();
        String data = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor =  db.rawQuery(data,null);
        return cursor;
    }
}
