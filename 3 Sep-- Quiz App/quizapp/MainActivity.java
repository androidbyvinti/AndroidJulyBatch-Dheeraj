package com.bmpl.quizapp_dheeraj;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private static final int DELAY_TIMER = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
                finish();
            }
        }, DELAY_TIMER);
    }
}