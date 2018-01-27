package com.bmpl.externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameEditText, salaryEditText;
    Button saveButton, readButton;

    // path-->
    File pathOfSdCard;
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//root of sd card
        pathOfSdCard = Environment.getExternalStorageDirectory();

        file = new File(pathOfSdCard, "details");

        nameEditText = (EditText)findViewById(R.id.nameEditText);
        salaryEditText = (EditText)findViewById(R.id.salaryEditText);

        saveButton = (Button)findViewById(R.id.saveButton);
        readButton = (Button)findViewById(R.id.readButton);

        saveButton.setOnClickListener(this);
        readButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.saveButton:

                String name = nameEditText.getText().toString();
                String salary = salaryEditText.getText().toString();

                if(pathOfSdCard.canWrite())
                {


                    try {
                        FileWriter fileWriter = new FileWriter(file);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                        bufferedWriter.write(name + "\n");
                        bufferedWriter.write(salary + "\n");

                        bufferedWriter.close();
                        Toast.makeText(this, "Data written", Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    Toast.makeText(this, "Not able to write", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.readButton:

                try {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String data;

                    while ((data = bufferedReader.readLine())!=null){
                            Toast.makeText(this, data, Toast.LENGTH_LONG).show();
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