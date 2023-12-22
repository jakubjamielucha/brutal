package com.example.brutal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class BuildingActivity extends AppCompatActivity {

    TextView textBrutal6, buildingName, buildingArchitect, buildingLocation, buildingYear, buildingStatus, buildingDescription, buildingLinks, buildingMap;
    ImageView imageBuilding;
    ImageButton starButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);

        textBrutal6 = findViewById(R.id.textBrutal6);
        buildingName = findViewById(R.id.buildingName);
        buildingName = findViewById(R.id.buildingName);
        buildingArchitect = findViewById(R.id.buildingArchitect);
        buildingLocation = findViewById(R.id.buildingLocation);
        buildingYear = findViewById(R.id.buildingYear);
        buildingStatus = findViewById(R.id.buildingStatus);
        buildingDescription = findViewById(R.id.buildingDescription);
        buildingLinks = findViewById(R.id.buildingLinks);
        buildingMap = findViewById(R.id.buildingMap);

        imageBuilding = findViewById(R.id.imageBuilding);

        starButton = findViewById(R.id.starButton);

        textBrutal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BuildingActivity.this, AllActivity.class);
                startActivity(intent);
            }
        });
    }
}