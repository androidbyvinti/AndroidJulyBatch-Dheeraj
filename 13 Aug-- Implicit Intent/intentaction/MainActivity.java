package com.bmpl.intentaction;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View view){

        try {

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            //intent.putExtra(Intent.EXTRA_TEXT, "This is my data1");
            intent.putExtra(Intent.EXTRA_TEXT, "This is my data2");
            startActivity(intent);

        } catch (ActivityNotFoundException e){
            Toast.makeText(this, "Activity not found", Toast.LENGTH_LONG).show();
        }



    }
}
