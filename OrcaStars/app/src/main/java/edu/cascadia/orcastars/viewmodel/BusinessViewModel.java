package edu.cascadia.orcastars.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import edu.cascadia.orcastars.OrcaStarsApp;
import edu.cascadia.orcastars.DataRepository;
import edu.cascadia.orcastars.db.BusinessEntity;

import java.util.List;



public class BusinessViewModel extends AndroidViewModel {

    private final LiveData<BusinessEntity> mObservableBusiness;

    private final int mBusinessId;


    public BusinessViewModel(@NonNull Application application, DataRepository repository,
                             final int businessId) {
        super(application);
        mBusinessId = businessId;
        mObservableBusiness = repository.loadBusiness(mBusinessId);
    }


    public LiveData<BusinessEntity> getBusiness() {
        return mObservableBusiness;
    }

    /**
     * A creator is used to inject the business ID into the ViewModel
     * <p>
     * This creator is to showcase how to inject dependencies into ViewModels. It's not
     * actually necessary in this case, as the business ID can be passed in a public method.
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;

        private final int mBusinessId;

        private final DataRepository mRepository;

        public Factory(@NonNull Application application, int businessId) {
            mApplication = application;
            mBusinessId = businessId;
            mRepository = ((OrcaStarsApp) application).getRepository();
        }

        @SuppressWarnings("unchecked")
        @Override
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new BusinessViewModel(mApplication, mRepository, mBusinessId);
        }
    }
}
