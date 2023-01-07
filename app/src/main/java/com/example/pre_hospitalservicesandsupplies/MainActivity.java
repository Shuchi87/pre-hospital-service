package com.example.pre_hospitalservicesandsupplies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginIntent = new Intent(MainActivity.this,loginactivity.class);
                startActivity(loginIntent);

            }
        },3000);


        //Intent loginIntent = new Intent(MainActivity.this,loginactivity.class);
       // startActivity(loginIntent);
    }
}