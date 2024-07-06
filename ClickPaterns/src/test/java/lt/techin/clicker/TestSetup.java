package lt.techin.clicker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestSetup {
    WebDriver driver;
    protected Clicker clicker;

    @BeforeEach
    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Vartotojas/Desktop/RC%20Selenium/ClickPaterns/QApraktinisALL.html?width=4&height=4");
        clicker = new Clicker(driver);

    }

    @AfterEach
    public void quit(){
        driver.quit();
    }
}
