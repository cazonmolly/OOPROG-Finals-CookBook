# Recipe Cookbook Management System
A Java-based GUI application for managing Filipino recipes, demonstrating the four fundamental Object-Oriented Programming (OOP) concepts.
Designed to serve as a digital repository for cooking instructions. Its primary purpose is to leverage OOP to create a structured, scalable, and maintainable system for managing recipes. This structure allows for easy addition of new recipe types, clear separation of concerns, and consistent handling of common recipe attributes and actions. Instead of a flat list, the program utilizes a hierarchy to categorize recipes, ensuring that specific dish types (such as a cake versus a steak) have appropriate, specialized properties and behaviors while sharing core recipe characteristics.
## Project Overview
This system allows users to manage a collection of recipes including Main Dishes, Side Dishes, and Desserts. The application features a graphical user interface built with Java Swing and implements core OOP principles throughout its architecture.

## Four OOP Concepts Implementation

### 1. Encapsulation
Data hiding and controlled access through private fields and public methods.

#### Examples:
- Recipe class uses private fields (name, ingredients, cookingTimeMinutes, etc.)
- Access controlled through getter/setter methods (getName(), setName(), etc.)
- RecipeBook encapsulates the recipe collection with controlled add/remove operations

### 2. Inheritance
Child classes inherit properties and behaviors from parent classes.

#### Class Hierarchy:
Recipe (Abstract)
├── MainDish
├── SideDish
└── Dessert

#### Examples:
- MainDish, SideDish, and Dessert extend Recipe
- Child classes inherit all fields and methods from Recipe
- Constructor chaining using super() to initialize parent class fields

### 3. Polymorphism

Objects can take multiple forms and be treated as instances of their parent class.

#### Types Demonstrated:

- Method Overriding: Child classes provide specific implementations of abstract methods
- Runtime Polymorphism: Recipe references can point to MainDish, SideDish, or Dessert objects

### 4. Abstraction

Hiding implementation details and showing only essential features.

#### Examples:

- Abstract Class: Recipe defines the template with abstract methods
- Interface: Cookable interface defines the cooking contract
- Concrete classes provide specific implementations

## Key Features

- Add Recipes: Create new recipes with detailed information
- Remove Recipes: Delete recipes from the cookbook
- View Details: Display complete recipe information including ingredients, instructions, and cooking time
- Cook Recipes: Simulate the cooking process with specific instructions for each recipe type

#### Recipe Types:

- Main Dish (with protein type and cooking method)
- Side Dish (with category and vegetarian flag)
- Dessert (with sweetness level)

## Using the Application

Once the program runs, you'll see the main window with two panels and buttons at the bottom.

#### Adding a Recipe:

- Click the "Add Recipe" button
- Select recipe type from dropdown (Main Dish, Side Dish, or Dessert)

#### Fill in all fields:

- Name: Recipe name
- Ingredients: Comma-separated list (e.g., "Chicken, Soy Sauce, Garlic")
- Cooking Time: Time in minutes (numbers only)
- Type-specific field: Protein type, Category, or Sweetness level (1-10)
- Instructions: Step-by-step cooking instructions
- Click OK to add the recipe

#### Viewing Recipe Details:

- Click on any recipe name in the left panel
- Full recipe details appear in the right panel

#### Cooking a Recipe:

- Select a recipe from the list
- Click the "Cook Selected" button
- A popup shows the cooking simulation steps

#### Removing a Recipe:

- Select a recipe from the list
- Click the "Remove Selected" button
- Confirm the deletion in the popup dialog

#### Exiting the Program:

- Click the "Exit" button, or
- Close the window using the X button

#### Quick Test Run

Try these steps to test the application:

- Run the program (3 sample recipes are pre-loaded)
- Click on "Chicken Pork Adobo" to view its details
- Click "Cook Selected" to see the cooking simulation
- Click "Add Recipe" and create your own recipe
- Click "Remove Selected" to delete a recipe

## How to run the program
#### Using IntelliJ IDEA:

- Open IntelliJ IDEA
- Click File - New - Project
- Select Java project, click Next
- Name your project, click Finish
- Copy all .java files into the src folder
- Right-click on RecipeManagementGUI.java - Run 'RecipeManagementGUI.main()'

