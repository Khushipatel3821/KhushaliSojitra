package com.application.jsoncrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdpter extends BaseAdapter
{
    Context context;
    List<Model>list;

    public MyAdpter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater in = LayoutInflater.from(context);
        view = in.inflate(R.layout.designj, viewGroup,false);
        TextView textView = view.findViewById(R.id.txt2);
        TextView textView1 = view.findViewById(R.id.txt3);
        TextView textView2 = view.findViewById(R.id.txt4);

        textView.setText(list.get(i).name);
        textView1.setText(list.get(i).price);
        textView2.setText(list.get(i).des);

        return view;
    }
}
