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
    private ArrayList name, architect, city, country;

    public Adapter(Context context, ArrayList name, ArrayList architect, ArrayList city, ArrayList country) {
        this.context = context;
        this.name = name;
        this.architect = architect;
        this.city = city;
        this.country = country;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.building_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.architect.setText(String.valueOf(architect.get(position)));
        holder.city.setText(String.valueOf(city.get(position)));
        holder.country.setText(String.valueOf(country.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, architect, city, country;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textNameLayout);
            architect = itemView.findViewById(R.id.textArchitectLayout);
            city = itemView.findViewById(R.id.textCityLayout);
            country = itemView.findViewById(R.id.textCountryLayout);
        }
    }
}
