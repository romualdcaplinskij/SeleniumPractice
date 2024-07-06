package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditUserInfo extends BasePage{
    public EditUserInfo(WebDriver driver) {
        super(driver);
    }

    private By firstNameField = By.id("input-firstname");
    private By lastNameField = By.id("input-lastname");
    private By emailField = By.id("input-email");

    public String getFirstNameValue(){
       return driver.findElement(firstNameField).getAttribute("value");
    }

    public String getLastNameValue(){
        return driver.findElement(lastNameField).getAttribute("value");
    }

    public String getEmailValue(){
        return driver.findElement(emailField).getAttribute("value");
    }
}
