package edu.cascadia.orcastars.ui;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import edu.cascadia.orcastars.R;
import edu.cascadia.orcastars.databinding.BusinessListFragmentBinding;
import edu.cascadia.orcastars.db.BusinessEntity;
import edu.cascadia.orcastars.viewmodel.BusinessListViewModel;

import java.util.List;

public class BusinessListFragment extends Fragment {

    public static final String TAG = "BusinessLIstFragment";

    private BusinessListAdapter mBusinessAdapter;

    private BusinessListFragmentBinding mBinding;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.business_list_fragment, container, false);

        mBusinessAdapter = new BusinessListAdapter(mBusinessClickCallback);
        mBinding.businessesList.setAdapter(mBusinessAdapter);

        return mBinding.getRoot();
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState/*, @NonNull SavedStateHandle savedStateHandle*/) {
        super.onViewCreated(view, savedInstanceState);
        final BusinessListViewModel viewModel =
                new ViewModelProvider(this)
                        .get(BusinessListViewModel.class);

        mBinding.businessesSearchBtn.setOnClickListener(v -> {
            Editable query = mBinding.businessesSearchBox.getText();
            viewModel.setQuery(query);
        });

        subscribeUI(viewModel.getBusinesses());
    }

    private void subscribeUI(LiveData<List<BusinessEntity>>liveData){
        liveData.observe(getViewLifecycleOwner(), myBusinesses ->{
            if (myBusinesses != null){
                mBinding.setIsLoading(false);
                mBusinessAdapter.setBusinessList(myBusinesses);
            } else {
                mBinding.setIsLoading(true);
            }
            mBinding.executePendingBindings();
        });
    }

    @Override
    public void onDestroyView() {
        mBinding = null;
        mBusinessAdapter = null;
        super.onDestroyView();
    }

    private final BusinessClickCallback mBusinessClickCallback = business -> {
      if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
          ((BusinessListDisplayActivity) requireActivity()).show(business);
      }
    };
}