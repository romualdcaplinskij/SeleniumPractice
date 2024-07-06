import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests extends BaseTest {


    @Test
    void standartUserLogin() {


//        MainPage mainPage = new MainPage(driver);
        LoginPageSimple loginPageSimple = new LoginPageSimple(driver);
//        InventoryPage inventoryPage = new InventoryPage(driver);
        // LoginPageSimple loginPage = new LoginPageSimple(driver);

//        mainPage.clickLogin();
        loginPageSimple.enterUsername("standard_user");
        loginPageSimple.enterPassword("secret_sauce");
        loginPageSimple.clickLoginButton();
//        assertEquals("Swag Labs", inventoryPage.getLogoText());

        //assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl(), "Nesutampa nuorodos");


    }


}