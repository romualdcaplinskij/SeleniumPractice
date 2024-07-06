package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By myAccountButton = By.cssSelector(".list-inline-item:nth-of-type(2) .d-md-inline");
    private By loginButton = By.cssSelector(".dropdown-menu.dropdown-menu-right.show > li:nth-of-type(2) > .dropdown-item");

    public void clickLoginButton(){
        driver.findElement(myAccountButton).click();
        driver.findElement(loginButton).click();
    }

}
