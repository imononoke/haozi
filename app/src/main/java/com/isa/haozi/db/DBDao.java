package com.isa.haozi.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Izumi on 17/8/17.
 */

public class DBDao {

    private static DBDao dbDao;
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    public static DBDao getInstance(Context context) {
        if (dbDao == null) {
            dbDao = new DBDao(context);
        }
        return dbDao;
    }

    public synchronized ArrayList<DBEntity> queryAll() {
        ArrayList<DBEntity> dbEntityArrayList = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + DBHelper.TABLE_NAME, null);
        while (cursor.moveToNext()) {
            DBEntity entity = new DBEntity();
            entity.id = cursor.getString(cursor.getColumnIndex(DBColumns.ID));
            entity.date = cursor.getString(cursor.getColumnIndex(DBColumns.DATE));
            entity.name = cursor.getString(cursor.getColumnIndex(DBColumns.NAME));
            entity.path = cursor.getString(cursor.getColumnIndex(DBColumns.PATH));
            entity.type = cursor.getString(cursor.getColumnIndex(DBColumns.TYPE));

            dbEntityArrayList.add(entity);
        }
        cursor.close();
        return dbEntityArrayList;
    }

}
