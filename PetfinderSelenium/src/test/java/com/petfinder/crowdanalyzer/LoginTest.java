package com.petfinder.crowdanalyzer;

import com.petfinder.crowdanalyzer.pageObjects.LoginPage;
import com.petfinder.crowdanalyzer.utils.files.JsonReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.petfinder.crowdanalyzer.pageObjects.HomePage;


public class LoginTest extends BaseTest {
    private JsonReader testData;

    @BeforeClass
    public void testDataReader(){
        testData = new JsonReader("./src/test/resources/dataTests.json");
    }

    @Test
    public void TestLogin(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.navigate().clickLoginBtn().
                login(testData.getJson("email"),testData.getJson("passwordLogin"));
        Assert.assertEquals(loginPage.getLoginHeaderTitle(),
                "No favorites here yet");
    }



}
