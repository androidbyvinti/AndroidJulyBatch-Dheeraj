package com.bmpl.musicfiles_dheeraj;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // path
    //MediaPlayer class --> play, pause, stop, duration, loop, etc

    MediaPlayer mediaPlayer;

    ImageButton playButton, pauseButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Context is predefined class in android --> without activity
        mediaPlayer = MediaPlayer.create(this, R.raw.song); //linking of my audio file with activity

        playButton = (ImageButton)findViewById(R.id.playButton);
        pauseButton = (ImageButton)findViewById(R.id.pauseButton);
        stopButton = (ImageButton)findViewById(R.id.stopButton);

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.playButton:
                if(mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.song);
                }
                mediaPlayer.start();

                playButton.setImageResource(android.R.drawable.ic_media_pause);
                break;

            case R.id.pauseButton:
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause(); // will pause the playing file
                }
                break;

            case R.id.stopButton:
                mediaPlayer.stop(); // will stop the playing file
                mediaPlayer = null;
                break;

        }
    }

    //at pause -->
    @Override
    public void onPause(){
        super.onPause();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    @Override
    public void onRestart(){
        super.onRestart();
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }

}
