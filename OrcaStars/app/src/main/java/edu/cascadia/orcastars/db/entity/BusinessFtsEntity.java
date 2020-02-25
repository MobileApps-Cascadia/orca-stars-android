package edu.cascadia.orcastars.db.entity;

import androidx.room.Entity;
import androidx.room.Fts4;

import edu.cascadia.orcastars.db.entity.BusinessEntity;

@Entity(tableName = "businessesFts")
@Fts4(contentEntity = BusinessEntity.class)
public class BusinessFtsEntity{
    private String name;
    private String description;

    public BusinessFtsEntity(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void setName(String name){ this.name = name; }

    public String getName(){ return name; }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){ this.description = description; }
}
