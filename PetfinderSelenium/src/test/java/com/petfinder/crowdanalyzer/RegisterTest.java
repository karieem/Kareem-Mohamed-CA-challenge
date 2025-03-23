package com.petfinder.crowdanalyzer;

import com.github.javafaker.Faker;
import com.petfinder.crowdanalyzer.pageObjects.HomePage;
import com.petfinder.crowdanalyzer.pageObjects.RegisterPage;
import com.petfinder.crowdanalyzer.utils.files.JsonReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest  extends BaseTest {
    private JsonReader testData;
    Faker faker = new Faker();

    @BeforeClass
    public void testDataReader(){
        testData = new JsonReader("./src/test/resources/dataTests.json");
    }

    @Test
    public void TestRegister(){
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.navigate()
                .clickRegisterBtn()
                .fillSignUp(
                        faker.internet().emailAddress(),
                        testData.getJson("firstName"),
                        testData.getJson("lastName"),
                        testData.getJson("zipCode"),
                        testData.getJson("password"),
                        testData.getJson("confirmPassword")
                );

        Assert.assertEquals(registerPage.getRegisterPageHeader(),
        "Verify your email");
    }

}
