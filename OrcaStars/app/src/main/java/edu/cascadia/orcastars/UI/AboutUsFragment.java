package edu.cascadia.orcastars.UI;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cascadia.orcastars.BuildConfig;
import edu.cascadia.orcastars.R;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {


    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View myView = inflater.inflate(R.layout.fragment_about_us, container, false);

        Element adsElement = new Element();
        adsElement.setTitle("Advertise with us");

        AboutPage aboutPage = new AboutPage(getContext())
                .isRTL(false)
                .setImage(R.drawable.orcastarsaboutuslogo)
                .setDescription(getString(R.string.description))
                .addItem(new Element("Version " + BuildConfig.VERSION_NAME, R.drawable.ic_info_black_48dp))
                .addGroup("Connect with us")
                .addEmail("orcaconservancy@gmail.com")
                .addWebsite(getString(R.string.FRONTEND_HOST))
                .addFacebook(getString(R.string.FACEBOOK_ID))
                .addTwitter(getString(R.string.TWITTER_ID))
                .addInstagram(getString(R.string.INSTAGRAM_ID))
                .addYoutube("UC4q-CpaiV1KrPCSUpQYXfdg");

        View aboutPageView = aboutPage.create();
        return aboutPageView;
        }

    }

