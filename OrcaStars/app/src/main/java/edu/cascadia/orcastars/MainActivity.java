package edu.cascadia.orcastars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.orca_stars48);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("OrcaStars");
        toolbar.setSubtitle("by Orca Conservancy");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String msg=" ";
        switch (item.getItemId()){
            case R.id.search:
                msg = "Search";
                break;
            case R.id.about:
                msg = "About";
                break;
            case R.id.settings:
                msg = "Settings";
                break;
        }
        Toast.makeText(this,msg+ " Checked", Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
}
