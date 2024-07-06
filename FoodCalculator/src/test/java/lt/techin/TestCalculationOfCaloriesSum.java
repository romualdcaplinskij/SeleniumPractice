package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCalculationOfCaloriesSum extends TestSetup{

    @Test
    void sumOfCalories(){
        tracalorie.addMultipleMeals();
        Assertions.assertEquals(tracalorie.sumAllCaloriesFromCSV(), tracalorie.sumOfCalories());
    }
}
