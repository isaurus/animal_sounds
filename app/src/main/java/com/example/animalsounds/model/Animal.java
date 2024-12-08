package com.example.animalsounds.model;

/**
 * Esta clase representa un animal y su imagen. Declara dos atributos para su nombre (String) y su
 * recurso asociado (int), y son recibidos por el constructor para setearlos a través de sus métodos
 * set. Los métodos get sirven para que el controlador asociado pueda acceder a sus atributos.
 */
public class Animal {

    private int drawablePicResource;
    private int drawableSoundResource;

    public Animal(){}

    public Animal(int drawablePicResource, int drawableSoundResource){
        setDrawablePicResource(drawablePicResource);
        setDrawableSoundResource(drawableSoundResource);
    }


    public int getDrawablePicResource() {
        return drawablePicResource;
    }

    public void setDrawablePicResource(int drawablePicResource) {
        this.drawablePicResource = drawablePicResource;
    }

    public int getDrawableSoundResource(){
        return drawableSoundResource;
    }

    public void setDrawableSoundResource(int drawableSoundResource){
        this.drawableSoundResource = drawableSoundResource;
    }

}
