import java.util.ArrayList;

public abstract class Recipe implements Cookable {
    private String name;
    private ArrayList<String> ingredients;
    private int cookingTimeMinutes;
    private String instructions;
    private String difficultyLevel;
    private int servings;

    public Recipe(String name, ArrayList<String> ingredients, int cookingTimeMinutes, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.cookingTimeMinutes = cookingTimeMinutes;
        this.instructions = instructions;
        this.difficultyLevel = "Intermediate";
        this.servings = 4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public int getCookingTime() {
        return cookingTimeMinutes;
    }

    public void setCookingTime(int minutes) {
        this.cookingTimeMinutes = minutes;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String level) {
        this.difficultyLevel = level;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getRecipeDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recipe: ").append(name).append("\n");
        sb.append("Cooking Time: ").append(cookingTimeMinutes).append(" minutes\n");
        sb.append("Servings: ").append(servings).append("\n");
        sb.append("Difficulty: ").append(difficultyLevel).append("\n\n");
        sb.append("Ingredients:\n");
        for (String ingredient : ingredients) {
            sb.append("- ").append(ingredient.trim()).append("\n");
        }
        sb.append("\nInstructions:\n").append(instructions);
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public abstract int calculateTotalCalories();

    // This abstract method declaration was missing and is now fixed.
    public abstract String cook();
}