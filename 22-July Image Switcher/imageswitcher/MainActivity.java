package com.bmpl.imageswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button imageButton1, imageButton2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton1 = (Button)findViewById(R.id.imageButton1);
        imageButton2 = (Button)findViewById(R.id.imageButton2);

        imageView = (ImageView)findViewById(R.id.imageView);

        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.imageButton1:
                imageView.setImageResource(R.drawable.image2);
                break;

            case R.id.imageButton2:
                imageView.setImageResource(R.drawable.images2);
                break;

        }
    }
}