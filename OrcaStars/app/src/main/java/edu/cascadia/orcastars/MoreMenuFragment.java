package edu.cascadia.orcastars;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
                "Food",
                "Health & Medical",
                "Home Maintence",
                "Professional Services",
                "Auto"
                
        };
        Integer[] logos = new Integer[]{
                R.drawable.orca_stars48,
                R.drawable.orca_stars48,
                R.drawable.orca_stars48,
                R.drawable.orca_stars48,
                R.drawable.orca_stars48,
                R.drawable.orca_stars48,
                R.drawable.orca_stars48,
                R.drawable.orca_stars48
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