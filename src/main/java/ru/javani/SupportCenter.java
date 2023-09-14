package ru.javani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SupportCenter extends AbstractSite {
    public SupportCenter(final WebDriver driver) {
        super(driver);
    }

    public void testSupport() {
        final WebElement support = Utility.getElementBySelector(driver, By.xpath("//*[@id='root']/footer/div[1]/div[2]/div/div[2]/nav/ul/li[1]/a"));
        scrollToElementAndClick(support);
        Utility.waitUntilPageLoads(driver, 3);
    }

    public void selectSection() {
        scrollToElementAndClick(Utility.getElementBySelector(driver, By.xpath("/html/body/main/div/section/section[1]/ul/li[5]/a")));
        Utility.waitUntilPageLoads(driver, 3);
    }

    public void selectQuestion() {
        scrollToElementAndClick(Utility.getElementBySelector(driver, By.xpath("/html/body/main/div/section/section[2]/ul/li[1]/a")));
        Utility.waitUntilPageLoads(driver, 3);
    }
}
