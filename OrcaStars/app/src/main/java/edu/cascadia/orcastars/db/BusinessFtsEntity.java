package edu.cascadia.orcastars.db;

import androidx.room.Entity;
import androidx.room.Fts4;

@Entity(tableName = "businessesFts")
@Fts4(contentEntity = BusinessEntity.class)
public class BusinessFtsEntity{
    private String name;
    private int logo;

    public BusinessFtsEntity(String name, int photo){
        this.name = name;
        this.logo = logo;
    }

    public String getName(){
        return name;
    }

    public int getLogo(){
        return logo;
    }
}
