package com.ryandro.sqlitesample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "COUNTRIES";// Table Name
    static final String DB_NAME = "MY_SQLITE.DB";// Database Information
    static final int DB_VERSION = 3;// database version

    // Table columns
    public static final String _ID = "_id";
    public static final String SUBJECT = "subject";
    public static final String DESC = "description";


    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "" + SUBJECT + " TEXT NOT NULL, " + DESC + " TEXT);";


    public DataBaseHelper(Context context) {
        super(context, TABLE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("On Upgrade Called", "Old Version No :" + oldVersion + "New Version No :" + newVersion);
        db.execSQL("ALTER TABLE " + TABLE_NAME + "  ADD status Integer ");
        List<String> listColName = getColomnName(db, TABLE_NAME);
        Log.d("Colomn Name ","Colomn Name List ----: "+ listColName.toString());
//        onCreate(db);
    }

    private List<String> getColomnName(SQLiteDatabase db, String tableName) {

        List<String> ar = null;
        Cursor c = null;
        try {
            c = db.rawQuery("Select * from " + tableName + " limit 1 ", null);
            if (c != null) {
                ar = new ArrayList<String>(Arrays.asList(c.getColumnNames()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return ar;
    }
}
