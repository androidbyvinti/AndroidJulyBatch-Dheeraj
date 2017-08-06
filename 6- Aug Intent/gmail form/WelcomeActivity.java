package com.bmpl.gmailform_dheeraj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textView = (TextView)findViewById(R.id.welcomeTextView);

        Intent intent = getIntent();
        String first = intent.getStringExtra("first");

        textView.setText("Welcome " + first + "\n" +
                            intent.getStringExtra("last") + "\n" +
                            intent.getStringExtra("userName") + "\n" +
                            intent.getStringExtra("password") + "\n" +
                            intent.getStringExtra("day") + "\n" +
                            intent.getStringExtra("month")+ "\n" +
                            intent.getStringExtra("year"));



    }
}