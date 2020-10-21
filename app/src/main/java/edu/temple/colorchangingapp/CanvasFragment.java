package edu.temple.colorchangingapp;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class CanvasFragment extends Fragment {
    TextView textView;
    FrameLayout frameLayout;
    String[] colorCompare;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);
        textView = v.findViewById(R.id.display_name);
        frameLayout = v.findViewById(R.id.frame_layout2);
        return v;
    }

    public void updateTextView (String selection) {
        textView.setText(selection);

        Resources res = getResources();
        colorCompare = res.getStringArray(R.array.color_list);

        if (selection.equals(colorCompare[0])) {
            frameLayout.setBackgroundColor(Color.WHITE);
        }
        if (selection.equals(colorCompare[1])) {
            frameLayout.setBackgroundColor(Color.BLUE);
        }
        if (selection.equals(colorCompare[2])) {
            frameLayout.setBackgroundColor(Color.CYAN);
        }
        if (selection.equals(colorCompare[3])) {
            frameLayout.setBackgroundColor(Color.DKGRAY);
        }
        if (selection.equals(colorCompare[4])) {
            frameLayout.setBackgroundColor(Color.GRAY);
        }
        if (selection.equals(colorCompare[5])) {
            frameLayout.setBackgroundColor(Color.GREEN);
        }
        if (selection.equals(colorCompare[6])) {
            frameLayout.setBackgroundColor(Color.LTGRAY);
        }
        if (selection.equals(colorCompare[7])) {
            frameLayout.setBackgroundColor(Color.MAGENTA);
        }
        if (selection.equals(colorCompare[8])) {
            frameLayout.setBackgroundColor(Color.RED);
        }
    }
}