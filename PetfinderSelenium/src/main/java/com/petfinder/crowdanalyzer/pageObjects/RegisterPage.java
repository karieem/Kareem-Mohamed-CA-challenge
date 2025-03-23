package com.petfinder.crowdanalyzer.pageObjects;

import com.petfinder.crowdanalyzer.utils.elements.Actions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    public By email_field = By.id("emailAddress");
    public By continueBtn = By.xpath("//button[@type='submit']");
    public By firstNameField = By.id("firstName");
    public By lastNameField = By.id("lastName");
    public By postalCodeField = By.id("postalCode");
    public By dogDropdwon = By.xpath("//button[@id='dogCount-trigger']");
    public By catDropdwon = By.xpath("//button[@id='catCount-trigger']");
    public By passwordField = By.id("password");
    public By confirmPasswordField = By.id("confirmPassword");
    public By teermsBtn = By.id("terms");
    public By createAccountBtn = By.xpath("//button[text()='Create Account' and @type='submit']");
    public By verifiedBtn = By.xpath("//button[contains(text(), 'Verified? Now Sign-In')]");
    public By getRegisterHeaderTitle = By.xpath("//h1[text()='Verify your email']");



    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Fill Register Form Details")
    public RegisterPage fillSignUp (String emailRegister, String firstName, String lastName,
                                     String zipCode, String password, String confirmPassword) {
        Actions.type(email_field, driver, emailRegister);
        Actions.click(continueBtn, driver);
        Actions.type(firstNameField, driver, firstName);
        Actions.type(lastNameField, driver, lastName);
        Actions.type(postalCodeField, driver, zipCode);
        Actions.selectDropdownOption(dogDropdwon, driver, 2);
        Actions.selectDropdownOption(catDropdwon, driver, 3);
        Actions.click(continueBtn, driver);
        Actions.type(passwordField, driver, password);
        Actions.type(confirmPasswordField, driver, confirmPassword);
        Actions.click(teermsBtn, driver);
        Actions.click(createAccountBtn, driver);
//        Actions.click(verifiedBtn, driver);
        return this;
    }
    @Step("Get Register Page Header")
    public String getRegisterPageHeader() {

        return Actions.getText(getRegisterHeaderTitle, driver);
    }

 }
