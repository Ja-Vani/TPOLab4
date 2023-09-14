package ru.javani;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractSite {

    protected WebDriver driver;

    public AbstractSite(final WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(final WebDriver driver) {
        this.driver = driver;
    }

    public void testSite(final WebDriver webDriver) {
        webDriver.get(Utility.BASE_URL);
        webDriver.manage().window().maximize();
        Utility.getElementBySelector(webDriver, By.xpath("/html/body/div[1]/div/a")).click();
        Utility.waitUntilPageLoads(webDriver, 5);
    }

    public void scrollToElementAndClick(final WebElement element) {
        final int yScrollPosition = element.getLocation().getY();
        ((JavascriptExecutor)driver).executeScript("window.scroll(0, " + yScrollPosition + ");");
        element.click();
    }
}

