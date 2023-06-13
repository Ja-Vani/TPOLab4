package ru.javani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteHeader extends AbstractSite {

    public SiteHeader(final WebDriver driver) {
        super(driver);
    }


    public void goToAppAndroid() {
        Utility.getElementBySelector(driver, By.xpath("//*[@id='appbar-mobile-app-dl-android']")).click();
        Utility.waitUntilPageLoads(driver, 3);
    }

    public void goToAppIos() {
        Utility.getElementBySelector(driver, By.xpath("//*[@id='appbar-mobile-app-dl-apple']")).click();
        Utility.waitUntilPageLoads(driver, 3);
    }
}