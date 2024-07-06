package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class clearAllButtonTest extends TestSetup{

    @Test
    void clearAll(){
        int sizeOfMealListBefore;
        int sizeOfMealListAfter;

        sizeOfMealListBefore = tracalorie.countNumberOfMeals();
        tracalorie.addMultipleMeals();
        tracalorie.useClearAllButton();
        sizeOfMealListAfter = tracalorie.countNumberOfMeals();
        Assertions.assertEquals(sizeOfMealListBefore, sizeOfMealListAfter);
    }
}
