package edu.temple.colorchangingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CanvasFragment extends Fragment {
    TextView textView;

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
        return v;
    }

    public void updateTextView (String selection) {
        textView.setText(selection);
    }
}