package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AddMealTest extends TestSetup {


    @Test
    void addValidMeal() {
        String validMeal = "Sausage";
        String validCalories = "150";

        tracalorie.addMeal(validMeal, validCalories);
        Assertions.assertEquals(validMeal, tracalorie.getAddedMealName());
        Assertions.assertEquals(validCalories, tracalorie.getAddedMealCalories());
    }

    @Test
    void addListOfMeals() {
        //ads multiple meals from CSV file
        tracalorie.addMultipleMeals();
        Assertions.assertEquals(tracalorie.countSizeOfCSV(), tracalorie.countNumberOfMeals());

    }

    @Test
    void addEmptyMeal() {
        String validMeal = "";
        String validCalories = "150";
        int sizeOfMealListBefore;
        int sizeOfMealListAfter;

        sizeOfMealListBefore = tracalorie.countNumberOfMeals();
        tracalorie.addMeal(validMeal, validCalories);
        sizeOfMealListAfter = tracalorie.countNumberOfMeals();
        Assertions.assertEquals(sizeOfMealListBefore, sizeOfMealListAfter);
    }

    @Test
    void addEmptyCalories() {
        String validMeal = "Sausage";
        String validCalories = "";
        int sizeOfMealListBefore;
        int sizeOfMealListAfter;

        sizeOfMealListBefore = tracalorie.countNumberOfMeals();
        tracalorie.addMeal(validMeal, validCalories);
        sizeOfMealListAfter = tracalorie.countNumberOfMeals();
        Assertions.assertEquals(sizeOfMealListBefore, sizeOfMealListAfter);
    }

    @Test
    void addNegativeCalories(){
        String validMeal = "Sausage";
        String validCalories = "-150";
        int sizeOfMealListBefore;
        int sizeOfMealListAfter;

        sizeOfMealListBefore = tracalorie.countNumberOfMeals();
        tracalorie.addMeal(validMeal, validCalories);
        sizeOfMealListAfter = tracalorie.countNumberOfMeals();
        Assertions.assertEquals(sizeOfMealListBefore, sizeOfMealListAfter);
    }

    @Test
    void addCharacterInCalories(){
        String validMeal = "Sausage";
        String validCalories = "ooo";
        int sizeOfMealListBefore;
        int sizeOfMealListAfter;

        sizeOfMealListBefore = tracalorie.countNumberOfMeals();
        tracalorie.addMeal(validMeal, validCalories);
        sizeOfMealListAfter = tracalorie.countNumberOfMeals();
        Assertions.assertEquals(sizeOfMealListBefore, sizeOfMealListAfter);
    }

    @Test
    void addCaloriesUsingArrowUP(){
        String validMeal = "Sausage";
        int calories = 100;
        int sizeOfMealListBefore;
        int sizeOfMealListAfter;

        sizeOfMealListBefore = tracalorie.countNumberOfMeals();
        tracalorie.addCaloriesUsingArrowUP(validMeal,calories);
        sizeOfMealListAfter = tracalorie.countNumberOfMeals();
        Assertions.assertNotEquals(sizeOfMealListBefore, sizeOfMealListAfter);

    }

    @Test
    void addCaloriesUsingArrowDown(){
        String validMeal = "Sausage";
        int calories = 100;
        int sizeOfMealListBefore;
        int sizeOfMealListAfter;

        sizeOfMealListBefore = tracalorie.countNumberOfMeals();
        tracalorie.addCaloriesUsingArrowDown(validMeal,calories);
        sizeOfMealListAfter = tracalorie.countNumberOfMeals();
        Assertions.assertEquals(sizeOfMealListBefore, sizeOfMealListAfter);
    }

}
