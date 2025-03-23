package com.petfinder.crowdanalyzer.pageObjects;

import com.petfinder.crowdanalyzer.utils.elements.Actions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public By btnSignin = By.xpath("//button[@aria-label='sign in' and @type='button']");
    public By btnLogin = By.xpath("//button[text()='Log in']");
    public By btnRegister = By.xpath("//button[text()='Create Account']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigate To Home Page")
    public HomePage navigate() {
        driver.navigate().to("https://www.petfinder.com/");
        return this;
    }
    @Step("Navigate To Login Page")
    public LoginPage clickLoginBtn() {
        Actions.click(btnSignin, driver);
        Actions.click(btnLogin, driver);
        return new LoginPage(driver);
    }

    @Step("Navigate To Register Page")
    public RegisterPage clickRegisterBtn(){
        Actions.click(btnSignin, driver);
        Actions.click(btnRegister, driver);
        return new RegisterPage(driver);
    }

}
