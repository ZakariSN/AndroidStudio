package com.example.android_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vedu extends AppCompatActivity {

    private TextView titleTextView;
    private ListView categoryListView;
    private TextView detailsTextView;

    private List<String> categories;
    private Map<String, List<Recipe>> recipesByCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedu);

        // Initialize UI components
        titleTextView = findViewById(R.id.title);
        categoryListView = findViewById(R.id.listView);
        detailsTextView = findViewById(R.id.details);

        // Initialize recipe data
        initializeRecipeData();

        // Set up the list adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, categories);
        categoryListView.setAdapter(adapter);

        // Set up click listener
        categoryListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedCategory = categories.get(position);
            List<Recipe> recipes = recipesByCategory.get(selectedCategory);

            if (recipes != null && !recipes.isEmpty()) {
                displayRecipeDetails(recipes.get(0)); // Show first recipe

                Toast.makeText(this, "Category: " + selectedCategory + " - " + recipes.size() + " recipes available", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initializeRecipeData() {
        categories = new ArrayList<>();
        recipesByCategory = new HashMap<>();

        categories.add("Breakfast");
        categories.add("Lunch");
        categories.add("Dinner");
        categories.add("Desserts");
        categories.add("Beverages");

        List<Recipe> breakfastRecipes = new ArrayList<>();
        breakfastRecipes.add(new Recipe(
                "Fluffy Pancakes", "Light and fluffy pancakes for breakfast.",
                new String[]{"2 cups flour", "2 eggs", "1 3/4 cups milk", "1 tbsp baking powder"},
                new String[]{"1. Mix all ingredients.", "2. Cook on a griddle until golden brown."},
                "25 minutes", "4 servings"
        ));
        recipesByCategory.put("Breakfast", breakfastRecipes);
    }

    private void displayRecipeDetails(Recipe recipe) {
        StringBuilder details = new StringBuilder();

        details.append("📝 ").append(recipe.getName()).append(" 📝\n\n");
        details.append(recipe.getDescription()).append("\n\n");
        details.append("⏱️ Prep Time: ").append(recipe.getPrepTime()).append("\n");
        details.append("🍽️ Servings: ").append(recipe.getServings()).append("\n\n");

        details.append("📋 INGREDIENTS:\n");
        for (String ingredient : recipe.getIngredients()) {
            details.append("• ").append(ingredient).append("\n");
        }
        details.append("\n");

        details.append("👨‍🍳 INSTRUCTIONS:\n");
        for (String step : recipe.getInstructions()) {
            details.append(step).append("\n");
        }

        detailsTextView.setText(details.toString());
    }

    static class Recipe {
        private final String name;
        private final String description;
        private final String[] ingredients;
        private final String[] instructions;
        private final String prepTime;
        private final String servings;

        public Recipe(String name, String description, String[] ingredients,
                      String[] instructions, String prepTime, String servings) {
            this.name = name;
            this.description = description;
            this.ingredients = ingredients;
            this.instructions = instructions;
            this.prepTime = prepTime;
            this.servings = servings;
        }

        public String getName() { return name; }
        public String getDescription() { return description; }
        public String[] getIngredients() { return ingredients; }
        public String[] getInstructions() { return instructions; }
        public String getPrepTime() { return prepTime; }
        public String getServings() { return servings; }
    }
}
