package com.bmpl.gmailform_dheeraj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView textView;
    Temp temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textView = (TextView)findViewById(R.id.welcomeTextView);

        Intent intent = getIntent();

        //Bundle bundle = intent.getExtras();

        //Bundle bundle = getIntent().getExtras();
        //String data = bundle.getString("first", null);
        //String data = bundle.get("first").toString();

        String first = intent.getStringExtra("first");

        temp = new Temp();

        String firstName = temp.getFirstName();

        textView.setText("Welcome " + first + "\n" +
                            intent.getStringExtra("last") + "\n" +
                            intent.getStringExtra("userName") + "\n" +
                            intent.getStringExtra("password") + "\n" +
                            intent.getStringExtra("day") + "\n" +
                            intent.getStringExtra("month")+ "\n" +
                            intent.getStringExtra("year"));
    }
}