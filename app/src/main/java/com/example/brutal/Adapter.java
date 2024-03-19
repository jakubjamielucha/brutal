package com.example.brutal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private ArrayList<BuildingModel> buildings;

    public Adapter(Context context, ArrayList<BuildingModel> buildings) {
        this.context = context;
        this.buildings = buildings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.building_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BuildingModel building = buildings.get(position);
        holder.name.setText(building.getName());
        holder.architect.setText(building.getArchitect());
        holder.city.setText(building.getCity());
        holder.country.setText(building.getCountry());
        // Similarly set other fields here
    }

    @Override
    public int getItemCount() {
        return buildings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, architect, city, country;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textNameLayout);
            architect = itemView.findViewById(R.id.textArchitectLayout);
            city = itemView.findViewById(R.id.textCityLayout);
            country = itemView.findViewById(R.id.textCountryLayout);
            // Similarly initialize other TextViews here
        }
    }
}
