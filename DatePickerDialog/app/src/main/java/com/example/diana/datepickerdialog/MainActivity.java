package com.example.diana.datepickerdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static Button buttonShowDateTimePickerDialog;
    static final int DIALOG_ID = 0;
    int _day;
    int _month;
    int _year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar calendar = Calendar.getInstance();
        _year = calendar.get(Calendar.YEAR);
        _month = calendar.get(Calendar.MONTH) + 1 ;
        _day = calendar.get(Calendar.DAY_OF_MONTH) + 1;

        showDialog();
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if(id == DIALOG_ID) {
            return new DatePickerDialog(this, datePickerListener, _year, _month, _day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    _day = dayOfMonth;
                    _month = monthOfYear;
                    _year = year;

                    Toast.makeText(MainActivity.this, _day + " / " + _month + " / " + _year, Toast.LENGTH_LONG).show();
            }
    };

    public void showDialog() {
        buttonShowDateTimePickerDialog = (Button) findViewById(R.id.button);

        buttonShowDateTimePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }


}
