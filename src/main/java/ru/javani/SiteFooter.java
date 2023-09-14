package ru.javani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class SiteFooter extends AbstractSite {

    public SiteFooter(final WebDriver driver) {
        super(driver);
    }


    public void goToPrintShop() {
        scrollToElementAndClick(Utility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[2]/div/div[1]/nav/ul/li[1]/a")));
        final ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Utility.waitUntilPageLoads(driver, 5);
    }

    public void goToSocialMedia() {
        scrollToElementAndClick(Utility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[1]/nav/a[5]")));
        final ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Utility.waitUntilPageLoads(driver, 5);
    }

    public void goToContact() {
        scrollToElementAndClick(Utility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[2]/div/div[2]/nav/ul/li[3]/a")));
        Utility.waitUntilPageLoads(driver, 5);
    }

    public void goToBlog() {
        scrollToElementAndClick(Utility.getElementBySelector(driver, By.xpath("//*[@id=\"root\"]/footer/div[1]/div[2]/div/div[3]/nav/ul/li[1]/a")));
        Utility.waitUntilPageLoads(driver, 5);
    }
}

