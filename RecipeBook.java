import java.util.ArrayList;

public class RecipeBook {
    private ArrayList<Recipe> recipes;
    private String bookName;

    public RecipeBook(String bookName) {
        this.bookName = bookName;
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public boolean removeRecipe(Recipe recipe) {
        return recipes.remove(recipe);
    }

    public Recipe findRecipeByName(String name) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(name)) {
                return recipe;
            }
        }
        return null;
    }

    public ArrayList<Recipe> getAllRecipes() {
        return new ArrayList<>(recipes);
    }

    public int getTotalRecipeCount() {
        return recipes.size();
    }
}