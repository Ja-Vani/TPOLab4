package ru.javani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractSite {

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    public void goToSignUp() {
        Utility.getElementBySelector(driver, By.xpath("//*[@id='appbar-signin']")).click();
        Utility.waitUntilPageLoads(driver, 3);
        Utility.getElementBySelector(driver, By.xpath("//*[@id='root']/div/div/form/p[2]/a")).click();
        Utility.waitUntilPageLoads(driver, 3);

    }

    public void goToLogin() {
        Utility.getElementBySelector(driver, By.xpath("//*[@id='appbar-signin']")).click();
    }

    public String doLogin() {
        tryLogin(Utility.CORRECT_LOGIN, Utility.CORRECT_PASSWORD);
        Utility.getElementBySelector(driver, By.xpath("//*[@id=\"hs_cos_wrapper_widget_1674774617303_\"]/img"));
        Utility.waitUntilPageLoads(driver, 15);
        return driver.getCurrentUrl();
    }

    public String doWrongLogin() {
        tryLogin(Utility.CORRECT_LOGIN, Utility.WRONG_PASSWORD);
        Utility.waitUntilPageLoads(driver, 5);
        return Utility.getElementBySelector(driver, By.xpath(".//*[@id='root']/div/div/form/div[3]/div[2]/div")).getText();
    }

    public String doSignUp() {
        trySignUp(Utility.CORRECT_LOGIN, Utility.CORRECT_PASSWORD);
        Utility.waitUntilPageLoads(driver, 5);
        return Utility.getElementBySelector(driver, By.xpath("//*[@id=\"email-helper-text\"]")).getText();
    }

    private void tryLogin(final CharSequence login, final CharSequence password) {
        final WebElement loginInput = Utility.getElementBySelector(driver, By.xpath("//*[@id='username']"));
        final WebElement loginPassword = Utility.getElementBySelector(driver, By.xpath("//*[@id='password']"));
        final WebElement authButton = Utility.getElementBySelector(driver, By.xpath("/html/body/div[2]/div/div/form/button"));
        loginInput.clear();
        loginPassword.clear();
        loginInput.sendKeys(login);
        loginPassword.sendKeys(password);
        authButton.click();

    }

    private void trySignUp(final CharSequence login, final CharSequence password) {
        final WebElement emailInput = Utility.getElementBySelector(driver, By.xpath("//*[@id='email']"));
        final WebElement loginInput = Utility.getElementBySelector(driver, By.xpath("//*[@id='username']"));
        final WebElement loginPassword = Utility.getElementBySelector(driver, By.xpath("//*[@id='password']"));
        final WebElement confirmPassword = Utility.getElementBySelector(driver, By.xpath("//*[@id='mui-17']"));
        final WebElement authButton = Utility.getElementBySelector(driver, By.xpath("/html/body/div[2]/div/div/form/button"));
        emailInput.clear();
        loginInput.clear();
        loginPassword.clear();
        confirmPassword.clear();
        emailInput.sendKeys("ale.ole.nine.six@gmail.com");
        loginInput.sendKeys(login);
        loginPassword.sendKeys(password);
        confirmPassword.sendKeys(password);
        final WebElement acceptSomeGoddamnSpam = Utility.getElementBySelector(driver, By.xpath("//*[@id='root']/div/div/form/label[5]/span"));

        acceptSomeGoddamnSpam.click();
        authButton.click();
    }
}
