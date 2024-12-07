package com.example.animalsounds.controller;

import android.widget.ImageView;

import com.example.animalsounds.R;
import com.example.animalsounds.model.AnimalPic;

import java.util.ArrayList;
import java.util.List;

/**
 * El controlador se va a encargar de acoplar las imágenes de los animales al XML y darles la forma
 * redondeada con Glide. Para ello realizará lo siguiente:
 *  - Crear una List de objetos tipo AnimalPic para almacenar los diferentes animales.
 *  - Asociar
 *  - Añadir a la List las imágenes de los animales
 */

/**
 * Creates and shapes images needed for the app. Both animals and backgrounds are managed with
 * this controller. Glide is used in order to shape images as circles
 */
public class ImageController {

    private List<AnimalPic> animalPicsList;

    public ImageController(){
        this.animalPicsList = new ArrayList<>();
    }

    public List<AnimalPic> getAllPics(){
        return this.animalPicsList;
    }

    public AnimalPic getDrawableResource(int pos){
        for(AnimalPic animalPic : animalPicsList){

        }
    }



    public void addPicsToList(AnimalPic animalPic){
        animalPicsList.add(animalPic);
    }

    public void loadSoundData(){
        animalPicsList.add(new AnimalPic(String.valueOf(R.string.name_pig), R.drawable.ic_pig));
        animalPicsList.add(new AnimalPic(String.valueOf(R.string.name_rabbit), R.drawable.ic_rabbit));
        animalPicsList.add(new AnimalPic(String.valueOf(R.string.name_chicken), R.drawable.ic_chicken));
        animalPicsList.add(new AnimalPic(String.valueOf(R.string.name_fox), R.drawable.ic_fox));
        animalPicsList.add(new AnimalPic(String.valueOf(R.string.name_cow), R.drawable.ic_cow));
        animalPicsList.add(new AnimalPic(String.valueOf(R.string.name_horse), R.drawable.ic_horse));
    }

    public void bindListToXML(List<ImageView> imageViewList){

        for(int i = 1; i<animalPicsList.size(); i++){
            imageViewList.get(i).setImageResource(getDrawableResource(i));
        }
    }

}
