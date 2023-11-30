package com.example.brutal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MapActivity extends AppCompatActivity {

    TextView textBrutal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        textBrutal2 = findViewById(R.id.textBrutal2);

        textBrutal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}