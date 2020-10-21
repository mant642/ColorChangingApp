package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements PaletteFragment.PaletteFragmentListener {
    public static final String EXTRA_MESSAGE = "edu.temple.colorchangingapp.MESSAGE";
    ArrayList<String> colorList;
    CanvasFragment f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        colorList = new ArrayList<>();
        Resources res = getResources();
        Collections.addAll(colorList, res.getStringArray(R.array.color_list));

        PaletteFragment f1 = PaletteFragment.newInstance(colorList);
        f2 = new CanvasFragment();

        ft.replace(R.id.frameLayout, f1);
        ft.replace(R.id.frameLayout2, f2);
        ft.commit(); 

        // Originally part of Canvas Activity, should probably to transferred to CanvasFragment
        /*
        colorList = new ArrayList<>();
        Resources res = getResources();
        Collections.addAll(colorList, res.getStringArray(R.array.color_list));

        gridView = findViewById(R.id.color_grid);

        ColorAdapter colorAdapter = new ColorAdapter(this, colorList);
        gridView.setAdapter(colorAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showSelection(parent.getItemAtPosition(position).toString());
            }
        });
         */
    }

    @Override
    public void onColorSelected(String chosenColor) {
        f2.updateTextView(chosenColor);
    }
}