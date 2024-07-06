package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class editButtonTest extends TestSetup {

    @Test
    void checkIfRenameButtonIsVisible() {
        String mealName = "test";
        String calories = "0";
        tracalorie.addMeal(mealName, calories);
        tracalorie.useEditButton();
        Assertions.assertTrue(tracalorie.isEditButtonDisplayed());
    }

    @Test
    void checkIfDeleteButtonIsVisible() {
        String mealName = "test";
        String calories = "0";
        tracalorie.addMeal(mealName, calories);
        tracalorie.useEditButton();
        Assertions.assertTrue(tracalorie.isDeleteButtonDisplayed());
    }

    @Test
    void renameSingleItem() {
        String mealName = "test";
        String editMealName = "carrot";
        String calories = "0";
        tracalorie.addMeal(mealName, calories);
        Assertions.assertEquals(mealName, tracalorie.getAddedMealName());
        tracalorie.clickEditButton();
        tracalorie.editMealName(editMealName);
        Assertions.assertEquals(editMealName, tracalorie.getAddedMealName());
    }

    @Test
    void changeMealNameAndCalories() {
        String mealName = "test";
        String editMealName = "carrot";
        String calories = "0";
        String editCalories = "10";
        tracalorie.addMeal(mealName, calories);
        Assertions.assertEquals(mealName, tracalorie.getAddedMealName());
        Assertions.assertEquals(calories, tracalorie.getAddedMealCalories());
        tracalorie.clickEditButton();
        tracalorie.editMealNameAndCalories(editMealName, editCalories);
        Assertions.assertEquals(editMealName, tracalorie.getAddedMealName());
        Assertions.assertEquals(editCalories, tracalorie.getAddedMealCalories());
    }

    @Test
    void changeAllMealNameAndCalories() {
        String editMealName = "carrot";
        String editCalories = "10";

        tracalorie.addMultipleMeals();
        int sizeOfList = tracalorie.countSizeOfCSV();
        for (int i = 0; i < sizeOfList; i++) {
            tracalorie.clickEditButton();
            tracalorie.editMealNameAndCalories(editMealName, editCalories);
        }

    }

    @Test
    void deleteOne() {
        String mealName = "test";
        String calories = "0";
        int sizeOfMealListBefore;
        int sizeOfMealListAfter;

        sizeOfMealListBefore = tracalorie.countNumberOfMeals();
        tracalorie.addMeal(mealName, calories);
        tracalorie.deleteMeal();
        sizeOfMealListAfter = tracalorie.countNumberOfMeals();
        Assertions.assertEquals(sizeOfMealListBefore, sizeOfMealListAfter);
    }

    @Test
    void deleteAllMeals() {
        int sizeOfMealListBefore;
        int sizeOfMealListAfter;

        sizeOfMealListBefore = tracalorie.countNumberOfMeals();
        tracalorie.addMultipleMeals();
        int sizeOfList = tracalorie.countSizeOfCSV();
        for (int i = 0; i < sizeOfList; i++) {
            tracalorie.deleteMeal();
        }
        sizeOfMealListAfter = tracalorie.countNumberOfMeals();
        Assertions.assertEquals(sizeOfMealListBefore, sizeOfMealListAfter);
    }


    @Test
    void changeAllMealsName() {
        String editMealName = "Potato";
        tracalorie.addMultipleMeals();
        tracalorie.editAllMealsName(editMealName);
    }

    @Test
    void changeAllMealsNameAndCalories() {
        String editMealName = "Potato";
        String calories = "0";
        tracalorie.addMultipleMeals();
        tracalorie.editAllMealsNameAndCalories(editMealName, calories);
    }


}
