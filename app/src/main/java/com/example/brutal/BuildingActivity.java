package com.example.brutal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BuildingActivity extends AppCompatActivity {

    TextView textBrutal6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);

        textBrutal6 = findViewById(R.id.textBrutal6);

        textBrutal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BuildingActivity.this, AllActivity.class);
                startActivity(intent);
            }
        });
    }
}