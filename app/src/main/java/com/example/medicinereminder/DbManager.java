package com.example.medicinereminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper
{
    private static final String dbname = "medicine.db";
    public DbManager(Context context)
    {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry="create table tbl_med(medname text, timesday text, time text, forw text,prescribedby text)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS tbl_med");
        onCreate(db);
    }
    public String addRecord(String p1,String p2,String p3,String p4,String p5)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("medname",p1);
        cv.put("timesday",p2);
        cv.put("time",p3);
        cv.put("forw",p4);
        cv.put("prescribedby",p5);

        long res=db.insert("tbl_med",null,cv);
        if(res==-1)
            return "Failed";
        else
            return  "Reminder Set Successfully";
    }
}
