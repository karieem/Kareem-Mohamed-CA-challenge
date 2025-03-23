package com.petfinder.crowdanalyzer.utils.elements;

import org.openqa.selenium.*;

public class Actions {

    public static void type(final By locator, final WebDriver driver, String... keys) {
        try {
            Finder.elementVisibility(locator, driver).sendKeys(keys);
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].click();",
                    Finder.elementVisibility(locator, driver));
        } catch (Exception e) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].click();",
                    Finder.elementPresence(locator, driver));
        }
    }

    public static void click(final By locator, final WebDriver driver) {
        try {
            Finder.elementVisibility(locator, driver).click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].click();",
                    Finder.elementVisibility(locator, driver));
        } catch (Exception e) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].click();",
                    Finder.elementPresence(locator, driver));
        }}

          public static String getText(final By locator, final WebDriver driver) {
            try {
                return Finder.elementVisibility(locator, driver).getText();
            } catch (Exception e) {
                return Finder.elementPresence(locator, driver).getText();
            }
        }
    public static void selectDropdownOption(final By locator, final WebDriver driver, int optionNumber) {
        try {
            click(locator, driver);
            String dynamicXPath = "(//*[@role='option'])[" + optionNumber + "]";
            By optionLocator = By.xpath(dynamicXPath);
            Finder.elementVisibility(optionLocator, driver).click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            String dynamicXPath = "(//*[@role='option'])[" + optionNumber + "]";
            By optionLocator = By.xpath(dynamicXPath);
            javascriptExecutor.executeScript("arguments[0].click();", Finder.elementVisibility(optionLocator, driver));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to select the dropdown option number: " + optionNumber);
        }
    }


}

