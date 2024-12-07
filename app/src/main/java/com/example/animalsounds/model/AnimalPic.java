package com.example.animalsounds.model;

/**
 * This class represents an animal (object) and its attributes.
 */
public class AnimalPic {

    private String animalName;
    private int drawableResource;

    public AnimalPic(){}

    public AnimalPic(String animalName, int drawableResource){
        setAnimalName(animalName);
        setDrawableResource(drawableResource);
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }
}
