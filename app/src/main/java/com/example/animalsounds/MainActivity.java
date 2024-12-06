package com.example.animalsounds;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.materialToolbar));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String selectedItem = String.valueOf(item.getTitle());
        switch (selectedItem){
            case "Domestic":
                // TODO change background and animals pics to "Domestic"
                break;
            case "Wild":
                // TODO change background and animals pics to "Wild"
                break;
            case "Birds":
                // TODO change background and animals pics to "Birds"
                break;
            case "Logout":
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}