package com.example.diana.timepickerdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static Button button;
    static final int DIALOG_ID = 0;
    int hour;
    int min;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTimePickerDialog();
    }

    @Override
    public Dialog onCreateDialog(int id) {
        if(id == DIALOG_ID) {
            return new TimePickerDialog(MainActivity.this, kTimePickerListener, hour, min, false);
        }
        return null;
    }

    protected TimePickerDialog.OnTimeSetListener kTimePickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hour = hourOfDay;
            min = minute;
            Toast.makeText(MainActivity.this, hour + " : " + min, Toast.LENGTH_LONG).show();
        }
    };


    public void showTimePickerDialog() {
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }
}
