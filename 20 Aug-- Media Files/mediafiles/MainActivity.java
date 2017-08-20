package com.bmpl.mediafiles;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //mp3 or mp4--> MediaPlayer class--> android.media-->
    // .mp3-->data-->song--> duration,
    // name-->
    // meta-data--> artist, track_image, etc
    //.mp4--> video size--> height/ width or duration/ controlling--> play pause forward back.

    MediaPlayer mediaPlayer;

    //Adapter--> Parent class

    ArrayAdapter arrayAdapter;

    String value[] = getResources().getStringArray(R.array.month);

    /*String value[] = {" value1 ", "value 2", "value 3 ",
                        "value 4", "value 5 ", "value 6",
                        "value 7 ", "value 8", "value 9",
                         "value 7 ", "value 8", "value 9",
                        "value 7 ", "value 8", "value 9"};*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.sample_music);

        ListView listView = (ListView)findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, value);

        listView.setAdapter(arrayAdapter);

        ImageButton play = (ImageButton)findViewById(R.id.playButton);
        ImageButton pause = (ImageButton)findViewById(R.id.pauseButton);
        ImageButton stop = (ImageButton)findViewById(R.id.stopButton);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.playButton:
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.sample_music);
                    mediaPlayer.start(); // play song
                } else {
                    mediaPlayer.start();
                }

                break;
            case R.id.pauseButton:
                mediaPlayer.pause();// pause song
                break;
            case R.id.stopButton:
                mediaPlayer.stop();// stop song
                mediaPlayer.release();
                mediaPlayer = null;
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }


    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}
