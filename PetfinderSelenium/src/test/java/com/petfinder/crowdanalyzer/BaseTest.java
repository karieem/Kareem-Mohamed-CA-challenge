package com.petfinder.crowdanalyzer;

import com.petfinder.crowdanalyzer.utils.core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        DriverFactory.setDriver(DriverFactory.BrowserType.CHROME);
        driver = DriverFactory.getDriver();

    }

    @AfterTest
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
