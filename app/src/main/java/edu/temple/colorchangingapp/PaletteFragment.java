package edu.temple.colorchangingapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class PaletteFragment extends Fragment {
    // ArrayList<String> colorList;
    GridView gridView;

    private static final String COLOR_LIST = "colorlist";

    private ArrayList<String> colorList;

    private PaletteFragmentListener listener;


    public PaletteFragment() {
        // Required empty public constructor
    }

    public static PaletteFragment newInstance(ArrayList<String> colorList) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(COLOR_LIST, colorList);
        fragment.setArguments(args);
        return fragment;
    }

    public interface PaletteFragmentListener {
        void onColorSelected(String chosenColor);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            colorList = getArguments().getStringArrayList(COLOR_LIST);
        }
         */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        /*
        colorList = new ArrayList<>();
        Resources res = getResources();
        Collections.addAll(colorList, res.getStringArray(R.array.color_list));
         */

        if (getArguments() != null) {
            colorList = getArguments().getStringArrayList(COLOR_LIST);

        }

        gridView = v.findViewById(R.id.color_grid);
        // gridView = findViewById(R.id.color_grid);

        // gridView.setAdapter(new ColorAdapter(getActivity(), colorList));
        // "this" is seemingly unchanged, but actually context has changed from "MainActivity" to "PaletteActivity"
        // Also, that doesn't work
        ColorAdapter colorAdapter = new ColorAdapter(getActivity(), colorList);
        // ColorAdapter colorAdapter = new ColorAdapter(context, colorList);
        gridView.setAdapter(colorAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // showSelection(parent.getItemAtPosition(position).toString());
                String selection = parent.getItemAtPosition(position).toString();
                listener.onColorSelected(selection);
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PaletteFragmentListener) {
            listener = (PaletteFragmentListener) context;
        } else {
            throw new RuntimeException("Forget to implement PaletteActivityListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}