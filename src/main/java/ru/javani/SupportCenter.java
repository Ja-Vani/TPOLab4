package ru.javani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SupportCenter extends AbstractSite {
    public SupportCenter(final WebDriver driver) {
        super(driver);
    }

    public void testSupport() {
        final Actions actions = new Actions(driver);
        final WebElement support = Utility.getElementBySelector(driver, By.xpath("//*[@id='root']/footer/div[1]/div[2]/div/div[2]/nav/ul/li[1]/a"));
        actions.moveToElement(support);
        Utility.waitUntilPageLoads(driver, 3);
        support.click();
    }

    public void selectSection() {
        Utility.getElementBySelector(driver, By.xpath("/html/body/main/div/section/section[1]/ul/li[5]/a")).click();
        Utility.waitUntilPageLoads(driver, 3);
    }

    public void selectQuestion() {
        Utility.getElementBySelector(driver, By.xpath("/html/body/main/div/section/section[2]/ul/li[1]/a")).click();
        Utility.waitUntilPageLoads(driver, 3);
    }

    public void useChat() {
        Utility.getElementBySelector(driver, By.xpath("/html/body/div[3]/div[2]/iframe")).click();
        driver.switchTo().frame(Utility.getElementBySelector(driver, By.xpath("/html/body/div[3]/div[1]/div/iframe")));
        //Utility.getElementBySelector(driver, By.xpath("//*[@id='home']")).click();
        Utility.getElementBySelector(driver, By.xpath(".//*[@id='1val-field_1.3.10--input']")).sendKeys("Hi");
        Utility.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/button")).click();
    }
}
