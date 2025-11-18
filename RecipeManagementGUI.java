import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecipeManagementGUI extends JFrame {

    private final RecipeBook recipeBook = new RecipeBook("My Filipino Cookbook");
    private final DefaultListModel<Recipe> recipeListModel = new DefaultListModel<>();
    private final JList<Recipe> recipeList = new JList<>(recipeListModel);
    private final JTextArea recipeDetailsArea = new JTextArea();

    public RecipeManagementGUI() {
        setTitle("Recipe Cookbook Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(new TitledBorder("All Recipes"));
        recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listPanel.add(new JScrollPane(recipeList), BorderLayout.CENTER);

        JPanel detailsPanel = new JPanel(new BorderLayout());
        detailsPanel.setBorder(new TitledBorder("Recipe Details"));
        recipeDetailsArea.setEditable(false);
        recipeDetailsArea.setWrapStyleWord(true);
        recipeDetailsArea.setLineWrap(true);
        recipeDetailsArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        detailsPanel.add(new JScrollPane(recipeDetailsArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton addButton = new JButton("Add Recipe");
        JButton removeButton = new JButton("Remove Selected");
        JButton cookButton = new JButton("Cook Selected");
        JButton exitButton = new JButton("Exit");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(cookButton);
        buttonPanel.add(exitButton);

        ((JPanel) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listPanel, detailsPanel);
        splitPane.setDividerLocation(250);

        add(splitPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        recipeList.addListSelectionListener(e -> {
            Recipe selectedRecipe = recipeList.getSelectedValue();
            if (selectedRecipe != null) {
                recipeDetailsArea.setText(selectedRecipe.getRecipeDetails());
                recipeDetailsArea.setCaretPosition(0);
            } else {
                recipeDetailsArea.setText("Please select a recipe to view its details.");
            }
        });

        addButton.addActionListener(e -> handleAddRecipe());

        removeButton.addActionListener(e -> {
            Recipe selectedRecipe = recipeList.getSelectedValue();
            if (selectedRecipe != null) {
                int choice = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to remove '" + selectedRecipe.getName() + "'?",
                        "Confirm Removal", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    recipeBook.removeRecipe(selectedRecipe);
                    updateRecipeList();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a recipe to remove.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cookButton.addActionListener(e -> {
            Recipe selectedRecipe = recipeList.getSelectedValue();
            if (selectedRecipe != null) {
                String cookingSteps = selectedRecipe.cook();
                JOptionPane.showMessageDialog(this, cookingSteps, "Cooking: " + selectedRecipe.getName(), JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a recipe to cook.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        addSampleData();
        updateRecipeList();
    }

    private void handleAddRecipe() {
        JTextField nameField = new JTextField();
        JTextField ingredientsField = new JTextField();
        JTextField timeField = new JTextField();
        JTextArea instructionsArea = new JTextArea(5, 20);

        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Main Dish", "Side Dish", "Dessert"});
        JTextField specificField = new JTextField();
        JLabel specificLabel = new JLabel("Protein Type:");

        typeComboBox.addActionListener(e -> {
            String selected = (String) typeComboBox.getSelectedItem();
            switch (selected) {
                case "Main Dish":
                    specificLabel.setText("Protein Type:");
                    break;
                case "Side Dish":
                    specificLabel.setText("Category:");
                    break;
                case "Dessert":
                    specificLabel.setText("Sweetness (1-10):");
                    break;
            }
        });

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Recipe Type:"));
        panel.add(typeComboBox);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Ingredients (comma-separated):"));
        panel.add(ingredientsField);
        panel.add(new JLabel("Cooking Time (mins):"));
        panel.add(timeField);
        panel.add(specificLabel);
        panel.add(specificField);
        panel.add(new JLabel("Instructions:"));

        JPanel fullPanel = new JPanel(new BorderLayout(5,5));
        fullPanel.add(panel, BorderLayout.NORTH);
        fullPanel.add(new JScrollPane(instructionsArea), BorderLayout.CENTER);

        int result = JOptionPane.showConfirmDialog(this, fullPanel, "Add New Recipe",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                ArrayList<String> ingredients = new ArrayList<>(Arrays.asList(ingredientsField.getText().split(",")));
                int time = Integer.parseInt(timeField.getText());
                String instructions = instructionsArea.getText();
                String type = (String) typeComboBox.getSelectedItem();

                Recipe newRecipe = null;
                switch (type) {
                    case "Main Dish":
                        newRecipe = new MainDish(name, ingredients, time, instructions, specificField.getText());
                        break;
                    case "Side Dish":
                        newRecipe = new SideDish(name, ingredients, time, instructions, specificField.getText());
                        break;
                    case "Dessert":
                        int sweetness = Integer.parseInt(specificField.getText());
                        newRecipe = new Dessert(name, ingredients, time, instructions, sweetness);
                        break;
                }
                if (newRecipe != null) {
                    recipeBook.addRecipe(newRecipe);
                    updateRecipeList();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number for time or sweetness.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateRecipeList() {
        recipeListModel.clear();
        for (Recipe recipe : recipeBook.getAllRecipes()) {
            recipeListModel.addElement(recipe);
        }
    }

    private void addSampleData() {
        ArrayList<String> adoboIngredients = new ArrayList<>(Arrays.asList("Chicken thighs", "Pork belly", "Soy Sauce", "Vinegar", "Garlic", "Bay Leaves"));
        recipeBook.addRecipe(new MainDish("Chicken Pork Adobo", adoboIngredients, 60, "1. Sear pork and chicken until brown.\n2. Saute garlic.\n3. Add all ingredients to pot and simmer until meat is tender and sauce has thickened.", "Pork & Chicken"));

        ArrayList<String> lumpiaIngredients = new ArrayList<>(Arrays.asList("Ground Pork", "Minced Carrots", "Chopped Onions", "Lumpia Wrappers", "Cooking Oil"));
        recipeBook.addRecipe(new SideDish("Lumpiang Shanghai", lumpiaIngredients, 30, "1. Combine all filling ingredients in a bowl.\n2. Wrap a spoonful of mixture in lumpia wrappers.\n3. Deep fry in hot oil until golden brown and crispy.", "Appetizer"));

        ArrayList<String> flanIngredients = new ArrayList<>(Arrays.asList("Egg Yolks", "Condensed Milk", "Evaporated Milk", "Sugar", "Vanilla Extract"));
        recipeBook.addRecipe(new Dessert("Leche Flan", flanIngredients, 50, "1. Melt sugar to create a caramel base in molds.\n2. Mix remaining ingredients and strain mixture.\n3. Pour mixture into molds and steam until set.\n4. Chill thoroughly before serving.", 9));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new RecipeManagementGUI().setVisible(true);
        });
    }
}