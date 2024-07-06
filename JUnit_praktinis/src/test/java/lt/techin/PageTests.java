package lt.techin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import java.time.Duration;


public class PageTests extends TestsSetup {



    protected LoginPage loginPage;


      @BeforeEach
    void setLoginPage(){
          loginPage  = new LoginPage(driver);
      }


    @Test
    void loginSuccess() {
        String login = "standard_user";
        String password = "secret_sauce";
        String expectedPage = "https://www.saucedemo.com/inventory.html";

//        driver.findElement(By.id("user-name")).sendKeys(login);
//        driver.findElement(By.id("password")).sendKeys(password);
//        driver.findElement(By.id("login-button")).click();

        loginPage.fillUserLoginForm(login, password);
        //check if on login user is transferred to inventory page
        Assertions.assertEquals(expectedPage, driver.getCurrentUrl(), "Logged successfully");

        //check if link to shopping cart is visible
        //!!!find element shopping cart should be moved to new java class!!!
        Assertions.assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed(), "The cart is visible");
    }

    @Test
    void loginFail(){
        String login = "standard_user";
        String password = "wrong_password";

        //String errorMessage = "Epic sadface: Username and password do not match any user in this service";
        //driver.findElement(By.id("user-name")).sendKeys(login);
        //driver.findElement(By.id("password")).sendKeys(password);
        //driver.findElement(By.id("login-button")).click();
        //tests if expected error message appears on failed login
        //Assertions.assertEquals(errorMessage, driver.findElement(By.cssSelector("div .error-message-container")).getText(), "Test successfull. The password don't pass");

        loginPage.fillUserLoginForm(login,password);
        //Assertion is tested if error message is displayed
        //!!!find element shopping cart should be moved to new java class!!!

        Assertions.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test
    void lockedUser(){
        String login = "locked_out_user";
        String password = "secret_sauce";

        //String errorMessage = "Epic sadface: Sorry, this user has been locked out.";
        //driver.findElement(By.id("user-name")).sendKeys(login);
        //driver.findElement(By.id("password")).sendKeys(password);
        //driver.findElement(By.id("login-button")).click();
        //tests if expected error message appears on locked user login
        //Assertions.assertEquals(errorMessage, driver.findElement(By.cssSelector("div .error-message-container")).getText(), "Test successfull. User is locked out");

        loginPage.fillUserLoginForm(login,password);
        //Assertion is tested if error message is displayed
        Assertions.assertTrue(driver.findElement(By.cssSelector("div .error-message-container")).isDisplayed());
    }

    @Test
    void timeoutCheck(){
        String login = "performance_glitch_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(login);
        //driver.findElement(By.id("password")).sendKeys(password);

        loginPage.userName(login);
        loginPage.userPassword(password);
        Assertions.assertTimeout(Duration.ofMillis(2000),() -> driver.findElement(By.id("login-button")).click());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/logins.csv", numLinesToSkip = 1)
    void loginTest(String login, String password){
        String expectedPage = "https://www.saucedemo.com/inventory.html";
        //driver.findElement(By.id("user-name")).sendKeys(login);
        //driver.findElement(By.id("password")).sendKeys(password);
        //driver.findElement(By.id("login-button")).click();

        loginPage.fillUserLoginForm(login, password);
        Assertions.assertEquals(expectedPage, driver.getCurrentUrl());
    }

}
