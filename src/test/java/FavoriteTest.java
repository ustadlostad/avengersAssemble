import listeners.RetryAnalyzer;
import org.testng.annotations.Test;

import java.util.Random;


public class FavoriteTest extends BaseTest {

    public String random() {
        Random rand = new Random();
        int rand_int = rand.nextInt(5);
        return Integer.toString(rand_int);
    }

    public void login() {
        loginPage.goToLoginPage("https://www.yemeksepeti.com/istanbul");
        loginPage.checkLoginFormVisibility();
        loginPage.clearUsername();
        loginPage.setUserName("baturqa@hotmail.com");
        loginPage.clearPassword();
        loginPage.setPassword("12345asdfg");
        loginPage.submit();
    }

    @Test(description = "Add favorite", priority = 0)
    public void addFavorites() {
        login();
        favoritesPage.closeAfterLoginPopup();
        favoritesPage.listRestaurants();
        favoritesPage.selectRestaurant(random());
        favoritesPage.clickAddFavorites();
        favoritesPage.checkMyFavoritesList();

    }

    @Test(description = "Try to delete wo selection", priority = 1)
    public void deleteWoSelection() {
        favoritesPage.clickDeleteButton();
        favoritesPage.checkPickWarningMessage("Lütfen favorilerinizden çıkartmak istediğiniz restoranı seçiniz.");
        favoritesPage.clickOk();
    }

    @Test(description = "Delete Favorite", priority = 2)
    public void deleteFavorite() {
        favoritesPage.refreshPage();
        favoritesPage.pickRestaurant();
        favoritesPage.clickDeleteButton();
        favoritesPage.checkNoFavoritesMessage("Henüz favori restoranınız bulunmamaktadır.");
    }

}
