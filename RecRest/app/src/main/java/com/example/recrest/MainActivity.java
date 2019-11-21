package com.example.recrest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_recyclerview);

        String[] rests = new String[]{"The Green Bean", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE", "Starbucks", "Washington Coffee Shop", "Sushi and Coffee Cafe",
                "Hamachi and a Latte", "LATRINE"};

        BusinessListAdapter myAdapter =
                new BusinessListAdapter(rests);


        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);

        myRecyclerView.setAdapter(myAdapter);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    }
