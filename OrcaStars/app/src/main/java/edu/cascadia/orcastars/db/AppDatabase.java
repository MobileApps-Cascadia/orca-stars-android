package edu.cascadia.orcastars.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;

import edu.cascadia.orcastars.AppExecutors;

@Database(entities = {BusinessEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase sInstance;
    @VisibleForTesting
    public static final String DATABASE_NAME = "orcastars-db";
    public abstract BusinessDAO businessDAO();
    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors){
        if (sInstance == null){
            synchronized (AppDatabase.class){
                if (sInstance == null){
                    sInstance = buildDatabase(context.getApplicationContext(), executors);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private static AppDatabase buildDatabase(final Context appContext,
                                             final AppExecutors executors){
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback(){
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db){
                        super.onCreate(db);
                        executors.getmDiskIO().execute(() -> {
                            //add delay to simulate loading data
                            addDelay();
                            //Generate data for pre-population
                            AppDatabase database = AppDatabase.getInstance(appContext, executors);
                            List<BusinessEntity> businesses = BusinessData.generateBusinesses();
                            insertData(database, businesses);
                            database.setDatabaseCreated();
                        });
                    }
                })
                .build();

    }

    /*Check whether the database already exists*/
    private void updateDatabaseCreated(final Context context){
        if (context.getDatabasePath(DATABASE_NAME).exists()){
            setDatabaseCreated();
        }
    }
    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    private static void insertData(final AppDatabase database,
                                   final List<BusinessEntity> businesses){
        database.runInTransaction(() -> {
            database.businessDAO().insertAll(businesses);
        });
    }

    private static void addDelay(){
        try{
            Thread.sleep(4000);
        } catch (InterruptedException ignored){
    }
}

public LiveData<Boolean> getDatabaseCreated(){
        return mIsDatabaseCreated;
}
}




