package com.example.animalsounds.model;

/**
 * This class represents a sound (object) and its attributes.
 */
public class AnimalSound {

    private String animalSound;
    private int drawableResource;

    public AnimalSound(){}

    public AnimalSound(String animalSound, int drawableResource){
        setAnimalSound(animalSound);
        setDrawableResource(drawableResource);
    }

    public String getAnimalSound() {
        return animalSound;
    }

    public void setAnimalSound(String animalSound) {
        this.animalSound = animalSound;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }
}
