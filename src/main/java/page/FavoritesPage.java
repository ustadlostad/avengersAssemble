package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FavoritesPage extends Page {

    public FavoritesPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    String restaurantName;

    private By addressArea_xpath = By.xpath("//span[@class='address-area']");
    private By restaurantNameAtFavorites_xpath = By.xpath("//a[@class = 'restaurant-name ys-l']/span/b");
    private By addFavorite_btn = By.xpath("(//div[@class = 'social_action']//b)[1]");
    private By removeFavorite_btn = By.xpath("(//div[@class = 'social_action']//b)[1]");
    private By userInfo = By.id("user-info");
    private By myFavorites_btn = By.xpath("//a[text()='Favorilerim']");
    private By popUp = By.xpath("//button[@class='modal-header-close']");
    private By checkBox = By.xpath("//input[@type = 'checkbox']");
    private By delete_btn = By.xpath("//button[@type = 'submit']");
    private By warningXpath = By.xpath("//p[text()='Henüz favori restoranınız bulunmamaktadır.']");
    private By closedWarning = By.xpath("//div[@id='ui-id-1']//div[@class = 'close-alternative-popup']");
    private By random = By.xpath("//div[@class='ui-widget-overlay ui-front']");
    private By afterLoginPopup = By.xpath("//button[@class = 'modal-header-close']");
    private By noSelectionWarning = By.xpath("//span/strong");
    private By noSelectionConfirm_btn = By.xpath("//button[@class = 'btn confirmButton ys-btn ys-btn-default']");

    private By restaurantSelection(String number) {
        return By.xpath("(//div[@class = 'ys-reslist-items']//div[@class = 'restaurant-display-name']//a)[" + number + "]");
    }

    private By restaurantName(String number) {//span
        return By.xpath("(//div[@class = 'ys-reslist-items']//div[@class = 'restaurant-display-name']//a)[" + number + "]");
    }

    private String restaurantNameAtFavorites() {
        return getText(restaurantNameAtFavorites_xpath);
    }


    public void listRestaurants() {
        click(addressArea_xpath);
    }

    public void selectRestaurant(String restaurantNumber) {
        restaurantName = getText(restaurantName(restaurantNumber));
        click(restaurantSelection(restaurantNumber));
    }

    public void clickAddFavorites() {
        click(addFavorite_btn);
    }

    public void checkMyFavoritesList() {
        click(userInfo);
        click(myFavorites_btn);
        Assert.assertEquals(restaurantName, restaurantNameAtFavorites());
    }

    public void pickRestaurant() {
        click(checkBox);
    }

    public void clickDeleteButton() {
        click(delete_btn);
    }

    public void checkNoFavoritesMessage(String message) {
        Assert.assertEquals(getText(warningXpath), message);
    }

    public void closeAfterLoginPopup() {
        click(afterLoginPopup);
    }

    public void checkPickWarningMessage(String message) {
        Assert.assertEquals(getText(noSelectionWarning), message);
    }

    public void clickOk() {
        click(noSelectionConfirm_btn);
    }


}
