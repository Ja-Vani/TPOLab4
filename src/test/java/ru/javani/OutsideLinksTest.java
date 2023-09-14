package ru.javani;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OutsideLinksTest {
    final private List<WebDriver> drivers = Utility.getDrivers(2);


    @Test
    void checkPrintShop() {
        drivers.parallelStream().forEach(webDriver -> {
            final SiteFooter siteFooter = new SiteFooter(webDriver);
            siteFooter.testSite(webDriver);
            siteFooter.goToPrintShop();
            assertEquals("https://www.printshoplab.com", webDriver.getCurrentUrl().substring(0, 28));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkSocial() {
        drivers.parallelStream().forEach(webDriver -> {
            final SiteFooter siteFooter = new SiteFooter(webDriver);
            siteFooter.testSite(webDriver);
            siteFooter.goToSocialMedia();
            assertEquals("https://www.youtube.com/", webDriver.getCurrentUrl().substring(0, 24));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkContact() {
        drivers.parallelStream().forEach(webDriver -> {
            final SiteFooter siteFooter = new SiteFooter(webDriver);
            siteFooter.testSite(webDriver);
            siteFooter.goToContact();
            assertEquals("https://zendesk.photobucket.com", webDriver.getCurrentUrl().substring(0, 31));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkBlog() {
        drivers.parallelStream().forEach(webDriver -> {
            final SiteFooter siteFooter = new SiteFooter(webDriver);
            siteFooter.testSite(webDriver);
            siteFooter.goToBlog();
            assertEquals("https://blog.photobucket.com", webDriver.getCurrentUrl().substring(0, 28));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkAppAndroid() {
        drivers.parallelStream().forEach(webDriver -> {
            final SiteHeader siteHeader = new SiteHeader(webDriver);
            siteHeader.testSite(webDriver);
            siteHeader.goToAppAndroid();
            assertEquals("https://play.google.com/store/apps/details?id=com.photobucket.android", webDriver.getCurrentUrl().substring(0, 69));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkAppIos() {
        drivers.parallelStream().forEach(webDriver -> {
            final SiteHeader siteHeader = new SiteHeader(webDriver);
            siteHeader.testSite(webDriver);
            siteHeader.goToAppIos();
            assertEquals("https://apps.apple.com/us/app/photobucket-backup/", webDriver.getCurrentUrl().substring(0, 49));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

}
