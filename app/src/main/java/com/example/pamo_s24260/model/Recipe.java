package com.example.pamo_s24260.model;

import androidx.annotation.NonNull;

public class Recipe {
    private final String name;
    private final String description;
    private final int calories;
    private final String author;

    public Recipe(String name, String description, int calories, String author) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public String getAuthor() {
        return author;
    }

    @NonNull
    @Override
    public String toString() {
        return name + " (" + calories + " kcal) - " + description + " | Autor: " + author;
    }
}

