package org.fasttrackit.example;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordPage {
    //css selector: $$("#preferences-win input[name=password]")
    @FindBy (how = How.XPATH, using = "//div[@id='preferences-win']//input[@name='password']")
    private WebElement currentPasswordField;

    @FindBy (how = How.XPATH, using = "//input[@name='newPassword']")
    private WebElement newPasswordField;

    @FindBy (how = How.XPATH, using = "//input[@name='newPasswordRepeat']")
    private WebElement repeatPasswordField;

    @FindBy (how = How.CSS, using = "#preferences-win button.btn-warning")
    private WebElement saveBtn;

    @FindBy (how = How.CSS, using = "#preferences-win .status-msg")
    private WebElement statusElement;


    public void changePassword(String password, String newPassword) {
        currentPasswordField.sendKeys(password);
        newPasswordField.sendKeys(newPassword);
        repeatPasswordField.sendKeys("eu.pass2");
        saveBtn.click();

    }


    public String getStatusMessage() {
        return statusElement.getText();
    }
}
