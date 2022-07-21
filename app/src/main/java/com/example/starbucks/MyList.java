package com.example.starbucks;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MyList extends ArrayAdapter<String>
{
    Activity context;
    private final String[] name;
    private final Integer[] img;

    public MyList(Activity context, String[] name, Integer[] img) {
        super(context,R.layout.activity_payment2,name);
        this.context = context;
        this.name =name;
        this.img = img;
    }
    public View getView(int postion , View view, ViewGroup parent)
    {
        LayoutInflater inflate = context.getLayoutInflater();
        View rowview = inflate.inflate(R.layout.list_activity,null,true);
        TextView name2 = rowview.findViewById(R.id.title);
        ImageView img2= rowview.findViewById(R.id.icon);
        name2.setText(name[postion]);
        img2.setImageResource(img[postion]);
        return  rowview;
    }
}













