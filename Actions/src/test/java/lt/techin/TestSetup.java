package lt.techin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestSetup {
    WebDriver driver;
    protected TestPage testPage;

    @BeforeEach
    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        testPage = new TestPage(driver);

    }

    @AfterEach
    public void quit(){
        driver.quit();
    }
}
