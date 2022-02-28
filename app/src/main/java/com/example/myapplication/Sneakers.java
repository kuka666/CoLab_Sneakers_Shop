package com.example.myapplication;

public class Sneakers {

    private String name ;
    private String Description;
    private String rating;
    private int nb_episode;
    private String price;
    private String studio ;
    private String image_url;

    public Sneakers() {
    }

    public Sneakers(String name, String description, String rating, int nb_episode, String price, String studio, String image_url) {
        this.name = name;
        Description = description;
        this.rating = rating;
        this.nb_episode = nb_episode;
        this.price = price;
        this.studio = studio;
        this.image_url = image_url;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public String getRating() {
        return rating;
    }

    public int getNb_episode() {
        return nb_episode;
    }

    public String getPrice() {
        return price;
    }

    public String getStudio() {
        return studio;
    }

    public String getImage_url() {
        return image_url;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setNb_episode(int nb_episode) {
        this.nb_episode = nb_episode;
    }

    public void setPrice(String categorie) {
        this.price = categorie;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
