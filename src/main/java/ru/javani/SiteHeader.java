package ru.javani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class SiteHeader extends AbstractSite {

    public SiteHeader(final WebDriver driver) {
        super(driver);
    }


    public void goToAppAndroid() {
        Utility.getElementBySelector(driver, By.xpath("//*[@id='appbar-mobile-app-dl-android']")).click();
        final ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Utility.waitUntilPageLoads(driver, 5);
    }

    public void goToAppIos() {
        Utility.getElementBySelector(driver, By.xpath("//*[@id='appbar-mobile-app-dl-apple']")).click();
        final ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Utility.waitUntilPageLoads(driver, 5);
    }
}