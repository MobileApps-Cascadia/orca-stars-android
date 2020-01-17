package edu.cascadia.orcastars;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class BusinessLogoAdapter extends RecyclerView.Adapter<BusinessLogoAdapter.RestaurantViewHolder>{
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

    BusinessLogoAdapter(Integer[] intInput, String[] stringInput){
        tempDataLogo = intInput;
        tempDataName = stringInput;
    }

    @NonNull
    @Override
    public BusinessLogoAdapter.RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View LayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.business_list_item, parent, false);
        return new BusinessLogoAdapter.RestaurantViewHolder(LayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessLogoAdapter.RestaurantViewHolder holder, int position) {
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

