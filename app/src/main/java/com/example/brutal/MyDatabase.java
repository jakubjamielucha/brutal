package com.example.brutal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "brutal.db";
    private static final int DB_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    public ArrayList<BuildingModel> getAllBuildings() {
        ArrayList<BuildingModel> buildings = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM brutal", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                BuildingModel building = new BuildingModel(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)
                        , cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9)
                        , cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15));
                buildings.add(building);
            }
            cursor.close();
        }

        db.close();

        return buildings;
    }
}
