package Test;

import Pages.CityPage;
import Pages.LoginPage;
import Properties.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class CityChangeTest {
    public static LoginPage loginPage;
    public static CityPage cityPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        cityPage = new CityPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void changeCityTest() {
        cityPage.changeCityClick();
        cityPage.clickCity(ConfProperties.getProperty("city"));
        String city = cityPage.getCityName();
        Assert.assertEquals(ConfProperties.getProperty("city"), city);
        loginPage.clickLoginBtn();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPage.clickLoginBtn2();
        loginPage.clickUserMenu();
        loginPage.clickProfile();
        String cityInAddress = cityPage.getAddress();
        Assert.assertEquals(city, cityInAddress);
    }

    @AfterClass
    public static void ExitDriver()
    {
        driver.quit();
    }
}
