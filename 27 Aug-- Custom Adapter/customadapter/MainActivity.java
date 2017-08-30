package com.bmpl.customadapter_dheeraj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;

    String data[] = {"Cupcake", "Donut", "Eclair",
                    "Froyo", "GingerBread", "HoneyComb",
                    "Ice-cream Sandwich", "JellyBean",
                    "Kitkat", "Lollipop", "Marshmallow",
                    "Nougat", "Oreo"};

    int images[] = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher,R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, data);

        CustomAdapter customAdapter = new CustomAdapter(this, images, data);

        listView.setAdapter(customAdapter);

/*        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(getApplicationContext(), "You clicked " +i, Toast.LENGTH_LONG).show();
            }
        });*/
        //listView.setAdapter(arrayAdapter);
    }
}
