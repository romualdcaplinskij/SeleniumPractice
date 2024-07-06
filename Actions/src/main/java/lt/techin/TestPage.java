package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestPage {

    protected WebDriver driver;

    protected Actions action;

//    protected WebDriverWait wait;

    @FindBy(css = "div#draggable")
    private WebElement draggable;

    @FindBy(css = "div#droppable")
    private WebElement droppable;

    @FindBy(css = "#droppable p > b:first-of-type")
    private WebElement dropped;

    @FindBy(css = "div#double-click")
    private WebElement toDoubleClick;

    @FindBy(css = "#div-hover div:nth-of-type(1) .dropbtn")
    private WebElement firstDropdown;

    @FindBy(css = "#div-hover div:nth-child(1) .list-alert")
    private WebElement firstItemInFirstDropdown;

    @FindBy(css = "#div-hover div:nth-of-type(2) .dropbtn")
    private WebElement secondDropdown;

    @FindBy(css = "#div-hover .dropdown:nth-of-type(2) .list-alert")
    private WebElement firstItemInSecondDropdown;

    @FindBy(css = "#div-hover div:nth-of-type(3) .dropbtn")
    private WebElement thirdDropdown;

    @FindBy(css = "#div-hover div:nth-child(3) .list-alert")
    private WebElement firstItemInThirdDropdown;

    @FindBy(css = ".dropdown-content > a:nth-of-type(2)")
    private WebElement secondItemInThirdDropdown;

    public TestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void initialiseAction() {
        action = new Actions(driver);
    }


    public void dragItem() {
        initialiseAction();
        action.dragAndDrop(draggable, droppable).perform();
    }

    public String getTextWhenDragged() {
        return dropped.getText();
    }

    public void doubleClick() {
        initialiseAction();
        action.doubleClick(toDoubleClick).perform();

    }

    public String getColorAfterDoubleClick() {
        return toDoubleClick.getCssValue("background-color");
    }

    public void closeAlert() {
        driver.switchTo().alert().accept();

    }

    public String getAlertMessage(){
        return driver.switchTo().alert().getText();
    }


    public void interactFirstDropdown(){
        initialiseAction();
        action.moveToElement(firstDropdown).perform();
        firstItemInFirstDropdown.click();
    }

    public void interactSecondDropdown(){
        initialiseAction();
        action.moveToElement(secondDropdown).perform();
        firstItemInSecondDropdown.click();
    }

    public void interactThirdDropdownFirstLink(){
        initialiseAction();
        action.moveToElement(thirdDropdown).perform();
        firstItemInThirdDropdown.click();
    }

    public void interactThirdDropdownSecondLink(){
        initialiseAction();
        action.moveToElement(thirdDropdown).perform();
        secondItemInThirdDropdown.click();
    }

}
