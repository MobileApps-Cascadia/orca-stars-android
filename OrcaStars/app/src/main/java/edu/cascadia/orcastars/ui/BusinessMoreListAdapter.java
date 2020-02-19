package edu.cascadia.orcastars.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.cascadia.orcastars.NavigationHost;
import edu.cascadia.orcastars.R;

public class BusinessMoreListAdapter extends RecyclerView.Adapter<BusinessMoreListAdapter.RestaurantViewHolder>{
    public class RestaurantViewHolder extends RecyclerView.ViewHolder {

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantLogo = (ImageView) itemView.findViewById(R.id.business_logo);
            restaurantName = (TextView) itemView.findViewById(R.id.business_name);
        }

        public ImageView restaurantLogo;
        public TextView restaurantName;
    }

    private Integer[] tempDataLogo;
    private String[] tempDataName;

    BusinessMoreListAdapter(Integer[] intInput, String[] stringInput){
        tempDataLogo = intInput;
        tempDataName = stringInput;
    }

    @NonNull
    @Override
    public BusinessMoreListAdapter.RestaurantViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View LayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.business_list_item, parent, false);

        final RestaurantViewHolder holdViewOfBusinessListItem = new BusinessMoreListAdapter.RestaurantViewHolder(LayoutView);
        Button goToBusiness = LayoutView.findViewById(R.id.SelectedItem);
        goToBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexOfClickedItem = holdViewOfBusinessListItem.getAdapterPosition();
                switch(indexOfClickedItem){
                    case 1:
                        ((NavigationHost) parent.getContext()).navigateTo(new BusinessFragment(), true);
                }

            }
        });

        return holdViewOfBusinessListItem;
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessMoreListAdapter.RestaurantViewHolder holder, int position) {
        holder.restaurantLogo.setImageResource(tempDataLogo[position]);
        holder.restaurantName.setText(tempDataName[position]);
    }

    @Override
    public int getItemCount() {
        return tempDataName.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView nameImageView;
        public TextView nameTextView;

        public ViewHolder(View v){
            super(v);

            nameImageView = (ImageView) v.findViewById(R.id.business_logo);
            nameTextView = (TextView) v.findViewById(R.id.business_name);
        }
    }
}

