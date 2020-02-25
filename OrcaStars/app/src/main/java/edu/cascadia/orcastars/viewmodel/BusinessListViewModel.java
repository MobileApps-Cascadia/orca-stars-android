package edu.cascadia.orcastars.viewmodel;

import android.app.Application;
import android.text.TextUtils;

import edu.cascadia.orcastars.OrcaStarsApp;
import edu.cascadia.orcastars.DataRepository;
import edu.cascadia.orcastars.db.entity.BusinessEntity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.Transformations;

public class BusinessListViewModel extends AndroidViewModel {
    private static final String QUERY_KEY = "QUERY";

    private final SavedStateHandle mSavedStateHandler;
    private final DataRepository mRepository;
    private final LiveData<List<BusinessEntity>> mBusinesses;

    public BusinessListViewModel(@NonNull Application application,
            @NonNull SavedStateHandle savedStateHandle) {
        super(application);
        mSavedStateHandler = savedStateHandle;

        mRepository = ((OrcaStarsApp) application).getRepository();

        mBusinesses = Transformations.switchMap(
                savedStateHandle.getLiveData("QUERY", null),
                (Function<CharSequence, LiveData<List<BusinessEntity>>>) query -> {
                    if (TextUtils.isEmpty(query)) {
                        return mRepository.getBusinesses();
                    }
                    return mRepository.searchBusinesses("*" + query + "*");
                });
    }

    public void setQuery (CharSequence query) {

        mSavedStateHandler.set(QUERY_KEY, query);
    }

    public LiveData<List<BusinessEntity>> getBusinesses() {
        return mBusinesses;
    }
}
