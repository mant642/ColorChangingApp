package edu.temple.colorchangingapp;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorAdapter extends BaseAdapter {
    final Context context;
    final ArrayList<String> colors;

    public ColorAdapter (Context context, ArrayList<String> colors) {
        this.context = context;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return colors.size();
    }

    @Override
    public Object getItem(int position) {
        return colors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        // Perhaps this never runs in this case ... holdover from spinner after all, which has different properties ...
        if (convertView == null) {
            textView = new TextView(context);
            // textView.setPadding(0,5,0,5);
        } else {
            textView = (TextView) convertView;
        }

        textView.setText(getItem(position).toString());
        textView.setBackgroundColor(Color.parseColor(getItem(position).toString()));
        // Original: 0,5,0,5
        // 20's good
        textView.setPadding(40,40,40,40);

        return textView;
    }
}
