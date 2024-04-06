package com.example.brutal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView textHeadMenu, textAll, textMap, textFav, textShop, textContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textHeadMenu = findViewById(R.id.textHeadMenu);
        textAll = findViewById(R.id.textAll);
        textMap = findViewById(R.id.textMap);
        textFav = findViewById(R.id.textFav);
        textShop = findViewById(R.id.textShop);
        textContact = findViewById(R.id.textContact);

        //copyDatabase();

        textHeadMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        textAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,AllActivity.class);
                startActivity(intent);
            }
        });

        textMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });

        textFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,FavoritesActivity.class);
                startActivity(intent);
            }
        });

        textShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,ShopActivity.class);
                startActivity(intent);
            }
        });

        textContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,ContactActivity.class);
                startActivity(intent);
            }
        });


    }

    public void copyDatabase()
    {
        try {

            DatabaseCopyHelper helper = new DatabaseCopyHelper(MenuActivity.this);
            helper.createDataBase();
            helper.openDataBase();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}