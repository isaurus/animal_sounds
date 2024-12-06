package com.example.animalsounds.view;

import android.content.Context;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animalsounds.R;
import com.example.animalsounds.controller.ImageController;

import java.util.ArrayList;
import java.util.List;

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

    public void initComponents(){
        List<ImageView> animalPicsList = new ArrayList<>();
        animalPicsList.add(findViewById(R.id.imgPig));
        animalPicsList.add(findViewById(R.id.imgRabbit));
        animalPicsList.add(findViewById(R.id.imgChicken));
        animalPicsList.add(findViewById(R.id.imgFox));
        animalPicsList.add(findViewById(R.id.imgCow));
        animalPicsList.add(findViewById(R.id.imgHorse));

        List<SoundPool> animalSoundsList = new ArrayList<>();
        animalSoundsList.add(R.raw.pig);
        animalSoundsList.add(R.raw.rabbit);
        animalSoundsList.add(R.raw.chicken);
        animalSoundsList.add(R.raw.fox);
        animalSoundsList.add(R.raw.cox);
        animalSoundsList.add(R.raw.horse);

        //Context ctx = getApplicationContext();
        ImageController imgController = new ImageController();
        imgController.bindListToXML(animalPicsList);
    }
}