package com.demo22;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by qtm-android on 21/7/16.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="test.db";
    private static final String TABLE_NAME="test";
    private static final int DATABASE_VERSION=1;
    private static final String COL_NAME="NAME";
    private static final String UID="_id";
    private static final String UDATE="DATE";
    private static final String COL_NAME2="SURNAME";
    private static final String COL_SPINNER="DESIGNATION";
    private static final String COL_RADIO ="GENER";
    private Context context;
    private static final String DROP_TABLE="DROP TABLE IF EXISTS"+TABLE_NAME;
//    private static final String CREATE_TABLE = "CREATE TABLE "
//            + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY," + COL_NAME
//            + " TEXT," + COL_NAME2 + " TEXT," + UDATE
//            + " DATETIME," + COL_SPINNER + " TEXT," ")";

    private static  final  String CREATE_TABLE = " CREATE TABLE "
            + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY, "+ COL_NAME
    + " TEXT," + COL_NAME2 +" TEXT, " + UDATE + " DATETIME," + COL_SPINNER +" TEXT ,"+ COL_RADIO +" TEXT)";




    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);

    }


    public boolean insertData(String name, String date, String spiner, String surname)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(UDATE,date);
        contentValues.put(COL_SPINNER,spiner);
        contentValues.put(COL_NAME2,surname);


        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }


}

