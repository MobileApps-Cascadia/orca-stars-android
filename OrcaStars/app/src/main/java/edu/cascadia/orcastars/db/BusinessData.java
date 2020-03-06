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
            "Fishfood X is dedicated to supporting sustainable fishing, and giving back by donating to the Orca Conservancy. All ingredients are 100% organic and ethically sourced.",
            "The Green Bean is a tea and coffee shop that supports sustainable practices. Every item we provide is biodegradable or recyclable. No more water pollution!",
            "StarStuck supports sustainable business and donates to non-profit organizations that help to clean out the water of plastic.",
            "We here at Grillbits are determined to keep our environment and our orcas safe! All of our ingredients are also from sustainable farmers.",
            "All of our fish are sourced only from sustainable fisheries, to keep the orcas fed and happy.",
            "25% of all proceeds go to the Orca Conservancy, and other sustainable businesses that are working hard to protect our orcas.",
            "Metatonic is determined to keep our orcas around! Everything is recyclable and reusable! No more plastic pollution!",
            "RestStop #1 is the #1 place for sustainable food on the go! We also pride ourselves in using only reusable, recyclable, and completely biodegradable tableware!",
            "We have many salads and teas! All of our veggies come from sustainable and zero-pollutions farms and orchards! Our salads are protecting the environment!",
            "Jora's Brunch is proud of supplying only from local and sustainable businesses, and donating to the Orca Conservancy and their cause!",
            "Ty Tie's Thai food is sustainable, cruelty-free, 100% organic, zero-waste, and biodegradable! We are proud protectors of our orca friends!"
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
            "Bothell, WA",
            "Bothell, WA",
            "Bothell, WA",
            "Bothell, WA",
            "Bothell, WA",
            "Bothell, WA",
            "Bothell, WA",
            "Bothell, WA",
            "Bothell, WA",
            "Bothell, WA",
            "Bothell, WA",
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
