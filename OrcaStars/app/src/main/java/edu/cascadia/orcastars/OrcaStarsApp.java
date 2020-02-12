package edu.cascadia.orcastars;

import android.app.Application;

import edu.cascadia.orcastars.DB.AppDatabase;

public class OrcaStarsApp extends Application {
    private AppExecutors mAppExecutors;
    @Override
    public void onCreate(){
        super.onCreate();
        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase(){
        return AppDatabase.getInstance(this, mAppExecutors);
    }

    public DataRepository getRepository(){
        return DataRepository.getInstance(getDatabase());
    }
}
