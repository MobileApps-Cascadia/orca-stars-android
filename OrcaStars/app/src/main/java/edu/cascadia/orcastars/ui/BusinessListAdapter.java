package edu.cascadia.orcastars.ui;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import javax.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import edu.cascadia.orcastars.databinding.BusinessItemBinding;
import edu.cascadia.orcastars.model.Business;
import edu.cascadia.orcastars.R;

import java.util.List;

public class BusinessListAdapter extends RecyclerView.Adapter<BusinessListAdapter.BusinessViewHolder>{

    List<? extends Business> mBusinessList;

    @Nullable
    private final BusinessClickCallback mBusinessClickCallback;

    public BusinessListAdapter(@Nullable BusinessClickCallback clickCallback) {
        mBusinessClickCallback = clickCallback;
        setHasStableIds(true);
    }

    public void setBusinessList(final List<? extends Business> businessList) {
        if (mBusinessList == null) {
            mBusinessList = businessList;
            notifyItemRangeInserted(0, businessList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize(){
                    return mBusinessList.size();
                }

                @Override
                public int getNewListSize(){
                    return businessList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition){
                    return mBusinessList.get(oldItemPosition).getId() ==
                            businessList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition){
                    Business newBusiness = businessList.get(newItemPosition);
                    Business oldBusiness = mBusinessList.get(oldItemPosition);
                    return newBusiness.getId() == oldBusiness.getId()
                            && TextUtils.equals(newBusiness.getDescription(), oldBusiness.getDescription())
                            && TextUtils.equals(newBusiness.getName(), oldBusiness.getName())
                            /*&& newBusiness.getLogo() == oldBusiness.getLogo()*/;
                }
            });
            mBusinessList = businessList;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    @NonNull
    public BusinessViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        BusinessItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.business_item,
                        parent, false);
        binding.setCallback(mBusinessClickCallback);
        return new BusinessViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessViewHolder holder, int position){
        holder.binding.setBusiness(mBusinessList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount(){ return mBusinessList == null ? 0 : mBusinessList.size(); }

    @Override
    public long getItemId(int position){ return mBusinessList.get(position).getId(); }

    static class BusinessViewHolder extends RecyclerView.ViewHolder{

        final BusinessItemBinding binding;

        public BusinessViewHolder(BusinessItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

