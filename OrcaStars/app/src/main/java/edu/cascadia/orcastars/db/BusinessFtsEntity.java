package edu.cascadia.orcastars.db;

import androidx.room.Entity;
import androidx.room.Fts4;

@Entity(tableName = "businessesFts")
@Fts4(contentEntity = BusinessEntity.class)
public class BusinessFtsEntity{
    private String name;
    private int logo;

    public BusinessFtsEntity(String name, int logo){
        this.name = name;
        this.logo = logo;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){this.name = name;}

    public int getLogo(){
        return logo;
    }

    public void setLogo(int logo){this.logo = logo;}
}
