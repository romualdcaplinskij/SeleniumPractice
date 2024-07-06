package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    protected WebDriver driver;
    private By loginName = By.id("user-name");
    private By loginPassword = By.id("password");
    private By loginButton = By.id("login-button");

    private By errorMessageField = By.cssSelector("div .error-message-container");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }


    public void userName(String name){
        driver.findElement(loginName).sendKeys(name);
    }

    public void userPassword(String password){
        driver.findElement(loginPassword).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public void fillUserLoginForm(String name, String password){
        userName(name);
        userPassword(password);
        clickLogin();
    }

    public String getCurrentPageLink(){
        return driver.getCurrentUrl();
    }

    public boolean isErrorMessageDisplayed(){
        return driver.findElement(errorMessageField).isDisplayed();
    }

}
