package edu.cascadia.orcastars.db;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import edu.cascadia.orcastars.model.Business;

@Entity(tableName = "businesses")
public class BusinessEntity implements Business {
    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private String hours;
    private String location;
    private int logo;
    private int photo;


    @Ignore
    public BusinessEntity(int id, String name, String description,
                          String hours, String location, int logo, int photo){
        this.id = id;
        this.name = name;
        this.description = description;
        this.hours = hours;
        this.location = location;
        this.logo = logo;
        this.photo = photo;
    }

    public BusinessEntity(Business business){
        this.id = business.getId();
        this.name = business.getName();
        this.description = business.getDescription();
        this.hours = business.getHours();
        this.location = business.getLocation();
        this.logo = business.getLogo();
        this.photo = business.getPhoto();
    }

    public BusinessEntity(){}

    public int getId() {
        return id;
    }
    public void setId(int id){this.id = id;}

    public String getName() {
        return name;
    }
    public void setName(String name){this.name = name;}

    public String getDescription() {
        return description;
    }
    public void setDescription(String description){this.description = description;}

    public String getHours() {
        return hours;
    }
    public void setHours(String hours){this.hours = hours;}

    public String getLocation() {
        return location;
    }
    public void setLocation(String location){this.location = location;}

    public int getLogo() {
        return logo;
    }
    public void setLogo(int logo){this.logo = logo;}

    public int getPhoto() {
        return photo;
    }
    public void setPhoto(int photo){this.photo = photo;}
}
