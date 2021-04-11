package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Page {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public Page(WebDriver driver, WebDriverWait wait, Actions actions) {

        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }

    public void click(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
    }

    public void setText(By by, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).clear();
        for (int i = 0; i < text.length(); i++)
            driver.findElement(by).sendKeys(Character.toString(text.charAt(i)));
    }

    public void clearText(By by) {
        driver.findElement(by).clear();
    }

    public boolean checkElementVisibility(By by) {
        try {
            driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void navigate(String url) {
        driver.navigate().to(url);
    }

    public void verifyPopupMessage(By by, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertEquals(driver.findElement(by).getText(), text);
    }

    public void warningAssertion(By by, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertEquals(driver.findElement(by).getText(), text);
    }

    public String getText(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            String text = driver.findElement(by).getText();
            if (text.isEmpty())
                return driver.findElement(by).getAttribute("value");
            return text;
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            String text = driver.findElement(by).getText();
            if (text.isEmpty())
                return driver.findElement(by).getAttribute("value");
            return text;
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

}
