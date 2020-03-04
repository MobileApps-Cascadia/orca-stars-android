package edu.cascadia.orcastars.db;

import java.util.ArrayList;
import java.util.List;

import edu.cascadia.orcastars.R;

public class BusinessData {
    //DATA HERE

    private static final String[] BusName = new String[]{
            "Fishfood X",
            "The Green Bean",
            "StarStuck",
            "Grillbits",
            "Another Sushi Place",
            "BurgerBox",
            "Metatonic Cafe",
            "RestStop #1",
            "Verdant Drink",
            "Jora's Brunch",
            "Ty's Thai Food"
    };
    private static final String[] BusDesc = new String[]{
            "Best place ever!",
            "We sell GREEN tea!",
            "Totally not stuck...",
            "Pixelated food makes zero waste!",
            "There are too many.",
            "We actually exist! Ooops!",
            "MTT Brand!",
            "The best place for sustainable food on the go!",
            "We have many salads and teas!",
            "Enjoy our brunch!",
            "Ty Tie's Thai Treats."
    };
    private static final String[] BusHours = new String[]{
            "9am-9pm, Mon-Fri",
            "9am-9pm, Mon-Fri",
            "9am-9pm, Mon-Fri",
            "9am-9pm, Mon-Fri",
            "9am-9pm, Mon-Fri",
            "9am-9pm, Mon-Fri",
            "9am-9pm, Mon-Fri",
            "9am-9pm, Mon-Fri",
            "9am-9pm, Mon-Fri",
            "9am-9pm, Mon-Fri",
            "9am-9pm, Mon-Fri",
    };
    private static final String[] BusLocation = new String[]{
            "Google it.",
            "Google it.",
            "Google it.",
            "Google it.",
            "Google it.",
            "Google it.",
            "Google it.",
            "Google it.",
            "Google it.",
            "Google it.",
            "Google it.",
    };
    private static final Integer[] BusLogo = new Integer[]{
            R.drawable.fishfood_x,
            R.drawable.the_green_bean,
            R.drawable.starstuck,
            R.drawable.grillbys,
            R.drawable.another_sushi_place,
            R.drawable.burgerbox,
            R.drawable.mtt_cafe,
            R.drawable.orca_stars,
            R.drawable.orca_stars,
            R.drawable.orca_stars,
            R.drawable.orca_stars,
    };
    private static final Integer[] BusPhoto = new Integer[]{
            R.drawable.sushi,
            R.drawable.hobbit,
            R.drawable.hobbit,
            R.drawable.hobbit,
            R.drawable.hobbit,
            R.drawable.hobbit,
            R.drawable.hobbit,
            R.drawable.hobbit,
            R.drawable.hobbit,
            R.drawable.hobbit,
            R.drawable.hobbit,
    };


    public static List<BusinessEntity> generateBusinesses() {
        List<BusinessEntity> businesses = new ArrayList<>();
        for (int i = 0; i < BusName.length; i++) {
            BusinessEntity business = new BusinessEntity(i, BusName[i], BusDesc[i], BusHours[i], BusLocation[i], BusLogo[i], BusPhoto[i]);
            businesses.add(business);
        }
        return businesses;
    };
}
