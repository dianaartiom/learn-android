package com.example.diana.creatingdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by diana on 6/16/16.
 */
public class DBAdapter {

    // Constants and Data

    private static final String TAG = "DBAdapter";

    // DB fields

    public static final String KEY_ROWID = "_id";
    public static final int COL_ROWID = 0;

    public static final String KEY_NAME = "name";
    public static final String KEY_SCORE = "score";

    // Fields set up by me

    public static final int COL_NAME = 1;
    public static final int COL_SCORE = 2;

    public static final String[] ALL_KEYS = new String[] {KEY_ROWID, KEY_NAME, KEY_SCORE};

    // DB info: it's name,and the table we are usind(lust one)

    public static final String DATABASE_NAME = "MyDatabase";
    public static final String DATABASE_TABLE = "mainTable";

    // DB version (if the app changes the version of my app)
    public static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE_SQL =
            "create table " + DATABASE_TABLE
            + " (" + KEY_ROWID + " integer primary key autoincrement, "
            /* Her will be placed my fields */
            + KEY_NAME + " text not null, "
            + KEY_SCORE + " integer not null"
            + " );";

    // Context of application who uses it

    private final Context context;

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;

    /* Public methods */

    public DBAdapter(Context context) {
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    /* Open the database connection */

    public DBAdapter open() {
        db = databaseHelper.getWritableDatabase();
        return  this;
    }

    /* Close the database connection */

    public void close() {
        databaseHelper.close();
    }

    /* Add a new set of values to the databaase */

    public long insertRow(String name, int studentScore) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_SCORE, studentScore);

        // Insert it into the database
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    /* Delete a row from the database */

    public boolean deleteRow(long rowId) {
        String where = KEY_ROWID + " = " + rowId;
        return db.delete(DATABASE_TABLE, where, null) > 0;
    }

    /* Delete all the rows */

    public void deleteAll() {
        Cursor c = getAllRows();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()) {
            do {
                deleteRow(c.getLong((int) rowId));
            } while (c.moveToNext());
        }
        c.close();
    }

    public Cursor getAllRows() {
        String where = null;
        Cursor c = db.query(true, DATABASE_TABLE, ALL_KEYS,
                            where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    // Get a specific Row

    public Cursor getRow(long rowId) {
        String where = KEY_ROWID + " = " + rowId;
        Cursor c = db .query(true, DATABASE_TABLE, ALL_KEYS,
                            where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    // Change an existing row to be equal to new data
    public boolean updateRow(long rowId, String name, int studentScore) {
        String where = KEY_ROWID + "=" + rowId;

        ContentValues newValues = new ContentValues();
        newValues.put(KEY_NAME, name);
        newValues.put(KEY_SCORE, studentScore);

        // Insert into the database
        return db.update(DATABASE_TABLE, newValues, where, null) > 0;
    }


    public class DatabaseHelper extends SQLiteOpenHelper {

        // Constructor
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            SQLiteDatabase database = this.getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading application`s database from version " + oldVersion
                    + " to " + newVersion + " which will destroy all data!");

            // Destroy all database

            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);

            // Recreate new database

            onCreate(db);
        }
    }


}
