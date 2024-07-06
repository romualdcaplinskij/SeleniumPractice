package lt.techin.clicker;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.UnhandledAlertException;

public class ClickElements extends TestSetup{

    @Test
    public void clickAllElements(){
        while (true) {
            //Need a breakpoint
            try {
                clicker.clickElement();
                clicker.closeAlert();
            } catch (UnhandledAlertException ignore) {
            }
        }
    }
}

