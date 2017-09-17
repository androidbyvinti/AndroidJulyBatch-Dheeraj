package com.bmpl.quizapp_dheeraj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView textView = (TextView)findViewById(R.id.scoreTextView);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        textView.setText("Your Score is : " + score);

    }
}
