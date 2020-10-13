package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        setTitle(getString(R.string.activity_name2));

        layout = findViewById(R.id.layout);

        Intent intent = getIntent();
        String selection = intent.getStringExtra(PaletteActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textView2);
        textView.setText(selection);

        // Original implementation, not compatible with alternative languages
        //layout.setBackgroundColor(Color.parseColor(selection));

        /*
        if (selection.equals("white")||selection.equals("blanche")) {
            textView.setBackgroundColor(Color.WHITE);
        }
         */

        if (selection.equals("white")||selection.equals("blanche")) {
            layout.setBackgroundColor(Color.WHITE);
        }
        if (selection.equals("blue")||selection.equals("bleue")) {
            layout.setBackgroundColor(Color.BLUE);
        }
        if (selection.equals("cyan")) {
            layout.setBackgroundColor(Color.CYAN);
        }
        if (selection.equals("darkgrey")||selection.equals("grisfoncé")) {
            layout.setBackgroundColor(Color.DKGRAY);
        }
        if (selection.equals("grey")||selection.equals("grise")) {
            layout.setBackgroundColor(Color.GRAY);
        }
        if (selection.equals("green")||selection.equals("verte")) {
            layout.setBackgroundColor(Color.GREEN);
        }
        if (selection.equals("lightgrey")||selection.equals("grisclair")) {
            layout.setBackgroundColor(Color.LTGRAY);
        }
        if (selection.equals("magenta")) {
            layout.setBackgroundColor(Color.MAGENTA);
        }
        if (selection.equals("red")||selection.equals("rouge")) {
            layout.setBackgroundColor(Color.RED);
        }
    }
}