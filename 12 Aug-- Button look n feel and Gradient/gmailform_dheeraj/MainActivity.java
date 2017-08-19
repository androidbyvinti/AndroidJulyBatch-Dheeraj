package com.bmpl.gmailform_dheeraj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText firstEditText, lastEditText, userNameEditText, passwordEditText,
                dayEditText, yearEditText;

    Spinner monthSpinner;
    Button loginButton;

    Temp temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        temp = new Temp();

    }

    private void initialize()
    {
        firstEditText = (EditText)findViewById(R.id.firstEditText);
        lastEditText = (EditText)findViewById(R.id.lastEditText);
        userNameEditText = (EditText)findViewById(R.id.userName);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);
        dayEditText = (EditText)findViewById(R.id.dayEditText);
        yearEditText = (EditText)findViewById(R.id.yearEditText);

        monthSpinner = (Spinner)findViewById(R.id.monthSpinner);
        loginButton = (Button)findViewById(R.id.loginButton);

        loginButton.setOnClickListener(this);

        firstEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean hasFocus) {

                firstEditText.setBackgroundResource(R.drawable.edittext_background);

                /*if(hasFocus){
                    firstEditText.setBackgroundResource(R.drawable.edittext_background);
                }*/
            }
        });
    }

    @Override
    public void onClick(View view) {

        //String first = firstEditText.getText().toString();
        //String last = lastEditText.getText().toString();


        //source and destination
        temp.setFirstName(firstEditText.getText().toString());

        //data pass between activities--> bundle

        //Bundle bundle = new Bundle();

        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
        //intent.putExtra("first", firstEditText.getText().toString());
        intent.putExtra("last", lastEditText.getText().toString());
        intent.putExtra("userName", userNameEditText.getText().toString());
        intent.putExtra("password", passwordEditText.getText().toString());
        intent.putExtra("day", dayEditText.getText().toString());
        intent.putExtra("year", yearEditText.getText().toString());
        intent.putExtra("month", monthSpinner.getSelectedItem().toString());

        //bundle.putString("first", firstEditText.getText().toString());

        //bundle.putAll(bundle);
        //startActivity(intent);//launch new screen
        startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
    }
}
