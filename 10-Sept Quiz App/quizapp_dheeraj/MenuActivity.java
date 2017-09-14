package com.bmpl.quizapp_dheeraj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void buttonClicked(View view){

        Intent intent = new Intent(this, QuestionActivity.class);
        switch (view.getId()){
            case R.id.cButton:
                intent.putExtra("selection", 0);
                break;
            case R.id.cPlusButton:
                intent.putExtra("selection", 1);
                break;
            case R.id.javaButton:
                intent.putExtra("selection", 2);
                break;
            case R.id.androidButton:
                intent.putExtra("selection", 3);
                break;
        }
        startActivity(intent);
    }
}
