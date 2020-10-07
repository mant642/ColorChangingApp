package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "edu.temple.colorchangingapp.MESSAGE";
    GridView gridView;
    ArrayList<String> colorList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getString(R.string.activity_name1));

        colorList = new ArrayList<>();
        colorList.add("white");
        colorList.add("blue");
        colorList.add("cyan");
        colorList.add("darkgrey");
        colorList.add("grey");
        colorList.add("green");
        colorList.add("lightgrey");
        colorList.add("magenta");
        colorList.add("red");

        gridView = findViewById(R.id.color_grid);

        ColorAdapter colorAdapter = new ColorAdapter(this, colorList);
        gridView.setAdapter(colorAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showSelection(parent.getItemAtPosition(position).toString());
                /*
                Context context = getApplicationContext();
                String selection = parent.getItemAtPosition(position).toString();
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context, selection, duration).show();
                 */

            }
        });

        /*
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSecondActivity();
            }
        });
         */

    }

    // Launching an activity with an intent wasn't working previously because it needed to happen in a method, I guess?
    /*
    public void showSecondActivity () {
        Intent intent = new Intent(this, CanvasActivity.class);
        startActivity(intent);
    }
     */

    public void showSelection(String selection) {
        Intent intent = new Intent(this, CanvasActivity.class);
        intent.putExtra(EXTRA_MESSAGE, selection);
        startActivity(intent);
    }
}