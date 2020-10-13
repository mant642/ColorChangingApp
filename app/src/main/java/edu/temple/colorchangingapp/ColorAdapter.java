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
        // Original, doesn't work with French translation
        // textView.setBackgroundColor(Color.parseColor(getItem(position).toString()));
        if (getItem(position).toString().equals("white")||getItem(position).toString().equals("blanche")) {
            textView.setBackgroundColor(Color.WHITE);
        }
        if (getItem(position).toString().equals("blue")||getItem(position).toString().equals("bleue")) {
            textView.setBackgroundColor(Color.BLUE);
        }
        if (getItem(position).toString().equals("cyan")||getItem(position).toString().equals("cyan")) {
            textView.setBackgroundColor(Color.CYAN);
        }
        if (getItem(position).toString().equals("darkgrey")||getItem(position).toString().equals("grisfoncé")) {
            textView.setBackgroundColor(Color.DKGRAY);
        }
        if (getItem(position).toString().equals("grey")||getItem(position).toString().equals("grise")) {
            textView.setBackgroundColor(Color.GRAY);
        }
        if (getItem(position).toString().equals("green")||getItem(position).toString().equals("verte")) {
            textView.setBackgroundColor(Color.GREEN);
        }
        if (getItem(position).toString().equals("lightgrey")||getItem(position).toString().equals("grisclair")) {
            textView.setBackgroundColor(Color.LTGRAY);
        }
        if (getItem(position).toString().equals("magenta")||getItem(position).toString().equals("magenta")) {
            textView.setBackgroundColor(Color.MAGENTA);
        }
        if (getItem(position).toString().equals("red")||getItem(position).toString().equals("rouge")) {
            textView.setBackgroundColor(Color.RED);
        }
        // Original: 0,5,0,5
        // 20's good
        textView.setPadding(40,40,40,40);

        return textView;
    }
}
