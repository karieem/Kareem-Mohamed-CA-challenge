package com.petfinder.crowdanalyzer.utils.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // Enum for supported browser types
    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE
    }

    // Initialize the WebDriver
    public static void setDriver(BrowserType browserType) {
        if (driverThreadLocal.get() != null) {
            throw new IllegalStateException("WebDriver is already initialized.");
        }

        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                driverThreadLocal.set(new ChromeDriver(chromeOptions));
                break;

            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-private");
                driverThreadLocal.set(new FirefoxDriver(firefoxOptions));
                break;

            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("-inprivate");
                driverThreadLocal.set(new EdgeDriver(edgeOptions));
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
        driverThreadLocal.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            throw new IllegalStateException("WebDriver is not initialized. Call setDriver() first.");
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
