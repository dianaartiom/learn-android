package com.example.diana.rating_bar;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static RatingBar ratingBar;
    private static TextView textView;
    private static Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listenerForRatingBar();
        onButtonClickListener();
    }

    public void listenerForRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        textView = (TextView) findViewById(R.id.textView);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView.setText(String.valueOf(rating));
            }
        });
    }

    public void onButtonClickListener() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        buttonSubmit = (Button) findViewById(R.id.button);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
