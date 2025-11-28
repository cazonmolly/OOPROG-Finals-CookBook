# Project Assessment Rubric

**Project:** Recipe CookBook Program
**Section:** C2B
**Course:** Object Oriented Programming

## Grading Breakdown

### 1. Class Diagram Completeness (25%)
**Score:** 4/5
**Notes:** Good UML diagram provided via Figma, now available as uml.png. The diagram shows proper inheritance hierarchy with abstract Recipe class extended by MainDish, Dessert, and SideDish. All classes display attributes (name, ingredients, cookingTimeMinutes, etc.) and methods (cook(), calculateTotalCalories()). The Cookable interface is shown but relationships could be more explicitly marked with interface implementation arrows. Minor deduction for not showing all relationship details with proper UML notation (e.g., multiplicities on associations).

### 2. Java Program - OOP Concepts (50%)
**Score:** 5/5
**Notes:** Excellent implementation of all four OOP concepts:
- **Encapsulation:** Private fields in Recipe class (name, ingredients, cookingTimeMinutes, etc.) with public getters/setters
- **Inheritance:** Clear inheritance hierarchy with Recipe as abstract base class, extended by MainDish, Dessert, and SideDish
- **Polymorphism:** Abstract methods (cook(), calculateTotalCalories()) overridden in subclasses; interface Cookable implemented
- **Abstraction:** Abstract Recipe class and Cookable interface demonstrate abstraction; each subclass provides specific implementations

### 3. Git Usage & Collaboration (15%)
**Score:** 4/5
**Notes:** Good collaboration evident with 3 contributors: cazonmolly (19 commits), ralphiancomendador (6 commits), and Michael Ong (1 commit). Decent distribution shows active participation, though one contributor dominates. Good team effort overall.

### 4. Base Grade (10%)
**Score:** 5/5

### 5. Extra Points (up to 6)

**Features:** 1/5
- UI Swing

**Code Quality:** 1.0/1.0
- Variable naming: 0.5/0.5
- Code organization: 0.5/0.5

**Extra Points Total:** +2.0

---

## Final Grade: 97 + 2.0 = **99/100**

*Assessment generated based on project analysis.*
