package com.bmpl.gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageView = (ImageView)findViewById(R.id.fullImageView);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        ImageAdapter imageAdapter = new ImageAdapter(this);

        imageView.setImageResource(imageAdapter.images[position]);
        Toast.makeText(this, "You clicked on "+position, Toast.LENGTH_LONG).show();
    }
}
