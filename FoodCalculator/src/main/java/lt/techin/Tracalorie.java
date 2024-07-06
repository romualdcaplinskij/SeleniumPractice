package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Tracalorie {

    protected WebDriver driver;

    private final String DELIMITER = ",";

    public Tracalorie(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input#item-name")
    private WebElement mealInputField;

    @FindBy(css = "input#item-calories")
    private WebElement caloriesInputField;

    @FindBy(css = ".add-btn.blue.btn.darken-3")
    private WebElement addMealButton;

    @FindBy(css = "li > strong")
    private WebElement addedMealName;

    @FindBy(css = "li > em")
    private WebElement addedMealCalories;

    @FindBy(css = "ul#item-list > li")
    private List<WebElement> addedMealsList;
//    @FindBy(css = "ul#item-list > li")
//    private Meal addedMealsList;

    @FindBy(css = ".clear-btn")
    private WebElement clearButton;

    @FindBy (css = ".total-calories")
    private WebElement sumOfList;

    @FindBy (css = "li > .secondary-content")
    private WebElement editButton;

    @FindBy (css = ".update-btn")
    private WebElement renameButton;

    @FindBy (css = ".delete-btn")
    private WebElement deleteButton;

    @FindBy (css = ".back-btn")
    private WebElement backButton;

    public void addMeal(String meal, String calories) {
        mealInputField.sendKeys(meal);
        caloriesInputField.sendKeys(calories);
        addMealButton.click();
    }

    public void addCaloriesUsingArrowUP(String meal, int calories){
        mealInputField.sendKeys(meal);
        for (int i = 0; i < calories; i++) {
            caloriesInputField.sendKeys(Keys.ARROW_UP);
        }
        addMealButton.click();
    }

    public void addCaloriesUsingArrowDown(String meal, int calories){
        mealInputField.sendKeys(meal);
        for (int i = 0; i < calories; i++) {
            caloriesInputField.sendKeys(Keys.ARROW_DOWN);
        }
        addMealButton.click();
    }

    public String getAddedMealName() {
        return addedMealName.getText().replace(":", "");
    }

    public String getAddedMealCalories() {
        List<Meal> mealsList = new ArrayList<>();
        return addedMealCalories.getText().replace(" Calories", "");
    }

    public int countNumberOfMeals() {
        return addedMealsList.size();
    }


    private List<Meal> readCSV2() throws IOException {

        //need to rewrite to catch exceptions
        String CSV_PATH = "src/test/resources/productList.csv";
        return Files.readAllLines(Paths.get(CSV_PATH))
                .stream()
                .map(line -> new Meal(line.split(DELIMITER)[0],line.split(DELIMITER)[1] ))
                .toList();
    }


//    private List<List<String>> readCSV() throws IOException {
//
//        //need to rewrite to catch exceptions
//        return Files.readAllLines(Paths.get(CSV_PATH))
//                .stream()
//                .map(line -> Arrays.asList(line.split(DELIMITER)))
//                .toList();
//    }

    public void addMultipleMeals() {
        try {
            List<Meal> listOfMeals = readCSV2();
            for (Meal element : listOfMeals) {
                String mealName = element.getName(0);
                String calories = element.getCalories(1);
                addMeal(mealName, calories);
            }
        } catch (IOException ignored) {
        }

    }

    public int countSizeOfCSV() {
        int size;
        try {
            List<Meal> listOfMeals = readCSV2();
            size = listOfMeals.size();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return size;
    }

    public void useClearAllButton(){
        clearButton.click();
    }

    public int sumAllCaloriesFromCSV(){
        int caloriesSum = 0;
        try {
            List<Meal> listOfMeals = readCSV2();
            for (Meal element : listOfMeals) {
                caloriesSum += Integer.parseInt(element.getCalories(1));
            }
        } catch (IOException ignored) {
        }
        return caloriesSum;
    }

    public int sumOfCalories(){
        return Integer.parseInt(sumOfList.getText());
    }

    public void useEditButton(){
        editButton.click();
    }

    public boolean isEditButtonDisplayed(){
        return renameButton.isDisplayed();
    }

    public boolean isDeleteButtonDisplayed(){
        return deleteButton.isDisplayed();
    }

    public void clickEditButton(){
        editButton.click();
    }

    public void editMealName(String meal){
        mealInputField.clear();
        mealInputField.sendKeys(meal);
        renameButton.click();
    }



    public void editMealNameAndCalories(String meal, String calories){
        mealInputField.clear();
        mealInputField.sendKeys(meal);
        caloriesInputField.clear();
        caloriesInputField.sendKeys(calories);
        renameButton.click();
    }

    public void deleteMeal(){
        editButton.click();
        deleteButton.click();
    }

    public void editAllMealsName(String name){
        for (WebElement liElement : addedMealsList) {
            WebElement editButton = liElement.findElement(By.cssSelector(".edit-item"));
            editButton.click();
            editMealName(name);
        }
    }

    public void editAllMealsNameAndCalories(String name, String calories){
        for (WebElement liElement : addedMealsList) {
            WebElement editButton = liElement.findElement(By.cssSelector(".edit-item"));
            editButton.click();
            editMealNameAndCalories(name, calories);
        }
    }



}
