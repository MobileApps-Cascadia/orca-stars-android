package edu.cascadia.orcastars;

import java.util.List;

import afu.org.checkerframework.checker.igj.qual.I;
import edu.cascadia.orcastars.db.AppDatabase;
import edu.cascadia.orcastars.db.BusinessEntity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

public class DataRepository {

    private static DataRepository sInstance;

    private final AppDatabase mDatabase;
    private MediatorLiveData<List<BusinessEntity>> mObservableBusinesses;

    private DataRepository(final AppDatabase database){
        mDatabase = database;
        mObservableBusinesses = new MediatorLiveData<>();

        mObservableBusinesses.addSource(mDatabase.businessDAO().loadAllBusinesses(),
                businessEntities -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null){
                        mObservableBusinesses.postValue(businessEntities);
                    }
                });
    }

    public static DataRepository getInstance(final AppDatabase database){
        if (sInstance == null){
            synchronized (DataRepository.class){
                if (sInstance == null){
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    /*get the list of businesses from the database and get notified when the data changes*/
    public LiveData<List<BusinessEntity>> getBusinesses(){
        return mObservableBusinesses;
    }
    public LiveData<BusinessEntity> loadBusiness(final int businessId){
        return mDatabase.businessDAO().loadBusiness(businessId);
    }

    }

