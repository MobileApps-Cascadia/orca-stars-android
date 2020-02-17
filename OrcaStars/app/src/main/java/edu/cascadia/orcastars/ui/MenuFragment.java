package edu.cascadia.orcastars.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import edu.cascadia.orcastars.NavigationHost;
import edu.cascadia.orcastars.R;


public class MenuFragment extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        ImageButton aboutButton = view.findViewById(R.id.iconinfo);
        ImageButton foodButton = view.findViewById(R.id.iconfood);
        ImageButton moreButton = view.findViewById(R.id.iconmore);

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationHost) getActivity()).navigateTo(new AboutUsFragment(), true);
            }
        });

        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationHost) getActivity()).navigateTo(new RestaurantMenuFragment(), true);
            }
        });

         moreButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 ((NavigationHost) getActivity()).navigateTo(new MoreMenuFragment(), true);
             }
         });

        return view;

    }

}