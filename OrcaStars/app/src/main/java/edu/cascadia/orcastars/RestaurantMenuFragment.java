package edu.cascadia.orcastars;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.button.MaterialButton;

public class RestaurantMenuFragment extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurant_menu, container, false);

        String[] rests = new String[]{
                "FishFood X",
                "The Green Bean",
                "Starstuck",
                "Grillby's",
                "Another Sushi Place",
                "Burgerbox",
                "MTT Café",
        };
        Integer[] logos = new Integer[]{
                R.drawable.fishfood_x,
                R.drawable.the_green_bean,
                R.drawable.starstuck,
                R.drawable.grillbys,
                R.drawable.another_sushi_place,
                R.drawable.burgerbox,
                R.drawable.mtt_cafe
        };


        BusinessLogoAdapter myAdapter =
                new BusinessLogoAdapter(logos, rests);


        RecyclerView myRecyclerView = (RecyclerView) view.findViewById(R.id.myRecyclerView);

        myRecyclerView.setAdapter(myAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(layoutManager);




        return view;

    }
}