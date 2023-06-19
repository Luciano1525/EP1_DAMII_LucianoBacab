package com.example.ep1_damii_lucianobacab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter1 extends BaseAdapter{
    Context context1;
    List<Contacto1> lst1;

    public CustomAdapter1(Context context1, List<Contacto1> lst1) {
        this.context1 = context1;
        this.lst1 = lst1;
    }
    @Override
    public int getCount(){
        return lst1.size();
    }

    @Override
    public Object getItem(int i){
        return i;
    }

    @Override
    public long getItemId(int i){
        return i;
    }
    @Override
    public View getView(int i, View view1, ViewGroup viewGroup){
        ImageView IVP1;
        TextView TVP1;
        Contacto1 c1 = lst1.get(i);

        if(view1==null){
            view1 = LayoutInflater.from(context1).inflate(R.layout.activity_planeta, null);
            IVP1 = view1.findViewById(R.id.IVP1);
            TVP1 = view1.findViewById(R.id.TVP1);

            IVP1.setImageResource(c1.IVP1);
            TVP1.setText(c1.TVP1);
        }

        return view1;
    }
}
