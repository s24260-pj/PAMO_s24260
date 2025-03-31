package com.example.pamo_s24260;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pamo_s24260.model.Recipe;
import com.example.pamo_s24260.services.Resolver.RecipeByCaloriesResolver;

import java.util.List;


public class CaloricRequirementSummaryFragment extends Fragment {
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_caloric_requirement_summary, container, false);

        float totalDailyEnergyExpenditure = CaloricRequirementSummaryFragmentArgs
                .fromBundle(getArguments())
                .getTotalDailyEnergyExpenditure();

        TextView kcalTextView = view.findViewById(R.id.kcalTextView);
        String kcalText = getString(R.string.caloric_requirement_text, (int) totalDailyEnergyExpenditure);
        kcalTextView.setText(kcalText);

        LinearLayout recipesListContainer = view.findViewById(R.id.recipesListContainer);

        RecipeByCaloriesResolver recipeByCaloriesResolver = new RecipeByCaloriesResolver();
        List<Recipe> recipes = recipeByCaloriesResolver.resolve(totalDailyEnergyExpenditure);

        for (Recipe recipe : recipes) {
            TextView recipeView = new TextView(getContext());
            String recipeText = getString(R.string.recipe_item_text,
                    recipe.getName(),
                    recipe.getCalories(),
                    recipe.getDescription(),
                    recipe.getAuthor());
            recipeView.setText(recipeText);
            recipeView.setPadding(0, 8, 0, 8);
            recipesListContainer.addView(recipeView);
        }

        return view;
    }
}