package org.fasttrackit.onlinelibrary.login;

import org.apache.xpath.SourceTree;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FirstLoginTest extends TestBase {

    @Test
    public void whenEnterValidCredentialsImSuccessfullyLogin() {
        openLoginPage();
        doLogin("eu@fast.com","eu.pass");

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
        doLogin("eu@fast.com","wrongpasword");

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
        doLogin("eu@fast.com", "");

        WebElement errorMsg = driver.findElement((By.className("error-msg")));
        System.out.println(errorMsg.getText());
        assertThat(errorMsg.getText(), is("Please enter your password!"));
        }

    @Test
    public void whenEnterEnterjustPassword() {
        openLoginPage();
        doLogin("", "some.pass");

        assertThatErrorIs("Please Enter your Email!");
    }

    private void assertThatErrorIs(String message) {
        WebElement errorMsg = driver.findElement((By.className("error-msg")));
        System.out.println(errorMsg.getText());
        assertThat(errorMsg.getText(), is(message));
    }

    private void doLogin(String username, String parola) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(username);

        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys(parola);

        WebElement loginBtn = driver.findElement(By.className("btn"));
        loginBtn.click();

    }

    private void openLoginPage() {
        System.out.println("open login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }

}
