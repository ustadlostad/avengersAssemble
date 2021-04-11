package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends Page {

    private final By userName_txb = By.id("UserName");
    private final By password_txb = By.id("password");
    private final By submit_btn = By.xpath("//button[@type = 'submit']");
    private final By loginForm = By.id("login-form");
    private final By loginErrorPopup = By.xpath("//span/strong");
    private final By usernameError = By.xpath("//small[@data-cv-field='UserName']");
    private final By passwordError = By.xpath("//small[@data-cv-field='Password']");
    private final By warningPopupOk = By.xpath("//div[@id='ui-id-1']//button");
    private final By username_xpath = By.id("ysUserName");

    public LoginPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void goToLoginPage(String url) {
        navigate(url);
    }

    public void checkLoginFormVisibility() {
        checkElementVisibility(loginForm);
    }

    public void setUserName(String userName) {
        click(userName_txb);
        setText(userName_txb, userName);
    }

    public void setPassword(String password) {
        click(password_txb);
        setText(password_txb, password);
    }

    public void clearUsername() {
        clearText(userName_txb);
    }

    public void clearPassword() {
        clearText(password_txb);
    }

    public void submit() {
        click(submit_btn);
    }

    public void popupAssertion(String message) {
        verifyPopupMessage(loginErrorPopup, message);
    }

    public void unLoginWarningAssertion(String message) {
        warningAssertion(usernameError, message);
    }

    public void pswLoginWarningAssertion(String message) {
        warningAssertion(passwordError, message);
    }

    public void closeWarningPopup() {
        click(warningPopupOk);
    }

    public void checkUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username_xpath));
        Assert.assertEquals(driver.findElement(username_xpath).getText(), username);
    }


}
