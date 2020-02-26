package edu.cascadia.orcastars.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.cascadia.orcastars.R;
import edu.cascadia.orcastars.databinding.BusinessFragmentBinding;
import edu.cascadia.orcastars.viewmodel.BusinessViewModel;


public class BusinessFragment extends Fragment {

    private static final String KEY_BUSINESS_ID = "business_id";

    private BusinessFragmentBinding mBinding;

    private BusinessListAdapter mBusinessAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate this data binding layout
        mBinding = DataBindingUtil.inflate(inflater, R.layout.business_fragment, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        BusinessViewModel.Factory factory = new BusinessViewModel.Factory(
                requireActivity().getApplication(), requireArguments().getInt(KEY_BUSINESS_ID));

        final BusinessViewModel model = new ViewModelProvider(this, factory)
                .get(BusinessViewModel.class);

        mBinding.setBusinessViewModel(model);

        subscribeToModel(model);
    }

    private void subscribeToModel(final BusinessViewModel model) {

        // Observe business data
        model.getObservableBusiness().observe(getViewLifecycleOwner(), model::setBusiness);

    }

    @Override
    public void onDestroyView() {
        mBinding = null;
        super.onDestroyView();
    }

    /** Creates product fragment for specific business ID */
    public static BusinessFragment forBusiness(int businessId) {
        BusinessFragment fragment = new BusinessFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_BUSINESS_ID, businessId);
        fragment.setArguments(args);
        return fragment;
    }
}