package com.example.brutal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class BuildingActivity extends AppCompatActivity {

    TextView textBrutal6, buildingName, buildingArchitect, buildingLocation, buildingYear, buildingStatus,
            buildingDescription, buildingLinks, buildingMap, buildingPhotoSource, buildingDescriptionSource;
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
        buildingPhotoSource = findViewById(R.id.buildingPhotoSource);
        buildingDescriptionSource = findViewById(R.id.buildingDescriptionSource);

        imageBuilding = findViewById(R.id.imageBuilding);

        starButton = findViewById(R.id.starButton);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String architect = intent.getStringExtra("architect");
            String city = intent.getStringExtra("city");
            String country = intent.getStringExtra("country");
            String photo_link = intent.getStringExtra("photo_link");
            String construction_date = intent.getStringExtra("construction_date");
            String description = intent.getStringExtra("description");
            String description_source = intent.getStringExtra("description_source");
            String status = intent.getStringExtra("status");
            String photo_source = intent.getStringExtra("photo_source");
            String links = intent.getStringExtra("links");

            buildingName.setText(name);
            buildingArchitect.setText(architect);
            buildingLocation.setText(city + ", " + country);
            Picasso.get().load(photo_link).transform(new BlackWhiteTransformation()).into(imageBuilding);
            buildingYear.setText(construction_date);
            buildingDescription.setText(description);
            buildingDescriptionSource.setText("Description source:\n" + description_source);
            buildingStatus.setText(status);
            buildingPhotoSource.setText("Photo source:\n" + photo_source);
            String[] linksArray = links.split(" ");
            String formattedLinks = TextUtils.join("\n", linksArray);
            buildingLinks.setText("Links:\n" + formattedLinks);
        }

        textBrutal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BuildingActivity.this, AllActivity.class);
                startActivity(intent);
            }
        });
    }
}