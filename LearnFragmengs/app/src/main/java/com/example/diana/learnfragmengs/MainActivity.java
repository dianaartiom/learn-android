package com.example.diana.learnfragmengs;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static Button buttonFragOne;
    private static Button buttonFragTwo;
    private static ViewGroup viewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showFragment(View view) {

        buttonFragOne = (Button) findViewById(R.id.button_one);
        buttonFragTwo = (Button) findViewById(R.id.button_two);
        viewGroup = (ViewGroup) findViewById(R.id.fragment_place);

        Fragment fragment;



        if(view == buttonFragOne) {
            fragment = new FragmentOne();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_place, fragment);
            fragmentTransaction.commit();
        }

        if (view == buttonFragTwo) {
            fragment = new FragmentTwo();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_place, fragment);
            fragmentTransaction.commit();
        }

    }

}
