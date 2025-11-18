import java.util.ArrayList;

public class SideDish extends Recipe {
    private String sideDishCategory;
    private boolean isVegetarian;

    public SideDish(String name, ArrayList<String> ingredients, int cookingTime, String instructions, String category) {
        super(name, ingredients, cookingTime, instructions);
        this.sideDishCategory = category;
        this.isVegetarian = false;
    }

    @Override
    public String getRecipeDetails() {
        String baseDetails = super.getRecipeDetails();
        return baseDetails + "\n\n--- Side Dish Details ---\n" +
                "Type: Side Dish\n" +
                "Category: " + sideDishCategory + "\n" +
                "Vegetarian: " + (isVegetarian ? "Yes" : "No");
    }

    @Override
    public String cook() {
        return "Making Side Dish: " + getName() + "\n" +
                "Frying the lumpia until golden and crispy...\n" +
                "Lumpia is ready! Serve with sweet chili sauce.";
    }

    @Override
    public int calculateTotalCalories() {
        return getIngredients().size() * 95;
    }
}