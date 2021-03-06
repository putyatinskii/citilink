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

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    /**
     * осуществление первоначальной настройки
     */

    public static LoginPage loginPage;
    public static WebDriver driver;
    public static CityPage cityPage;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage = new LoginPage(driver);
        cityPage = new CityPage(driver);
    }
    @Test
    public void loginTest() {
        loginPage.clickLoginBtn();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPage.clickLoginBtn2();
        String user = loginPage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("name"), user);
    }

    @AfterClass
    public static void ExitDriver() {
        driver.quit();
    }
}