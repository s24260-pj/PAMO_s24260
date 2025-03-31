package com.example.pamo_s24260.services.Resolver;

import com.example.pamo_s24260.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeByCaloriesResolver {
    public List<Recipe> resolve(float kcal) {
        List<Recipe> recipes = new ArrayList<>();

        if (kcal < 1800) {
            recipes.add(new Recipe(
                    "Owsianka z jabłkiem",
                    "Lekka owsianka z jabłkiem i cynamonem.",
                    300,
                    "Anna Kowalska"
            ));
            recipes.add(new Recipe(
                    "Sałatka z tuńczykiem",
                    "Zielona sałatka z tuńczykiem i jajkiem.",
                    400,
                    "Jan Nowak"
            ));
        } else if (kcal < 2200) {
            recipes.add(new Recipe(
                    "Kurczak z ryżem i warzywami",
                    "Soczysty kurczak z ryżem i brokułami.",
                    500,
                    "Kasia Wójcik"
            ));
            recipes.add(new Recipe(
                    "Kanapka z awokado i jajkiem",
                    "Zdrowa kanapka z awokado i jajkiem na twardo.",
                    450,
                    "Tomasz Zieliński"
            ));
        } else {
            recipes.add(new Recipe(
                    "Makaron z łososiem i szpinakiem",
                    "Kremowy makaron z łososiem i szpinakiem.",
                    600,
                    "Aleksandra Lewandowska"
            ));
            recipes.add(new Recipe(
                    "Burrito z wołowiną i fasolą",
                    "Meksykańskie burrito z mięsem i warzywami.",
                    700,
                    "Marek Jankowski"
            ));
        }

        return recipes;
    }
}
