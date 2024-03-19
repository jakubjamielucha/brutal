package com.example.brutal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class AllActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<BuildingModel> buildings;
    BuildingsDatabase buildingsDatabase;
    TextView textBrutal1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        recyclerView = findViewById(R.id.listAll);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buildingsDatabase = new BuildingsDatabase(this);
        buildings = buildingsDatabase.getAllBuildings();

        adapter = new Adapter(this, buildings);
        recyclerView.setAdapter(adapter);

        textBrutal1 = findViewById(R.id.textBrutal1);

        textBrutal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

    }
}
