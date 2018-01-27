package com.bmpl.internalstorage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameEditText, passwordEditText;
    Button submitButton, readButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        submitButton = (Button)findViewById(R.id.submitButton);
        readButton = (Button)findViewById(R.id.readButton);

        submitButton.setOnClickListener(this);
        readButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        //String fileName = "user_details";


        switch (view.getId())
        {


            case R.id.submitButton:
                //Buffered // Writer--> OutputStreamWriter/BufferedWriter

                //Efficient Process of Writing data
                //By creating Buffer

                //Mode_private--> overwrite previously created data
                //Mode_Append--> Append data at end of file
                try {

                    String name = nameEditText.getText().toString();
                    String password = passwordEditText.getText().toString();
                    //data write-->1st--> file name
                    //Mode_Private--> Overwrite
                    //Mode_Append--> append endoffile
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(openFileOutput("user_details.txt", MODE_APPEND)));

                    bufferedWriter.write(name +"\n");
                    bufferedWriter.write(password + "\n");

                    Toast.makeText(this, "Data written", Toast.LENGTH_LONG).show();

                    bufferedWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

            case R.id.readButton:
                //Reader// InputStreamReader/BufferedReader

                try {
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(openFileInput("user_details")));

                    String data;

                    while((data = bufferedReader.readLine())!=null)
                    {
                        Toast.makeText(this, "Data is= " +data, Toast.LENGTH_LONG).show();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
        }

    }
}