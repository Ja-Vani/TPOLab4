package ru.javani;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static final String CHROME_SYSTEM_PROPERTY_NAME = "webdriver.chrome.driver";
    public static final String CHROME_SYSTEM_PROPERTY_PATH = "drivers/chromedriver.exe";
    public static final String FIREFOX_SYSTEM_PROPERTY_NAME = "webdriver.gecko.driver";
    public static final String FIREFOX_SYSTEM_PROPERTY_PATH = "drivers/geckodriver.exe";


    public static final String BASE_URL = "https://photobucket.com";


    public static final String CORRECT_LOGIN = "TpoLab3Abogatov";
    public static final String DISPLAY_NAME = "TpoLab3Abogatov";
    public static final String CORRECT_PASSWORD = "1234abcdlk";
    public static final String WRONG_PASSWORD = "4321abcdlk";

    public static List<WebDriver> getDrivers() {
        final List<WebDriver> drivers = new ArrayList<>();
//        drivers.add(getFirefoxDriver());
        drivers.add(getChromeDriver());
        return drivers;
    }

    private static ChromeDriver getChromeDriver() {
        return new ChromeDriver();
    }

//    private static FirefoxDriver getFirefoxDriver() {
//        return new FirefoxDriver();
//    }

    public static void prepareDrivers() {
        System.setProperty(CHROME_SYSTEM_PROPERTY_NAME, CHROME_SYSTEM_PROPERTY_PATH);
        System.setProperty(FIREFOX_SYSTEM_PROPERTY_NAME, FIREFOX_SYSTEM_PROPERTY_PATH);
    }

    public static WebElement getElementBySelector(final WebDriver driver, final By selector) {
        final WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }


    public static void waitUntilPageLoads(final WebDriver driver, final long timeout) {
        final WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        final String complete = "complete";
        waitDriver.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals(complete));
    }
}