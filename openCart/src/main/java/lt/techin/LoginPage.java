package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailInputField = By.id("input-email");
    private By passwordInputField = By.id("input-password");
    private By loginButton = By.cssSelector("[action] .btn-primary");

    void emailInput(String email){
        driver.findElement(emailInputField).sendKeys(email);
    }

    void passwordInput(String password){
        driver.findElement(passwordInputField).sendKeys(password);
    }

    void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    void loginUser(String email, String password){
        emailInput(email);
        passwordInput(password);
        clickLoginButton();
    }


}
