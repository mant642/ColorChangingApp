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

import java.util.ArrayList;
import java.util.Collections;

public class PaletteFragment extends Fragment {
    // ArrayList<String> colorList;
    GridView gridView;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String COLOR_LIST = "colorlist";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private ArrayList<String> colorList;


    public PaletteFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PaletteFragment.
     */


    // TODO: Rename and change types and number of parameters
    public static PaletteFragment newInstance(ArrayList<String> colorList) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(COLOR_LIST, colorList);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            colorList = getArguments().getStringArrayList(COLOR_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        colorList = new ArrayList<>();
        Resources res = getResources();
        Collections.addAll(colorList, res.getStringArray(R.array.color_list));

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
            }
        });

        return v;
    }
}