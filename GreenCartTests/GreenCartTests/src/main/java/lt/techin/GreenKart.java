package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GreenKart {

    protected WebDriver driver;

//    protected Actions action;
    public GreenKart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "select#page-menu > option")
    private WebElement getDisplayedSize;
    @FindBy (css = "select#page-menu")
    private WebElement valueSelector;

    @FindBy (css = "[value='5']")
    private WebElement valueFive;
    @FindBy (css = "[value='10']")
    private WebElement valueTen;
    @FindBy (css = "[value='20']")
    private WebElement valueTwenty;

    @FindBy (css = "#search-field")
    private WebElement searchField;

    @FindBy (css = "tr > td:first-of-type")
    private WebElement itemName;

    @FindBy (css = "tr > td:nth-of-type(2)")
    private WebElement price;

    @FindBy (css = "tr > td:nth-of-type(3)")
    private WebElement discountPrice;

    public void setSearchField(String string){
        searchField.sendKeys(string);
    }


    public List<String> allListItems(){
        selectTwenty();
        return listOfTitles();
    }


    public int sizeOfDisplayedItems(){
        return Integer.parseInt(valueSelector.getAttribute("value"));
    }

    public void selectFive(){
        valueSelector.click();
        valueFive.click();
    }

    public void selectTen(){
        valueSelector.click();
        valueTen.click();
    }

    public void selectTwenty(){
        valueSelector.click();
        valueTwenty.click();
    }

    public List<String> listOfTitles(){
        String noResultMessage = "No data";
        List<String> titles = new ArrayList<>();
        List<WebElement> listOfTitles = driver.findElements(By.cssSelector("tr > td:first-of-type"));
        for (WebElement name: listOfTitles) {
            if (!noResultMessage.equals(name.getText())){
                titles.add(name.getText());
            }
        }
         return titles;
    }


    public List<String> validSearchResult(String search){
        List<String> listOfValidResults = new ArrayList<>();

        for (String name : allListItems()) {
            if (name.toLowerCase().contains(search.toLowerCase())){
                listOfValidResults.add(name);
            }
        }

        return listOfValidResults;
    }



}
