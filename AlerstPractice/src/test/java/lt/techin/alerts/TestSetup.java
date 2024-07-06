package lt.techin.alerts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestSetup {

    WebDriver driver;
    AlertPage alertPage;

    @BeforeEach
    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        alertPage = new AlertPage(driver);

    }

    @AfterEach
    public void quit(){
        driver.quit();
    }
}
