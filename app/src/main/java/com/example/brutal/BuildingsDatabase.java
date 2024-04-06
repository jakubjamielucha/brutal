//package com.example.brutal;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import java.util.ArrayList;
//
//public class BuildingsDatabase extends SQLiteOpenHelper {
//
//    private static final String DATABASE_NAME = "databases/brutal.db";
//
//    public BuildingsDatabase(Context context) {
//        super(context, DATABASE_NAME, null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE IF NOT EXISTS brutal (" +
//                "id INTEGER PRIMARY KEY," +
//                "name TEXT," +
//                "architect TEXT," +
//                "construction_date TEXT," +
//                "city TEXT," +
//                "country TEXT," +
//                "description TEXT," +
//                "description_source TEXT," +
//                "maps_coordinates TEXT," +
//                "maps_link TEXT," +
//                "tags TEXT," +
//                "status TEXT," +
//                "photo_link TEXT," +
//                "photo_source TEXT," +
//                "links TEXT)");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS brutal");
//        onCreate(db);
//    }
//
//    public ArrayList<BuildingModel> getAllBuildings() {
//        ArrayList<BuildingModel> buildings = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.rawQuery("SELECT * FROM brutal", null);
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//                BuildingModel building = new BuildingModel(
//                        cursor.getInt(cursor.getColumnIndex("id")),
//                        cursor.getString(cursor.getColumnIndex("name")),
//                        cursor.getString(cursor.getColumnIndex("architect")),
//                        cursor.getString(cursor.getColumnIndex("construction_date")),
//                        cursor.getString(cursor.getColumnIndex("city")),
//                        cursor.getString(cursor.getColumnIndex("country")),
//                        cursor.getString(cursor.getColumnIndex("description")),
//                        cursor.getString(cursor.getColumnIndex("description_source")),
//                        cursor.getString(cursor.getColumnIndex("maps_coordinates")),
//                        cursor.getString(cursor.getColumnIndex("maps_link")),
//                        cursor.getString(cursor.getColumnIndex("tags")),
//                        cursor.getString(cursor.getColumnIndex("status")),
//                        cursor.getString(cursor.getColumnIndex("photo_link")),
//                        cursor.getString(cursor.getColumnIndex("photo_source")),
//                        cursor.getString(cursor.getColumnIndex("links"))
//                );
//                buildings.add(building);
//            }
//            cursor.close();
//        }
//
//        db.close();
//
//        return buildings;
//    }
//
//}
