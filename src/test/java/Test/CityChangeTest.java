package Test;

import Pages.CityPage;
import Pages.LoginPage;
import Properties.ConfProperties;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class CityChangeTest {
    public static LoginPage loginPage;
    public static CityPage cityPage;
    public static WebDriver driver;
    private String city;

    public CityChangeTest(String city)
    {
        this.city = city;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> GetParams()
    {
        return Arrays.asList(new Object[][]{
                { "Ейск" },
                { "Абакан" },
                { "Азов" },
        });
    }

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
        cityPage.clickCity(city);
        String cur_city = cityPage.getCityName();
        Assert.assertEquals(city, cur_city);
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
        //String cityOnSite = cityPage.getChangeCity(
        try {
            Assert.assertEquals(cur_city, cityInAddress);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            loginPage.clickUserMenu();
            loginPage.SignOutClick();
        }
    }

    @AfterClass
    public static void ExitDriver()
    {
        driver.quit();
    }
}
