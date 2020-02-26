package edu.cascadia.orcastars.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.cascadia.orcastars.R;
import edu.cascadia.orcastars.model.Business;

public class BusinessListDisplayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null){
            BusinessListFragment fragment = new BusinessListFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment,BusinessListFragment.TAG)
                    .commit();
        }
    }

    public void show(Business business) {

        BusinessFragment businessFragment = BusinessFragment.forBusiness(business.getId());

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("business")
                .replace(R.id.fragment_container,
                        businessFragment, null).commit();
    }
}
