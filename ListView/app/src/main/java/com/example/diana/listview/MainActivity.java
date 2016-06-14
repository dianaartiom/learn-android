package com.example.diana.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static ListView listView;
    private static String[] NAMES = new String[] {"Mark", "Tom", "Jerry", "Patrick"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewMethod();
    }

    public void listViewMethod() {
        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.name_list, NAMES);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String)listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Postition: " + position + " Value: " + value, Toast.LENGTH_LONG).show();
            }
        });
    }
}
