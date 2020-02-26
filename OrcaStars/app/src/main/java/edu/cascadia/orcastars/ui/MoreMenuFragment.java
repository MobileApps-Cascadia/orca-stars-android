package edu.cascadia.orcastars.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.cascadia.orcastars.R;

public class MoreMenuFragment extends Fragment {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.more_menu, container, false);

        String[] rests = new String[]{
                "Restaurants",
                "Bars & Nightlife",
                "Shopping",
                "Health & Medical",
                "Home Maintenence",
                "Professional Services",
                "Auto",
                "Hotels & Travel",
                "Pets",
                "Financial Service",
                "Mass Media",
                "Education"

        };
        Integer[] logos = new Integer[]{
                R.drawable.ic_local_dining_black_48dp,
                R.drawable.ic_local_bar_black_48dp,
                R.drawable.ic_shopping_cart_black_48dp,
                R.drawable.ic_local_hospital_black_48dp,
                R.drawable.ic_build_black_48dp,
                R.drawable.ic_card_travel_black_48dp,
                R.drawable.ic_directions_car_black_48dp,
                R.drawable.ic_flight_black_48dp,
                R.drawable.ic_pets_black_48dp,
                R.drawable.ic_attach_money_black_48dp,
                R.drawable.ic_perm_media_black_48dp,
                R.drawable.ic_school_black_48dp

        };


        BusinessMoreListAdapter myAdapter =
                new BusinessMoreListAdapter(logos, rests);


        RecyclerView myRecyclerView = (RecyclerView) view.findViewById(R.id.myRecyclerView);

        myRecyclerView.setAdapter(myAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(layoutManager);

        return view;

    }
}