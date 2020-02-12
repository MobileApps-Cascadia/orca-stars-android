package edu.cascadia.orcastars.DB;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "businesses")
public class BusinessEntity implements Business{
    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private String hours;
    private String location;
    private int logo;
    private int photo;

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

    public BusinessEntity(){};

    public int getId() {
        return id;
    }
    public void setId(int id){this.id = id;}

    public String getName() {
        return name;
    }
    public void setName(){this.name = name;}

    public String getDescription() {
        return description;
    }
    public void setDescription(){this.description = description;}

    public String getHours() {
        return hours;
    }
    public void setHours(){this.hours = hours;}

    public String getLocation() {
        return location;
    }
    public void setLocation(){this.location = location;}

    public int getLogo() {
        return logo;
    }
    public void setLogo(){this.logo = logo;}

    public int getPhoto() {
        return photo;
    }
    public void setPhoto(){this.photo = photo;}
}
