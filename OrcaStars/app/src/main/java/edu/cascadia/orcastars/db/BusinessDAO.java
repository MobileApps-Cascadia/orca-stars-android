package edu.cascadia.orcastars.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy;

import java.util.List;

@Dao
public interface BusinessDAO {
    @Query("SELECT * FROM businesses")
    LiveData<List<BusinessEntity>> loadAllBusinesses();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<BusinessEntity> businesses);

    @Query("SELECT * FROM businesses WHERE id = :businessId")
    LiveData<BusinessEntity> loadBusiness(int businessId);

    @Query("SELECT * FROM businesses WHERE id = :businessId")
    BusinessEntity loadBusinessSync(int businessId);

    @Query("SELECT businesses.* FROM businesses JOIN businessesFts ON (businesses.id = businessesFts.rowid) "
            + "WHERE businessesFts MATCH :query")
    LiveData<List<BusinessEntity>> searchAllBusinesses(String query);
}
