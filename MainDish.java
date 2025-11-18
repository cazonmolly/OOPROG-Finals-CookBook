import java.util.ArrayList;

public class MainDish extends Recipe {
    private String proteinType;
    private String cookingMethod;

    public MainDish(String name, ArrayList<String> ingredients, int cookingTime, String instructions, String proteinType) {
        super(name, ingredients, cookingTime, instructions);
        this.proteinType = proteinType;
        this.cookingMethod = "Braise";
    }

    @Override
    public String getRecipeDetails() {
        String baseDetails = super.getRecipeDetails();
        return baseDetails + "\n\n--- Main Dish Details ---\n" +
                "Type: Main Dish\n" +
                "Main Protein: " + proteinType + "\n" +
                "Cooking Method: " + cookingMethod;
    }

    @Override
    public String cook() {
        return "Cooking Main Dish: " + getName() + "\n" +
                "Marinating the " + proteinType + "...\n" +
                "Simmering using the " + cookingMethod + " method.\n" +
                "Adobo is ready to be served with rice!";
    }

    @Override
    public int calculateTotalCalories() {
        return getIngredients().size() * 140;
    }
}