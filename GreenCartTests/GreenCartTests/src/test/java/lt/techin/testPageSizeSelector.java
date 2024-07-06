package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class testPageSizeSelector extends TestSetup {


    @Test
    void testPageSizeFive(){
        greenKart.selectFive();
        System.out.println(greenKart.sizeOfDisplayedItems());
        Assertions.assertEquals(greenKart.sizeOfDisplayedItems(), greenKart.listOfTitles().size());
    }

    @Test
    void testPageSizeTen() {
        greenKart.selectTen();
        System.out.println(greenKart.sizeOfDisplayedItems());
        Assertions.assertEquals(greenKart.sizeOfDisplayedItems(), greenKart.listOfTitles().size());
    }

    @Test
    void testPageSizeTwenty(){
        greenKart.selectTwenty();
        System.out.println(greenKart.sizeOfDisplayedItems());

        //Test fails, because selected size is larger than data available
        Assertions.assertEquals(greenKart.sizeOfDisplayedItems(), greenKart.listOfTitles().size());
    }
}
