package com.example.recrest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonToList = (Button) findViewById(R.id.buttontolist);

        buttonToList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                toBusinessList();
            }

            private void toBusinessList() {
                Intent NextActivityboi = new Intent(getApplicationContext(),ListOfBusinesses.class);

                startActivity(NextActivityboi);

            }
        });

    }

    }
