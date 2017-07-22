package com.bmpl.greetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Global
    EditText nameEditText, passwordEditText;
    Button submitButton, cancelButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Local
        //EditText nameEditText, passwordEditText;

        //initialize is always done here
        //Downcast--> return bigger scope but reduce lesser scope
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        submitButton = (Button) findViewById(R.id.submitButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        textView = (TextView) findViewById(R.id.resultTextView);

        //Hello obj = new Hello();

        //step-2: Attach listener       //anonymous--> inner class with no name reference
        submitButton.setOnClickListener(new View.OnClickListener() {
            //step-3: Attach Handler
            @Override
            public void onClick(View view) {

                String name = nameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if(name.isEmpty() || password.isEmpty()){

                    Toast.makeText(MainActivity.this, "Enter your details first", Toast.LENGTH_LONG).show();

                    /*nameEditText.setError("Enter Name");
                    passwordEditText.setError("Enter Password");*/
                }

/*                if(name.length() == 0 || password.length() == 0 ){
                    textView.setText("Enter Your Details First");
                }*/
                else
                textView.setText("Welcome " + name + "\n" + password);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEditText.setText("");
                passwordEditText.setText("");
                textView.setText("");
            }
        });

    }
}
