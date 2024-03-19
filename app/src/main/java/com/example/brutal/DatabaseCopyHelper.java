package com.example.brutal;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseCopyHelper extends SQLiteOpenHelper {

	private static final String DB_NAME = "brutal.db";
	private static final int DB_VERSION = 1;
	private static String DB_PATH = "/data/data/%s/databases/";

	private final Context mContext;

	public DatabaseCopyHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		this.mContext = context;
		DB_PATH = String.format(DB_PATH, context.getPackageName());
	}

	public void createDataBase() throws IOException {
		boolean dbExist = checkDataBase();

		if (!dbExist) {
			this.getReadableDatabase();
			this.close();
			try {
				copyDataBase();
			} catch (IOException e) {
				throw new Error("Error copying database");
			}
		}
	}

	private boolean checkDataBase() {
		SQLiteDatabase checkDB = null;
		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		} catch (SQLException e) {
			// Database does not exist
		}
		if (checkDB != null) {
			checkDB.close();
		}
		return checkDB != null;
	}

	private void copyDataBase() throws IOException {
		InputStream myInput = mContext.getAssets().open(DB_NAME);
		String outFileName = DB_PATH + DB_NAME;
		OutputStream myOutput = new FileOutputStream(outFileName);

		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}

		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	public SQLiteDatabase openDataBase() throws SQLException {
		String myPath = DB_PATH + DB_NAME;
		return SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
	}

	@Override
	public synchronized void close() {
		// Close the database if it was opened
		super.close();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// No need to create tables here as the database is already created
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Handle database upgrades if needed
	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
			db.disableWriteAheadLogging();
		}
	}
}
