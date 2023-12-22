package com.example.brutal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AllActivity extends AppCompatActivity {

    TextView textBrutal1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        textBrutal1 = findViewById(R.id.textBrutal1);

    textBrutal1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(AllActivity.this, BuildingActivity.class);
            startActivity(intent);
        }
    });
    }
}