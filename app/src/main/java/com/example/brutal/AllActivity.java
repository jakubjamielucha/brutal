package com.example.brutal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class AllActivity extends AppCompatActivity {

    TextView textBrutal1;


    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    ArrayList<String> name, architect, city, country, photo_link;
    DatabaseCopyHelper DB;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        textBrutal1 = findViewById(R.id.textBrutal1);

        DB = new DatabaseCopyHelper(this);
        name = new ArrayList<>();
        architect = new ArrayList<>();
        city = new ArrayList<>();
        country = new ArrayList<>();
        photo_link = new ArrayList<>();
        recyclerView = findViewById(R.id.listAll);
        adapter = new Adapter(this, name, architect, city, country);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

    textBrutal1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(AllActivity.this, BuildingActivity.class);
            startActivity(intent);
        }
    });
    }

    private void displayData() {
        Cursor cursor = DB.getData();

            while(cursor.moveToNext()){
                name.add(cursor.getString(1));
                architect.add(cursor.getString(2));
                city.add(cursor.getString(4));
                country.add(cursor.getString(5));
                photo_link.add(cursor.getString(6));
            }
        adapter.notifyDataSetChanged();

    }
}