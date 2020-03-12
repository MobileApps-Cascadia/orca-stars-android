package edu.cascadia.orcastars.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import edu.cascadia.orcastars.BuildConfig;
import edu.cascadia.orcastars.NavigationHost;
import edu.cascadia.orcastars.R;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);

        ImageButton homeButton = view.findViewById(R.id.iconhome);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationHost) getActivity()).navigateTo(new MenuFragment(), true);
            }
        });

        TextView email = view.findViewById(R.id.emailText);
        email.setMovementMethod(LinkMovementMethod.getInstance());
        email.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse("mailto:orcaconservancy@gmail.com"));
            startActivity(browserIntent);
        });

        TextView web = view.findViewById(R.id.webText);
        web.setMovementMethod(LinkMovementMethod.getInstance());
        web.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse("https://www.orcaconservancy.org/5-2/orca-stars/"));
            startActivity(browserIntent);
        });

        TextView fb = view.findViewById(R.id.fbText);
        fb.setMovementMethod(LinkMovementMethod.getInstance());
        fb.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse("https://www.facebook.com/OrcaConservancy/"));
            startActivity(browserIntent);
        });

        TextView twitter = view.findViewById(R.id.twitterText);
        twitter.setMovementMethod(LinkMovementMethod.getInstance());
        twitter.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse("https://twitter.com/OrcaConservancy"));
            startActivity(browserIntent);
        });

        TextView insta = view.findViewById(R.id.instaText);
        insta.setMovementMethod(LinkMovementMethod.getInstance());
        insta.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse("https://www.instagram.com/orcaconservancy/"));
            startActivity(browserIntent);
        });

        TextView yt = view.findViewById(R.id.ytText);
        yt.setMovementMethod(LinkMovementMethod.getInstance());
        yt.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse("https://www.youtube.com/channel/UC4q-CpaiV1KrPCSUpQYXfdg"));
            startActivity(browserIntent);
        });

        return view;

    }
}

