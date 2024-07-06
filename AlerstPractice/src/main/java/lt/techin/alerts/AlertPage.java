package lt.techin.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class AlertPage {

        protected WebDriver driver;
        protected WebDriverWait wait;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void initWait(){
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    }

    @FindBy (css = "#button1")
    private WebElement jsButton;

    @FindBy (css = "#button2")
    private WebElement modalAlertButton;

    @FindBy (css = "h4")
    private WebElement modalAlertTitle;

    @FindBy (css = ".modal-footer button")
    private WebElement modalAlertDismissButton;

    @FindBy (css = "#button3")
    private WebElement ajaxLoaderButton;

    @FindBy (css = "span#button1 > p")
    private WebElement ajaxLoaderDismissButton;

    @FindBy (css = "#button4")
    private WebElement jsConfirmBoxButton;

    @FindBy (css = "p#confirm-alert-text")
    private WebElement jsConfirmBoxSuccessMessage;

    public void javaScriptAlert(){
        jsButton.click();
    }

    public String jsAlertMessage(){
        return driver.switchTo().alert().getText();
    }

    public void closeJsAlert(){
        initWait();
        wait.until(ExpectedConditions.
                alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    public void clickModalButton(){
        modalAlertButton.click();
    }

    public String modalAlertMessage(){
        initWait();
        return wait.until(ExpectedConditions.visibilityOf(modalAlertTitle)).getText();
    }

    public void closeModalAlert(){
        modalAlertDismissButton.click();
    }

    public void clickAjaxButton(){
        ajaxLoaderButton.click();
    }

    public void clickClickMeButton(){
        initWait();
        wait.until(ExpectedConditions.elementToBeClickable(ajaxLoaderDismissButton));
        ajaxLoaderDismissButton.click();
    }

    public void jsConfirmBox(){
        jsConfirmBoxButton.click();

    }

    public void jsBoxAlertConfirm(){
        driver.switchTo().alert().accept();
    }

    public String getJsCloseAlertSuccessMessage(){
        return jsConfirmBoxSuccessMessage.getText();
    }

}
