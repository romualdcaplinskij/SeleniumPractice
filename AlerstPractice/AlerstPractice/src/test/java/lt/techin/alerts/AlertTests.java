package lt.techin.alerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AlertTests extends TestSetup {

    @Test
    public void jsAlertTest(){
        String confirmMessage = "I am an alert box!";
        alertPage.javaScriptAlert();
        Assertions.assertEquals(confirmMessage, alertPage.jsAlertMessage());
        alertPage.closeJsAlert();
    }

    @Test
    public void modalAlertTest() throws InterruptedException {
        String confirmMessage = "It’s that Easy!! Well I think it is.....";
        alertPage.clickModalButton();
        Assertions.assertEquals(confirmMessage, alertPage.modalAlertMessage());
        System.out.println(alertPage.modalAlertMessage());
        alertPage.closeModalAlert();
    }

    @Test
    public void ajaxLoaderTest(){
        String confirmMessage = "Well Done For Waiting....!!!";
        alertPage.clickAjaxButton();
        alertPage.clickClickMeButton();
        System.out.println(alertPage.modalAlertMessage());
        Assertions.assertEquals(confirmMessage, alertPage.modalAlertMessage());
        alertPage.closeModalAlert();
    }

    @Test
    public void jsBoxConfirmAlertTest(){
        String confirmMessage = "You pressed OK!";
        alertPage.jsConfirmBox();
        alertPage.jsBoxAlertConfirm();
        System.out.println(alertPage.getJsCloseAlertSuccessMessage());
        Assertions.assertEquals(confirmMessage, alertPage.getJsCloseAlertSuccessMessage());
    }



}
