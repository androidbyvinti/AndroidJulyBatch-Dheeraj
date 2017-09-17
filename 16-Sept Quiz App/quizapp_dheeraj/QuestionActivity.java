package com.bmpl.quizapp_dheeraj;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private int selection;
    private int currentQuestion = 0, score = 0;
    private TextView questionTextView;
    private Button nextButton;
    private RadioGroup radioGroup;
    private String selectedText;

    /*String questions[][] = { {"Who developed C language?", "What is increment operator?",
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
                                        "Type of inheritance"}};*/

    /*String options[][][] ={{{"Option 1A", "Option 1B", "Option 1C", "Option 1D"}},
                        {"Option 2A", "Option 2B", "Option 2C", "Option 2D"},
                        {"Option 3A", "Option 3B", "Option 3C", "Option 3D"},
                        {"Option 4A", "Option 4B", "Option 4C", "Option 4D"},
                        {"Option 5A", "Option 5B", "Option 5C", "Option 5D"}};*/

    private RadioButton option1, option2, option3, option4, radioButton;
    private String questions[];
    private String options[], answer[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        downcast();

        questions = getResources().getStringArray(R.array.cquestions);
        options = getResources().getStringArray(R.array.coptions);
        answer = getResources().getStringArray(R.array.canswer);

        /*Intent intent = getIntent();
        selection = intent.getIntExtra("selection", 0);
        Log.i("QuestionActivity","selected category = " + selection);*/

        nextQuestion();

        nextButton.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        nextButton.setEnabled(false);
    }

/*    public void optionSelected(View view){

    }*/

    private void downcast()
    {
        questionTextView = (TextView)findViewById(R.id.question);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        option1 = (RadioButton)findViewById(R.id.radioButton1);
        option2 = (RadioButton)findViewById(R.id.radioButton2);
        option3 = (RadioButton)findViewById(R.id.radioButton3);
        option4 = (RadioButton)findViewById(R.id.radioButton4);

        nextButton = (Button)findViewById(R.id.nextButton);
    }

    @Override
    public void onClick(View view) {
        if(selectedText.equals(answer[currentQuestion])){
            score++;
        }
        //if(answer[currentQuestion]== options[4* currentQuestion + selectedId]);
        currentQuestion++;
        if(questions.length>=3){

        }
        nextQuestion();
    }

    private void nextQuestion(){
        questionTextView.setText(questions[currentQuestion]);
        option1.setText(options[4* currentQuestion + 0]);
        option2.setText(options[4* currentQuestion + 1]);
        option3.setText(options[4* currentQuestion + 2]);
        option4.setText(options[4* currentQuestion + 3]);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        nextButton.setEnabled(true);
        selectedText = ((RadioButton)findViewById(i)).getText().toString();

        //selectedId = i;
    }
}
