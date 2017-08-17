package com.isa.haozi.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Izumi on 17/8/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "growing";
    private static final String DB_NAME = "haozi.db";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + DBColumns._ID + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "
                + DBColumns.ID + " TEXT, "
                + DBColumns.DATE + " DATETIME, "
                + DBColumns.PATH + " TEXT, "
                + DBColumns.NAME + " TEXT, "
                + DBColumns.TYPE + " TEXT, "
                + ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
