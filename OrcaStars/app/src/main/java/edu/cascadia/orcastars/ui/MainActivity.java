package edu.cascadia.orcastars.ui;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import edu.cascadia.orcastars.NavigationHost;
import edu.cascadia.orcastars.R;
import edu.cascadia.orcastars.model.Business;


public class MainActivity extends AppCompatActivity implements NavigationHost {

    //Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            //BusinessListFragment fragment = new BusinessListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, new MenuFragment()).commit();
            //getSupportFragmentManager().beginTransaction().add(R.id.container, fragment, BusinessListFragment.TAG).commit();
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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



    /*Shows the business detail fragment*/
    /*public void show(Business business){
        BusinessFragment businessFragment = BusinessFragment.forBusiness(business.getId());
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("business")
                .replace(R.id.container, businessFragment, null)
                .commit();
    }

    /*Uncommented until other files exist, as to not cause errors*/



    /**
     * Navigate to the given fragment.
     *
     * @param fragment       Fragment to navigate to.
     * @param addToBackstack Whether or not the current fragment should be added to the backstack.
     */

    @Override
    public void navigateTo(Fragment fragment, boolean addToBackstack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment);
        if (addToBackstack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }


}