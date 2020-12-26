package Test;

import Pages.CatalogPage;
import Pages.LoginPage;
import Pages.ToothbrushPage;
import Properties.ConfProperties;
import com.sun.org.apache.xml.internal.resolver.Catalog;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ToothbrushTest {
    public static LoginPage loginPage;
    public static ToothbrushPage toothbrushPage;
    public static WebDriver driver;
    public static CatalogPage catalogPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        toothbrushPage = new ToothbrushPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void ToothbrushSearchTest() {
        loginPage.clickLoginBtn();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPage.clickLoginBtn2();
        toothbrushPage.clickCatalogBtn();
        toothbrushPage.cursorAction();
        toothbrushPage.clickToothbrushBtn();
        toothbrushPage.clickToothbrushBtn();
        toothbrushPage.inputPrice(999, 1999);
        toothbrushPage.clickToListBtn();
//        List<WebElement> products = catalogPage.getProductList();
//        Assert.assertFalse(products.isEmpty());
//        catalogPage.addToCart(products.get(products.size() - 2));
//        catalogPage.clickOnCart();
//        catalogPage.clickOnCheckout();
//        catalogPage.selectDelivery();

    }
}
