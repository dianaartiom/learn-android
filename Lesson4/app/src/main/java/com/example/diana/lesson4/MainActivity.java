package com.example.diana.lesson4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText password_field;
    public Button button_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListernerOnButton();
    }



    public void addListernerOnButton() {
        password_field = (EditText) findViewById(R.id.pass);
        button_submit = (Button) findViewById(R.id.button);

        button_submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(
                                MainActivity.this, password_field.getText(), Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );
    }
}
