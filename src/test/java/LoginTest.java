import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @DataProvider(name = "provideLogInData")
    public Object [] [] logInData ()
    {
        Object [] [] data = new Object [7] [3];

        data [0] [0] = "baturqa";               data [0] [1] = "asas";          data[0][2] = "hard";
        data [1] [0] = "baturqa@hotmail.com";   data [1] [1] = "fsdfsdf";       data[1][2] = "hard";
        data [2] [0] = "fsdfsdf";               data [2] [1] = "12345asdfg";    data[2][2] = "hard";
        data [3] [0] = "";                      data [3] [1] = "12345asdfg";    data[3][2] = "soft1";
        data [4] [0] = "asdfsdf";               data [4] [1] = "";              data[4][2] = "soft2";
        data [5] [0] = "";                      data [5] [1] = "";              data[5][2] = "soft3";
        data [6] [0] = "baturqa@hotmail.com";   data [6] [1] = "12345asdfg";    data[6][2] = "done";

        return data;
    }

    @Test(description = "LoginTest", priority = 0,dataProvider ="provideLogInData" )
    public void login(String userName, String password, String flag){
        loginPage.goToLoginPage("https://www.yemeksepeti.com/istanbul");
        loginPage.checkLoginFormVisibility();
        loginPage.clearUsername();
        loginPage.setUserName(userName);
        loginPage.clearPassword();
        loginPage.setPassword(password);
        loginPage.submit();
                if(flag=="hard") {
                    loginPage.popupAssertion("Hatalı giriş. Lütfen kullanıcı adı ve şifrenizi kontrol edip tekrar deneyiniz.");
                    loginPage.closeWarningPopup();
                }
                else if(flag=="soft1")
                    loginPage.unLoginWarningAssertion("Lütfen kullanıcı adınızı/e-postanızı girini.");
                else if(flag=="soft2")
                    loginPage.pswLoginWarningAssertion("Lütfen şifrenizi giriniz.");
                else if(flag=="soft3") {
                    loginPage.unLoginWarningAssertion("Lütfen kullanıcı adınızı/e-postanızı giriniz.");
                    loginPage.pswLoginWarningAssertion("Lütfen şifrenizi giriniz.");
                }
                else{
                    loginPage.checkUsername("Spiderman İronman");
                }
    }

}
