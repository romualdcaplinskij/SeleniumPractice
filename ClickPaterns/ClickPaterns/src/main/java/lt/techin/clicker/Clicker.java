package lt.techin.clicker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Clicker {

    private WebDriver driver;
    private final Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMillis(2000));;

    public Clicker(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "div .icon")
    private List<WebElement> clickableIcons;

    public int sizeOfMatrix(){
        return clickableIcons.size();
    }

    public void clickElement(){
        for (int i = 0; i < sizeOfMatrix(); i++) {
            clickableIcons.get(i).click();
        }
    }

//    public String alertMessage(){
//        wait.until(ExpectedConditions.alertIsPresent());
//        return driver.switchTo().alert().getText();
//    }

    public void closeAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public int sizeFromUrl(){
        String url = driver.getCurrentUrl();
        String last = url.substring(url.length() - 1);
        return Integer.parseInt(last);
    }
}
