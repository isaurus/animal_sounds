package com.example.animalsounds.controller;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.animalsounds.R;
import com.example.animalsounds.model.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase es el controlador de "Animal" y sirve para cargar las imágenes en una lista de tipo
 * Animal que se inicia en el constructor. Su método ***** se encarga de recibir por parámetro
 * la lista de los objetos acoplados al xml desde la activity y utiliza Glide para redondearlas y
 * setearlas en la activity.
 */
public class ImageController {

    // Lista que contiene el nombre y el recurso de imagen asociado de los animales de la activity
    private List<Animal> animalList;

    Context ctx;

    /**
     * Inicializa la lista y carga los datos en la misma
     */
    public ImageController(){
        this.animalList = new ArrayList<>();
        loadAnimalList();
    }

    /**
     * Carga los objetos Animal en la lista junto con su imagen y sonido asociados
     */
    public void loadAnimalList(){
        animalList.add(new Animal(R.drawable.ic_pig, R.raw.sound_pig));
        animalList.add(new Animal(R.drawable.ic_rabbit, R.raw.sound_rabbit));
        animalList.add(new Animal(R.drawable.ic_chicken, R.raw.sound_chicken));
        animalList.add(new Animal(R.drawable.ic_fox, R.raw.sound_fox));
        animalList.add(new Animal(R.drawable.ic_cow, R.raw.sound_cow));
        animalList.add(new Animal(R.drawable.ic_horse, R.raw.sound_horse));

        animalList.add(new Animal(R.drawable.ic_crocodile, R.raw.sound_crocodile));
        animalList.add(new Animal(R.drawable.ic_elephant, R.raw.sound_elephant));
        animalList.add(new Animal(R.drawable.ic_tiger, R.raw.sound_tiger));
        animalList.add(new Animal(R.drawable.ic_lion, R.raw.sound_lion));
        animalList.add(new Animal(R.drawable.ic_snake, R.raw.sound_snake));
        animalList.add(new Animal(R.drawable.ic_zebra, R.raw.sound_zebra));
    }

    /**
     * Recibe una lista de objetos ImageView de la Activity y las recorre en un bucle para
     * "cropearlas" en forma de círculos y "setearlas" en la Activity según se haya seleccionado
     * en el menú un grupo u otro
     *
     * TODO mejorar método
     *
     * @param imageViewList La lista de ImageView recibida desde la Activity
     * @param animalGroup El grupo de animales seleccionado
     */
    public void glideCropAndSet(List<ImageView> imageViewList, String animalGroup) {
        int beginIndex = 0;
        int endIndex = 0;

        switch (animalGroup) {
            case "Farm":
                beginIndex = 0;
                endIndex = 5;
                break;
            case "Wild":
                beginIndex = 6;
                endIndex = 11;
                break;
        }
        for (int i = 0; i < imageViewList.size() && (beginIndex + i) <= endIndex; i++) {
            Animal animal = animalList.get(beginIndex + i); // Selecciona el animal correcto
            imageViewList.get(i).setImageResource(animal.getDrawablePicResource());
            Glide.with(imageViewList.get(i).getContext())
                    .load(animal.getDrawablePicResource())
                    .circleCrop()
                    .into(imageViewList.get(i));
        }
    }

    /**
     * Setea la imagen de fondo en el contexto de la Activity según el "grupo" de animales seleccionado.
     *
     * @param ctx El contexto de la Activity
     * @param animalGroup El "grupo" de animales seleccionado
     * @param imageView La imagen que se utiliza de fondo
     */
    public void setBackGroundImage(Context ctx, String animalGroup, ImageView imageView){
        if (animalGroup.equals("Farm")){
            Glide.with(imageView)
                    .load(R.drawable.background_farm)
                    .into(imageView);
        } else if (animalGroup.equals("Wild")){
            Glide.with(imageView)
                    .load(R.drawable.background_wild)
                    .into(imageView);
        }
    }
}

