import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class firtsTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
//        WebElement usernameInput = driver.findElement(By.id("username"));
//        usernameInput.sendKeys("student");
//        WebElement passwordInput = driver.findElement(By.id("password"));
//        passwordInput.sendKeys("Password123");
//        WebElement submitButton = driver.findElement(By.id("submit"));
//        submitButton.click();
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
//        boolean confirmation = driver.getCurrentUrl().equals("https://practicetestautomation.com/logged-in-successfully/");
//        if (confirmation) System.out.println("Successfully loged in");
//        else System.out.println("Some error acquired");
        System.out.println(driver.getCurrentUrl().equals("https://practicetestautomation.com/logged-in-successfully/") ? "Loged in" : "Error acquired");
    }
}
