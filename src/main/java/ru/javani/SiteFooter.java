package ru.javani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteFooter extends AbstractSite {

    public SiteFooter(final WebDriver driver) {
        super(driver);
    }


    public void goToPrintShop() {
        Utility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[2]/div/div[1]/nav/ul/li[1]/a")).click();
        Utility.waitUntilPageLoads(driver, 3);
    }

    public void goToSocialMedia() {
        Utility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[1]/nav/a[5]")).click();
        Utility.waitUntilPageLoads(driver, 3);
    }

    public void goToContact() {
        Utility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[2]/div/div[2]/nav/ul/li[3]/a")).click();
        Utility.waitUntilPageLoads(driver, 3);
    }

    public void goToBlog() {
        Utility.getElementBySelector(driver, By.xpath("//*[@id=\"root\"]/footer/div[1]/div[2]/div/div[3]/nav/ul/li[1]/a")).click();
        Utility.waitUntilPageLoads(driver, 3);
    }
}

