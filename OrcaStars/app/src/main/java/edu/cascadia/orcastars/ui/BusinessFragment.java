package edu.cascadia.orcastars.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cascadia.orcastars.databinding.BusinessFragmentBinding;
import edu.cascadia.orcastars.R;
import edu.cascadia.orcastars.viewmodel.BusinessViewModel;

import edu.cascadia.orcastars.R;


public class BusinessFragment extends Fragment {

    private static final String KEY_BUSINESS_ID = "business_id";

    private BusinessFragmentBinding mBinding;

    private BusinessLogoAdapter mBusinessAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate this data binding layout
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_business, container, false);

        // Create and set the adapter for the RecyclerView.
        mBusinessAdapter = new BusinessLogoAdapter(mBusinessClickCallback);
        mBinding.businessList.setAdapter(mBusinessAdapter);
        return mBinding.getRoot();
    }

    private final BusinessClickCallback mBusinessClickCallback = comment -> {
        // no-op
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        BusinessViewModel.Factory factory = new BusinessViewModel.Factory(
                requireActivity().getApplication(), requireArguments().getInt(KEY_BUSINESS_ID));

        final BusinessViewModel model = new ViewModelProvider(this, factory)
                .get(BusinessViewModel.class);

        mBinding.setLifecycleOwner(getViewLifecycleOwner());
        mBinding.setBusinessViewModel(model);

        subscribeToModel(model);
    }

    /** Creates product fragment for specific product ID */
    public static BusinessFragment forProduct(int businessId) {
        BusinessFragment fragment = new BusinessFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_BUSINESS_ID, businessId);
        fragment.setArguments(args);
        return fragment;
    }
}