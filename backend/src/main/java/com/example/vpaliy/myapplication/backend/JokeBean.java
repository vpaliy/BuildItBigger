package com.example.vpaliy.myapplication.backend;

public class JokeBean {

    private String joke;

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }

    @Override
    public String toString() {
        return joke;
    }
}
