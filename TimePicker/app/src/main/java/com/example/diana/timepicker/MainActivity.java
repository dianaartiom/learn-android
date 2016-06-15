package com.example.diana.timepicker;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static TimePicker timePicker;
    private static Button buttonShowTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTime();
    }

    // Show the time picked
    public void showTime() {
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        buttonShowTime = (Button) findViewById(R.id.button);
        
        buttonShowTime.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), timePicker.getHour() + " : " + timePicker.getMinute(),
                        Toast.LENGTH_SHORT ).show();
            }
        });
    }
}
