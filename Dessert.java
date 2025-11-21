import java.util.ArrayList;

public class Dessert extends Recipe {
    private int sweetnessLevel;

    public Dessert(String name, ArrayList<String> ingredients, int cookingTime, String instructions, int sweetnessLevel) {
        super(name, ingredients, cookingTime, instructions);
        this.sweetnessLevel = sweetnessLevel;
    }

    @Override
    public String getRecipeDetails() {
        String baseDetails = super.getRecipeDetails();
        return baseDetails + "\n\n--- Dessert Details ---\n" +
                "Type: Dessert\n" +
                "Sweetness Level: " + sweetnessLevel + "/10";
    }

    @Override
    public String cook() {
        return "Preparing Dessert: " + getName() + "\n" +
                "Following steaming and chilling instructions...\n" +
                "Dessert is ready!";
    }

    @Override
    public int calculateTotalCalories() {
        return getIngredients().size() * 180;
    }
}
