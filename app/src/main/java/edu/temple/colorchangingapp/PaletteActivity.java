package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSecondActivity();
            }
        });
    }

    // Launching an activity with an intent wasn't working previously because it needed to happen in a method, I guess?
    public void showSecondActivity () {
        Intent intent = new Intent(this, CanvasActivity.class);
        startActivity(intent);
    }
}