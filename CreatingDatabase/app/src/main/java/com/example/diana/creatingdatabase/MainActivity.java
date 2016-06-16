package com.example.diana.creatingdatabase;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
 * Steps to using the DB:
 * 1. Instatiate the DBAdapter
 * 2. Open the DataBase
 * 3. use get, insert, delete ... to change data
 * 4. Close the DB
 */

public class MainActivity extends AppCompatActivity {

    DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openDB();
    }

    /* Method for displayind the text */

    private void dispalyText(String message) {
        TextView textView = (TextView) findViewById(R.id.text_display);
        textView.setText(message);
    }

    /* DataBase stuff here */

    private void openDB() {
        db = new DBAdapter(this);
        db.open();
    }

    private void closeDB() {
        db.close();
    }



    /* Display the entire recordset to the screen */
    private void dispalyRecordSet(Cursor cursor) {
        String message = "";

        // populate the message from the cursor

        // Reset cursor to start, checking to see if there`s data
        if (cursor.moveToFirst()) {
            do {
                // Process the data

                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int studentScore = cursor.getInt(2);

                // Append data to the message

                message += "id=" + id
                            + ", name=" + name
                            + ", score=" + studentScore
                            + "\n";
            } while (cursor.moveToNext());
        }

        // Close the cursor to avoid resource leak
        cursor.close();

        dispalyText(message);
    }

    /* Action Listeners for all the three buttons */

    public void onAddButtonClick(View view) {
        dispalyText("Clicked Add Record!");

        long newId = db.insertRow("Adolph", 9);
        // Query for the record we just added
        // Use the ID
        Cursor cursor = db.getRow(newId);
        dispalyRecordSet(cursor);

    }

    public void onClearButtonClick(View view) {
        dispalyText("Clicked Clear Record!");
        db.deleteAll();
    }

    public void onDisplayRecordButtonClick(View view) {
        dispalyText("Clicked Display Record!");

        // Query for the record we just added
        // Use the ID
        Cursor cursor = db.getAllRows();
        dispalyRecordSet(cursor);
    }
}
