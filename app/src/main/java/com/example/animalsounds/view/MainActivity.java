package com.example.animalsounds.view;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animalsounds.R;
import com.example.animalsounds.controller.ImageController;
import com.example.animalsounds.controller.SoundController;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageController imgController;
    private SoundController sndController;
    private Context ctx;
    private List<ImageView> animalPicsList;
    private ImageView imgBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.materialToolbar));

        initComponents();

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
                // TODO
                break;
            case "Wild":
                imgController.setBackGroundImage(ctx, selectedItem, imgBackground);
                imgController.glideCropAndSet(animalPicsList, selectedItem);
                sndController.setBackgroundSound("Wild");
                sndController.setAnimalSounds(animalPicsList, "Wild");
                break;
            case "Birds":
                // TODO
                break;
            case "Farm":
                imgController.setBackGroundImage(ctx, selectedItem, imgBackground);
                imgController.glideCropAndSet(animalPicsList,selectedItem);
                sndController.setBackgroundSound("Farm");
                sndController.setAnimalSounds(animalPicsList, "Farm");
                break;
            case "Logout":
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void initComponents(){

        imgBackground = findViewById(R.id.imgBackground);

        imgController = new ImageController();

        animalPicsList = new ArrayList<>();

        // Añadir los 6 ImageView a lista
        animalPicsList.add(findViewById(R.id.imgOne));
        animalPicsList.add(findViewById(R.id.imgTwo));
        animalPicsList.add(findViewById(R.id.imgThree));
        animalPicsList.add(findViewById(R.id.imgFour));
        animalPicsList.add(findViewById(R.id.imgFive));
        animalPicsList.add(findViewById(R.id.imgSix));

        imgController.glideCropAndSet(animalPicsList, "Farm");

        ctx = getApplicationContext();
        sndController = new SoundController(ctx);

        sndController.setBackgroundSound("Farm");
        sndController.setAnimalSounds(animalPicsList, "Farm");

    }
}