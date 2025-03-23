package com.petfinder.crowdanalyzer.pageObjects;

import com.petfinder.crowdanalyzer.utils.elements.Actions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public By emailField_input = By.id("signInFormUsername");
    public By passwordInput = By.id("signInFormPassword");
    public By signInSubmitBtn = By.name("signInSubmitButton");
    public By favouriteBtn = By.xpath("//a[@href='/user/favorites/' and contains(@class, 'Header-module--header__favoritesBtn')]");
    public By getLoginHeaderTitle = By.xpath("//h2[text()='No favorites here yet']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login")
    public LoginPage login(String email ,String password) {

        Actions.type(emailField_input, driver, email);
        Actions.type(passwordInput, driver, password);
        Actions.click(signInSubmitBtn, driver);
        Actions.click(favouriteBtn, driver);
        return this;
    }

    @Step("Get Login Page Header")
    public String getLoginHeaderTitle() {
        return Actions.getText(getLoginHeaderTitle, driver);
    }

}
