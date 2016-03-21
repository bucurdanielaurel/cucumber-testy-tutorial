package org.fasttrackit.example;

// preferences and logout navigation bar

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigationAndLogoutBar {

    @FindBy (how = How.XPATH, using = "//nav//button")
    private WebElement preferencesButton;

    public void clickChangePassword (){
        preferencesButton.click();

    }

}
