package org.fasttrackit.onlinelibrary.login;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.example.ChangePasswordPage;
import org.fasttrackit.example.LoginPage;
import org.fasttrackit.example.NavigationAndLogoutBar;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChangePasswordTest extends TestBase {

    private LoginPage loginPage;
    private ChangePasswordPage changePasswordPage;
    private NavigationAndLogoutBar navigationAndLogoutBar;

    public ChangePasswordTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
        navigationAndLogoutBar = PageFactory.initElements(driver, NavigationAndLogoutBar.class);
    }

    @Test
    public void whenEnterValidCredentialsImSuccessfullyLogin() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException exception) {
            Assert.fail("Could not login. Logout button not found.");
        }
    }

    @Test
    public void whenEnterInvalidCredentialsImSuccessfullyLogin() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com","wrongpasword");

        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException exception) {
            Assert.fail("Could not login. Logout button not found.");
        }
    }

    @Test
    public void whenEnterEnterEmailIgetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "");

        WebElement errorMsg = driver.findElement((By.className("error-msg")));
        System.out.println(errorMsg.getText());
        assertThat(errorMsg.getText(), is("Please enter your password!"));
        }

    @Test
    public void whenEnterEnterjustPassword() {
        openLoginPage();
        loginPage.doLogin("", "some.pass");
        loginPage.assertThatErrorIs("Please Enter your Email!");

    }

    @Test
    public void whenEnternoCredentials () {
        openLoginPage();
        loginPage.doLogin("eu@fast.com","eu.pass");

//        WebElement preferencesButton = driver.findElement(By.xpath("//nav//button"));
//        preferencesButton.click();


        Utils.sleep(300);

        navigationAndLogoutBar.clickChangePassword();

        changePasswordPage.changePassword("eu.pass", "eu.pass2");

        String statusElementText = changePasswordPage.getStatusMessage();

        System.out.println(statusElementText);
        assertThat(statusElementText , is("Your password has been successfully changed."));

    }
    @Test
    public void succeschangepassword(){
        openLoginPage();
        loginPage.doLogin("", "some.pass");

    }

    private void openLoginPage() {
        System.out.println("open login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }

}
