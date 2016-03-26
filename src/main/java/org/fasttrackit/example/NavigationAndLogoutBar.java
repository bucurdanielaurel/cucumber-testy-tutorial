package org.fasttrackit.example;

// preferences and logout navigation bar

import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigationAndLogoutBar {

    @FindBy (how = How.XPATH, using = "//nav//button")
    private WebElement preferencesButton;

    public void openPreferencesWindow (){
        preferencesButton.click();

        // because of window animation (slide down)
         Utils.sleep(300);
    }

}
