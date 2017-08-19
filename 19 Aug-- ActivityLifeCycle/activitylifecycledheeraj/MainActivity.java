package com.bmpl.activitylifecycledheeraj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "inside onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "inside onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "inside onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "inside onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "inside onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "inside onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "inside onRestart()");
    }
}
