package ru.javani;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class Utility {

    public static final String BASE_URL = "https://photobucket.com";

    public static final String CORRECT_LOGIN = "TpoLab3Abogatov";
    public static final String CORRECT_PASSWORD = "1234abcdlk";
    public static final String WRONG_PASSWORD = "4321abcdlk";

    public static List<WebDriver> getDrivers(final int type) {
        final List<WebDriver> drivers = new ArrayList<>();
        try {
            if(type == 0) {
                drivers.add(getFirefoxDriver());
            } else if (type == 1) {
                drivers.add(getChromeDriver());
            } else {
                drivers.add(getFirefoxDriver());
                drivers.add(getChromeDriver());
            }
        } catch (Exception e) {
            final Logger log = Logger.getLogger(Exception.class.getName());
            log.info(e.getMessage());
        }
        return drivers;
    }

    private static RemoteWebDriver getChromeDriver() throws MalformedURLException {
        final AbstractDriverOptions<?> options = new ChromeOptions();
        final var capabilities = new HashMap<String, Object>();
        capabilities.put("name", "Test badge...");
        capabilities.put("sessionTimeout", "15m");

        final var envs = new ArrayList<String>();
        envs.add("TZ=UTC");
        capabilities.put("env", envs);

        final var labels = new HashMap<String, Object>();
        labels.put("manual", "true");
        capabilities.put("labels", labels);

//        capabilities.put("enableVideo", true);
        capabilities.put("enableVNC", true);

        options.setCapability("selenoid:options", capabilities);

        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }

    private static RemoteWebDriver getFirefoxDriver() throws MalformedURLException {
        final AbstractDriverOptions<?> options = new FirefoxOptions();
        final var capabilities = new HashMap<String, Object>();
        capabilities.put("name", "Test badge...");
        capabilities.put("sessionTimeout", "15m");

        final var envs = new ArrayList<String>();
        envs.add("TZ=UTC");
        capabilities.put("env", envs);

        final var labels = new HashMap<String, Object>();
        labels.put("manual", "true");
        capabilities.put("labels", labels);

//        capabilities.put("enableVideo", true);
        capabilities.put("enableVNC", true);

        options.setCapability("selenoid:options", capabilities);
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }

    public static WebElement getElementBySelector(final WebDriver driver, final By selector) {
        final WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public static void waitUntilPageLoads(final WebDriver driver, final long timeout) {
        final WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        final String complete = "complete";
        waitDriver.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals(complete));
    }

}