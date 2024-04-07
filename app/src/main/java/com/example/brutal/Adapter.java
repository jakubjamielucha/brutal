package com.example.brutal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import com.squareup.picasso.Picasso;

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
        Picasso.get().load(building.getPhoto_link()).transform(new BlackWhiteTransformation()).into(holder.photo_link);
        holder.name.setText(building.getName());
        holder.architect.setText(building.getArchitect());
        holder.city.setText(building.getCity());
        holder.country.setText(building.getCountry());
        holder.construction_date = building.getConstruction_date();
        holder.description = building.getDescription();
        holder.description_source = building.getDescription_source();
        holder.maps_link = building.getMaps_link();
        holder.status = building.getStatus();
        holder.photo_source = building.getPhoto_source();
        holder.links = building.getLinks();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BuildingActivity.class);
                intent.putExtra("name", building.getName());
                intent.putExtra("architect", building.getArchitect());
                intent.putExtra("city", building.getCity());
                intent.putExtra("country", building.getCountry());
                intent.putExtra("photo_link", building.getPhoto_link());
                intent.putExtra("construction_date", building.getConstruction_date());
                intent.putExtra("description", building.getDescription());
                intent.putExtra("description_source", building.getDescription_source());
                intent.putExtra("status", building.getStatus());
                intent.putExtra("photo_source", building.getPhoto_source());
                intent.putExtra("links", building.getLinks());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return buildings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, architect, city, country;
        ImageView photo_link;
        String construction_date, description, description_source, maps_link, status,
                photo_source, links;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textNameLayout);
            architect = itemView.findViewById(R.id.textArchitectLayout);
            city = itemView.findViewById(R.id.textCityLayout);
            country = itemView.findViewById(R.id.textCountryLayout);
            photo_link = itemView.findViewById(R.id.imageLayout);
            // Similarly initialize other TextViews here
        }
    }
}
