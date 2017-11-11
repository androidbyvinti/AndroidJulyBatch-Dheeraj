package com.bmpl.fetchingsongs;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;
    //ArrayList<SongData> arrayList;
    ArrayList arrayList;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        arrayList = new ArrayList();

        getSongs();

        ListAdapter listAdapter = new SimpleAdapter(this, arrayList, R.layout.activity_main, new String[]{"title"}, new int[]{R.id.listView});

        //arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayList);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Uri uri = Uri.parse(arrayList.get(i).toString());

                mediaPlayer = MediaPlayer.create(MainActivity.this, uri);
                mediaPlayer.start();
            }
        });

    }

    void getSongs(){

        // common data --> different app can access --> not private
        // Public directory --> ContentResolver -->

        // Read_External_Storage
        // static permission --> till Lollipop
        // runtime permission --> with marshmallow


        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;   // Internal URI(Built-in music) or External URI(User Downloaded data)

        String musicFiles = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        String order = MediaStore.Audio.Media.TITLE + " ASC";

        ContentResolver contentResolver = this.getContentResolver();

        Cursor cursor = contentResolver.query(uri, null, musicFiles,null, order);



        if(cursor!=null) {
            while (cursor.moveToNext()) {

                String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));// path of song

                //arrayList.add(new SongData(title, path));

                HashMap hashMap = new HashMap();
//
                hashMap.put("title", title);
                hashMap.put("path", path);


                Log.i("MainActivity", "title= "+ title);
                Log.i("MainActivity", "path= "+ path);

                arrayList.add(hashMap);

            }
        }
    }

}