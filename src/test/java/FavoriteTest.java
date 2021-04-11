import org.testng.annotations.Test;

public class FavoriteTest extends BaseTest {

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
        favoritesPage.selectRestaurant("1");
        favoritesPage.clickAddFavorites();
        favoritesPage.refreshPage();
        favoritesPage.checkMyFavoritesList();

    }

    @Test(description = "Try to delete wo selection", priority = 1)
    public void deleteWoSelection(){
        favoritesPage.refreshPage();
        favoritesPage.clickDeleteButton();
        favoritesPage.checkPickWarningMessage("Lütfen favorilerinizden çıkartmak istediğiniz restoranı seçiniz.");
        favoritesPage.clickOk();
    }

    @Test(description = "Delete Favorite", priority = 2 )
    public void deleteFavorite() {
        favoritesPage.refreshPage();
        favoritesPage.pickRestaurant();
        favoritesPage.clickDeleteButton();
        favoritesPage.refreshPage();
        favoritesPage.checkNoFavoritesMessage("Henüz favori restoranınız bulunmamaktadır.");
    }


/*
    @Test(description = "Add Multiple Favorite", priority = 2)
    public void addMultipleFavorite() {
        favoritesPage.listRestaurants();
        favoritesPage.selectRestaurant("1");
        favoritesPage.clickAddFavorites();
        favoritesPage.navigateBack();
        favoritesPage.selectRestaurant("2");
        favoritesPage.clickAddFavorites();
        favoritesPage.checkMyFavoritesList();
    }

    @Test(description = "Delete Multiple Favorite", priority = 3)
    public void deleteMultipleFavorite() {

    }
*/
}
