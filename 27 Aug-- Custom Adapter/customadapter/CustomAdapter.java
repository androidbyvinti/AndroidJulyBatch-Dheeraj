package com.bmpl.customadapter_dheeraj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.bmpl.customadapter_dheeraj.R.id.linearLayout;

public class CustomAdapter extends BaseAdapter{

    int images[];
    String data[];
    //MainActivity mainActivity;
    Context context;
    LayoutInflater layoutInflater;

    CustomAdapter(MainActivity mainActivity, int images[], String data[]){
        context = mainActivity;
        //this.mainActivity = mainActivity;
        this.images = images;
        this.data = data;
        //LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.linearLayout);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;//total length of array
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {


        view = layoutInflater.inflate(R.layout.adapter_custom, viewGroup, false);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        TextView textView = (TextView)view.findViewById(R.id.textView);

        imageView.setImageResource(images[i]);
        textView.setText(data[i]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "You clicked on Image " + i, Toast.LENGTH_LONG).show();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "You clicked on Text " + i, Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
