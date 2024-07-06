package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActionTests extends TestSetup {

    @Test
    void itemIsMovedAndDropped() {
        String testText = "Dropped!";
        testPage.dragItem();
        Assertions.assertEquals(testText,testPage.getTextWhenDragged());
    }

    @Test
    void itemIsDoubleClicked(){
        String backgroundColorAfterDoubleClick = "rgba(147, 203, 90, 1)";
        testPage.doubleClick();
        Assertions.assertEquals(backgroundColorAfterDoubleClick, testPage.getColorAfterDoubleClick());
    }

    @Test
    void hoverAndClickFirst(){
        String successAlert = "Well done you clicked on the link!";
        testPage.interactFirstDropdown();
        Assertions.assertEquals(successAlert, testPage.getAlertMessage());
        testPage.closeAlert();
    }

    @Test
    void hoverAndClickSecond(){
        String successAlert = "Well done you clicked on the link!";
        testPage.interactSecondDropdown();
        Assertions.assertEquals(successAlert, testPage.getAlertMessage());
        testPage.closeAlert();

    }

    @Test
    void hoverAndClickThird(){
        String successAlert = "Well done you clicked on the link!";
        testPage.interactThirdDropdownFirstLink();
        Assertions.assertEquals(successAlert, testPage.getAlertMessage());
        testPage.closeAlert();
        testPage.interactThirdDropdownSecondLink();
        Assertions.assertEquals(successAlert, testPage.getAlertMessage());
        testPage.closeAlert();
    }


}
