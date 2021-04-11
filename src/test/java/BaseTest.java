import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import page.FavoritesPage;
import page.LoginPage;

import java.io.File;
import java.util.Random;

public class BaseTest {
    int random;

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public LoginPage loginPage;
    public FavoritesPage favoritesPage;

    @Parameters("Browser")
    @BeforeClass
    public void initialization(String Browser) {

        //Set driver locations
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "src/drivers/IEDriverServer.exe");

        //initialize drivers according to browser selection
        if (Browser.equalsIgnoreCase("ch")) {

            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 5);
            driver.manage().window().maximize();
            actions = new Actions(driver);
        } else if (Browser.equalsIgnoreCase("ff")) {
            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, 5);
            driver.manage().window().maximize();
            actions = new Actions(driver);
        } else if (Browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
            wait = new WebDriverWait(driver, 5);
            driver.manage().window().maximize();
            actions = new Actions(driver);
        }

    }

    @BeforeMethod
    public void initialize() {
        Random rand = new Random();
        random = rand.nextInt(5000);
        loginPage = new LoginPage(driver, wait, actions);
        favoritesPage = new FavoritesPage(driver, wait, actions);

    }

    @AfterMethod
    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("C:\\Users\\batur\\IdeaProjects\\avengersAssemble\\Fails\\" + result.getName() + " + " +random+ ".png"));
                System.out.println("Successfully captured a screenshot");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
