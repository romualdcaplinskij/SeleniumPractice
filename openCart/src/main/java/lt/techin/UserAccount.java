package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAccount extends BasePage{
    public UserAccount(WebDriver driver) {
        super(driver);
    }

    private By editInfoLink = By.cssSelector("div#content > ul:nth-of-type(1) > li:nth-of-type(1) > a");

    public void clickEditInfo(){
        driver.findElement(editInfoLink).click();
    }

}
