package lt.techin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestSetup {

    WebDriver driver;
    ChromeOptions options;

    @BeforeEach
    public void setDriver(){
        options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        //driver.manage().window();
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");

    }

    @AfterEach
    public void quit(){
        driver.quit();
    }
}
