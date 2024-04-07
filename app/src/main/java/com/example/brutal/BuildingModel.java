package com.example.brutal;

public class BuildingModel {

    private String id;
    private String name;
    private String architect;
    private String construction_date;
    private String city;
    private String country;
    private String description;
    private String description_source;
    private String maps_coordinates;
    private String maps_link;
    private String tags;
    private String status;
    private String photo_link;
    private String photo_source;
    private String links;
    private String is_favorite;

    public BuildingModel(String id, String name, String architect, String construction_date, String city,
                         String country, String description, String description_source, String maps_coordinates,
                         String maps_link, String tags, String status, String photo_link, String photo_source,
                         String links, String is_favorite){
        this.id = id;
        this.name = name;
        this.architect = architect;
        this.construction_date = construction_date;
        this.city = city;
        this.country = country;
        this.description = description;
        this.description_source = description_source;
        this.maps_coordinates = maps_coordinates;
        this.maps_link = maps_link;
        this.tags = tags;
        this.status = status;
        this.photo_link = photo_link;
        this.photo_source = photo_source;
        this.links = links;
        this.is_favorite = is_favorite;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArchitect() {
        return architect;
    }

    public String getConstruction_date() {
        return construction_date;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public String getDescription_source() {
        return description_source;
    }

    public String getMaps_coordinates() {
        return maps_coordinates;
    }

    public String getMaps_link() {
        return maps_link;
    }

    public String getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public String getPhoto_link() {
        return photo_link;
    }

    public String getPhoto_source() {
        return photo_source;
    }

    public String getLinks() {
        return links;
    }

    public String getIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(String is_favorite) {
        this.is_favorite = is_favorite;
    }
}
