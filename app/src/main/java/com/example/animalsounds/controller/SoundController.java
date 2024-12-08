package com.example.animalsounds.controller;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.widget.ImageView;

import com.example.animalsounds.R;

import java.util.List;

/**
 * Este controlador carga los sonidos en un SoundPool y configura los listeners de cada ImageView de
 * la Activity. También cambia el sonido del fondo según el grupo de animales seleccionado
 */
public class SoundController {
    private final int SOUND_POOL_MAX_STREAMS = 12;  // Máximo número de streams que tendrá el SoundPool

    private SoundPool animalSoundPool;
    private MediaPlayer mp;
    private Context ctx;

    /**
     * Constructor para SoundController que recibe el contexto de la Activity por parámetro y lo
     * instancia. Se necesita para "cargar" los sonidos con -loadAnimalSounds()-
     *
     * @param ctx El contexto de la Activity
     */
    public SoundController(Context ctx){
        this.animalSoundPool = new SoundPool.Builder().setMaxStreams(SOUND_POOL_MAX_STREAMS).build();
        this.ctx = ctx;
        loadAnimalSounds();
    }

    /**
     * Carga en el SoundPool todos los sonidos de animales
     */
    public void loadAnimalSounds(){

        // "Grupo" de "Farm"
        animalSoundPool.load(ctx, R.raw.sound_pig, 1);
        animalSoundPool.load(ctx, R.raw.sound_rabbit, 1);
        animalSoundPool.load(ctx, R.raw.sound_chicken, 1);
        animalSoundPool.load(ctx, R.raw.sound_fox, 1);
        animalSoundPool.load(ctx, R.raw.sound_cow, 1);
        animalSoundPool.load(ctx, R.raw.sound_horse, 1);

        // "Grupo" de "Wild"
        animalSoundPool.load(ctx, R.raw.sound_crocodile, 1);
        animalSoundPool.load(ctx, R.raw.sound_elephant, 1);
        animalSoundPool.load(ctx, R.raw.sound_lion, 1);
        animalSoundPool.load(ctx, R.raw.sound_tiger, 1);
        animalSoundPool.load(ctx, R.raw.sound_snake, 1);
        animalSoundPool.load(ctx, R.raw.sound_zebra, 1);
    }

    /**
     * Establece la música de fondo según el "grupo" de animales seleccionado
     * TODO no se para la música al cambiar
     *
     * @param animalGroup El "grupo" seleccionado en la Activity
     */
    public void setBackgroundSound(String animalGroup){
        switch (animalGroup){
            case "Farm":
                mp = MediaPlayer.create(ctx, R.raw.background_sound_farm);
                mp.start();
                break;
            case "Wild":
                mp = MediaPlayer.create(ctx, R.raw.background_sound_wild);
                mp.start();
                break;
        }
    }

    /**
     * Recibe por parámetro la lista de ImageView de la Activity y el grupo de animales seleccionado.
     * En función de grupo, el método recorre la lista y asigna la posición que será utilizada
     * en el SoundPool. En cada iteración asigna el listener de cada imagen para que reproduzca
     * el sonido del animal deseado
     *
     * @param imageViewList La lista de ImageView de la Activity
     * @param animalGroup El "grupo" al que pertenece la lista
     */
    public void setAnimalSounds(List<ImageView> imageViewList, String animalGroup) {
        if(animalGroup.equals("Farm")){     // Si es "Farm" la posición coincidirá con la iteración
            for (int i = 0; i < imageViewList.size(); i++){
                int pos = i + 1;
                imageViewList.get(i).setOnClickListener(v -> playAnimalSound(pos));
            }
        } else if (animalGroup.equals("Wild")){     // Si es "Wild" la posición deberá "saltar" al comienzo del "grupo" en el SoundPool
            for (int i = 0, j = 7; i < imageViewList.size(); i++, j++){
                int pos = j;
                imageViewList.get(i).setOnClickListener(v -> playAnimalSound(pos));
            }
        }
    }

    /**
     * Reproduce el sonido del animal seleccionado según la posición que ocupa en el SoundPool
     * recibida por parámetro
     *
     * @param pos La posición del recurso en el SoundPool
     */
    public void playAnimalSound(int pos){
        animalSoundPool.play(pos, 1, 1, 1, 0, 1);
    }

}
