package edu.cascadia.orcastars.db;

import edu.cascadia.orcastars.db.entity.BusinessEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.cascadia.orcastars.R;


public class BusinessData {
    //DATA HERE

    /*private static final String[] BusName = new String[]{
            "Fishfood X",
            "The Grean Bean",
            "StarStuck",
            "Grillby's",
            "Another Sushi Place",
            "BurgerBox",
            "MTT Cafe"
    };
    private static final String[] BusDesc = new String[]{
            "Best place ever!",
            "We sell GREEN tea!",
            "Totally not stuck...",
            "Monster food makes zero waste!",
            "There are too many.",
            "We actually exist! Ooops!",
            "MTT Brand everything!"
    };
    private static final String[] BusHours = new String[]{
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
    };
    private static final Integer[] BusLogo = new Integer[]{
            R.drawable.fishfood_x,
            R.drawable.the_green_bean,
            R.drawable.starstuck,
            R.drawable.grillbys,
            R.drawable.another_sushi_place,
            R.drawable.burgerbox,
            R.drawable.mtt_cafe,
    };
    private static final Integer[] BusPhoto = new Integer[]{
            R.drawable.sushi,
            R.drawable.hobbit,
            R.drawable.hobbit,
            R.drawable.hobbit,
            R.drawable.hobbit,
            R.drawable.hobbit,
            R.drawable.hobbit,
    };


    public static List<BusinessEntity> generateBusinesses() {
        List<BusinessEntity> businesses = new ArrayList<>(BusName.length);
        for (int i = 0; i < businesses.size(); i++) {
            BusinessEntity business = new BusinessEntity(i, BusName[i], BusDesc[i], BusHours[i], BusLocation[i], BusLogo[i], BusPhoto[i]);
            businesses.add(business);
        }
        return businesses;
    };*/


//////////////////////////TEST/////////////////////////

    private static final String[] FIRST = new String[]{
            "Special edition", "New", "Cheap", "Quality", "Used"};
    private static final String[] SECOND = new String[]{
            "Three-headed Monkey", "Rubber Chicken", "Pint of Grog", "Monocle"};
    private static final String[] DESCRIPTION = new String[]{
            "is finally here", "is recommended by Stan S. Stanman",
            "is the best sold product on Mêlée Island", "is \uD83D\uDCAF", "is ❤️", "is fine"};
    private static final String[] HOURS = new String[]{
            "Comment 1", "Comment 2", "Comment 3", "Comment 4", "Comment 5", "Comment 6"};
    private static final String[] LOCATION = new String[]{
            "Comment 7", "Comment 8", "Comment 9", "Comment 10", "Comment 11", "Comment 12"};
    private static final Integer[] LOGO = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final Integer[] PHOTO = new Integer[]{11, 22, 33, 44, 55, 66, 77, 88, 99};

    public static List<BusinessEntity> generateBusinesses() {
        List<BusinessEntity> businesses = new ArrayList<>(FIRST.length * SECOND.length);
        Random rnd = new Random();
        for (int i = 0; i < FIRST.length; i++) {
            for (int j = 0; j < SECOND.length; j++) {
                BusinessEntity business = new BusinessEntity();
                business.setName(FIRST[i] + " " + SECOND[j]);
                business.setDescription(business.getName() + " " + DESCRIPTION[j]);
                business.setHours(HOURS[i]);
                business.setLocation(LOCATION[i]);
                business.setId(FIRST.length * i + j + 1);
                business.setLogo(LOGO.length * i + j + 3);
                business.setPhoto(PHOTO.length * i + j + 3);
                businesses.add(business);
            }
        }
        return businesses;
    }

}
