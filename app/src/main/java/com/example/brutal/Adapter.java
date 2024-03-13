package com.example.brutal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private ArrayList id, name, architect, city, country, photo_link;

    public Adapter(Context context, ArrayList id, ArrayList name, ArrayList architect, ArrayList city, ArrayList country, ArrayList photo_link) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.architect = architect;
        this.city = city;
        this.country = country;
        this.photo_link = photo_link;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.building_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, architect, city, country;
        ImageView photo_link;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
