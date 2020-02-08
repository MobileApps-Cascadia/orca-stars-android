package edu.cascadia.orcastars;

import java.util.ArrayList;
import java.util.List;

import afu.org.checkerframework.checker.igj.qual.I;
import edu.cascadia.orcastars.DB.AppDatabase;
import edu.cascadia.orcastars.DB.BusinessEntity;

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

    //DATA HERE

        private static final String[] BusName = new String[]{
                "Fishfood X",
                "The Grean Bean",
                "StarStuck",
                "Grillby's",
                "Another Sushi Place",
                "BurgerBox",
                "MTT Cafe"
        };
        private static final String[] BusDesc = new String[]{
                "Best place ever!",
                "We sell GREEN tea!",
                "Totally not stuck...",
                "Monster food makes zero waste!",
                "There are too many.",
                "We actually exist! Ooops!",
                "MTT Brand everything!"
        };
        private static final String[] BusHours = new String[]{
                "9am-9pm, Mon-Fri",
                "9am-9pm, Mon-Fri",
                "9am-9pm, Mon-Fri",
                "9am-9pm, Mon-Fri",
                "9am-9pm, Mon-Fri",
                "9am-9pm, Mon-Fri",
                "9am-9pm, Mon-Fri",
        };
        private static final String[] BusLocation = new String[]{
                "Google it.",
                "Google it.",
                "Google it.",
                "Google it.",
                "Google it.",
                "Google it.",
                "Google it.",
        };
        private static final Integer[] BusLogo = new Integer[]{
                R.drawable.fishfood_x,
                R.drawable.the_green_bean,
                R.drawable.starstuck,
                R.drawable.grillbys,
                R.drawable.another_sushi_place,
                R.drawable.burgerbox,
                R.drawable.mtt_cafe,
        };
        private static final Integer[] BusPhoto = new Integer[]{
                R.drawable.sushi,
                R.drawable.hobbit,
                R.drawable.hobbit,
                R.drawable.hobbit,
                R.drawable.hobbit,
                R.drawable.hobbit,
                R.drawable.hobbit,
        };


        public static List<BusinessEntity> generateBusinesses() {
            List<BusinessEntity> businesses = new ArrayList<>(7);
            for (int i = 0; i < businesses.size(); i++) {
                BusinessEntity business = new BusinessEntity(i, BusName[i], BusDesc[i], BusHours[i], BusLocation[i], BusLogo[i], BusPhoto[i]);
                businesses.add(business);
            }
            return businesses;
        };
    }

