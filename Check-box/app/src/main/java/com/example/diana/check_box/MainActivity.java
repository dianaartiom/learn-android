package com.example.diana.check_box;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBox_cat, checkBox_dog, checkBox_panda;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        checkBox_cat = (CheckBox) findViewById(R.id.cat_check_box);
        checkBox_dog = (CheckBox) findViewById(R.id.dog_check_box);
        checkBox_panda = (CheckBox) findViewById(R.id.panda_check_box);
        buttonSubmit = (Button) findViewById(R.id.button);

        buttonSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        StringBuffer result = new StringBuffer();
                        result.append("Dog : ").append(checkBox_dog.isChecked()); // if it`s checked - that will give you true, otherwise - false
                        result.append("Cat : ").append(checkBox_cat.isChecked());
                        result.append("Panda : ").append(checkBox_panda.isChecked());

                        Toast.makeText(
                                MainActivity.this, result.toString(), Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

    }
}
