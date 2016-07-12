package com.example.diana.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static Button buttonSwitchImages;
    private static ImageView imageView;
    private int current_image_index;

    int[] images = {R.drawable.icon, R.drawable.flat_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonSwitchImageClicked();
    }

    public void onButtonSwitchImageClicked() {
        imageView = (ImageView) findViewById(R.id.imageView);
        buttonSwitchImages = (Button) findViewById(R.id.switch_img_button);

        buttonSwitchImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_image_index++;
                current_image_index = current_image_index % images.length;
                imageView.setImageResource(images[current_image_index]);
            }
        });
    }
}
