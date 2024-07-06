package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestSetup{

    protected LoginPage loginPage;

    @BeforeEach
    public void initiateLoginPage(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Valid login test")
    public void loginValidUser() {
        UserAccount userAccount = new UserAccount(driver);
        EditUserInfo editUserInfo = new EditUserInfo(driver);

        String validEmail = "homersimpson@springfield.com";
        String validPassword = "aaaaaa0*";

        loginPage.loginUser(validEmail,validPassword);

        //Switches to user Account Info
        userAccount.clickEditInfo();

        //checks if valid email is same as email in user info
        Assertions.assertEquals(validEmail, editUserInfo.getEmailValue());

    }

    @Test
    @DisplayName("Invalid user email does not log user")
    public void loginInvalidUserEmail(){
        String validEmail = "simpson@springfield.com";
        String validPassword = "aaaaaa0*";
        String pageName = "Account Login";
        loginPage.loginUser(validEmail,validPassword);

        //checks if page title not changed after login attempt
        Assertions.assertEquals(pageName, loginPage.getPageTitle());
    }

    @Test
    @DisplayName("Invalid user password does not log user")
    public void loginInvalidPassword(){
        String validEmail = "homersimpson@springfield.com";
        String validPassword = "aaaaaa";
        String pageName = "Account Login";
        loginPage.loginUser(validEmail,validPassword);

        //checks if page title not changed after login attempt
        Assertions.assertEquals(pageName, loginPage.getPageTitle());
    }


}
