package com.example.recrest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BusinessListAdapter extends RecyclerView.Adapter<BusinessListAdapter. RestaurantViewHolder> {

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantName = (TextView) itemView.findViewById(R.id.business_name);
        }

        public TextView restaurantName;
    }

    private String[] tempData;

    BusinessListAdapter(String[] stringInput){
        tempData = stringInput;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View LayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.business_list_item, parent, false);
        return new RestaurantViewHolder(LayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        holder.restaurantName.setText(tempData[position]);
    }

    @Override
    public int getItemCount() {
        return tempData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;

        public ViewHolder(View v){
            super(v);

            nameTextView = (TextView) v.findViewById(R.id.business_name);
        }
    }
}
