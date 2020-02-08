package edu.cascadia.orcastars;

import android.app.Application;

import edu.cascadia.orcastars.DB.AppDatabase;

public class OrcaStarsApp extends Application {
    private AppExecutors mAppExecutors;
    /*@Override*/
    /*Uncommented for now, because AppExecutors does not actually
    have an onCreate to override*/
    public void OnCreate(){
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
