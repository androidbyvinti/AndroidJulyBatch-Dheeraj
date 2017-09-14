package com.bmpl.quizapp_dheeraj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    int selection;
    TextView questionTextView;
    String questions[][] = { {"Who developed C language?", "What is increment operator?",
                                "Symbol of ternary operator", "Which is not a keyword",
                                "Which is not a type of loop?"},

                                {"Who developed C++ language?", "What are pointers?",
                                    "What are Features of OOPS?", "Which is not a keyword",
                                    "Type of inheritance"},
                                 {"Who developed java language?", "What is Bytecode",
                                         "What are Features of OOPS?", "Which is not a keyword",
                                "Type of inheritance"},
                                {"Who developed Android?", "What is DVM?",
                                        "What are Features of Android?", "Which is not a keyword",
                                        "Type of inheritance"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionTextView = (TextView)findViewById(R.id.question);

        Intent intent = getIntent();
        selection = intent.getIntExtra("selection", 0);
        Log.i("QuestionActivity","selected category = " + selection);

    }
}
