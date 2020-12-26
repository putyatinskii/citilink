package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CatalogPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    private WebElement newCity;

    @FindBy(className = "popup-basket__close-btn")
    private WebElement popupCartBtn;

    @FindBy(className = "cart")
    private WebElement cartBtn;

    @FindBy(xpath = "//*[contains(text(), \"Оформить заказ\")]")
    private WebElement makeAnOrder;

    @FindBy(xpath = "//tr[./td[contains(text(), \"Доставка\")]]")
    private WebElement deliveryPriceBlock;

    @FindBy(xpath = "//*[contains(text(), \"Далее\")]")
    private WebElement nextBtn;

    @FindBy(className = "for_delivery_type_0")
    private WebElement forDeliveryBtn;

    @FindBy(xpath = "//*[@id=\"delivery_save\"]")
    private WebElement saveDeliveryBtn;

    public CatalogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<WebElement> getProductList() {
        List<WebElement> products = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ProductCardVerticalLayout ProductCardVertical__layout")));
        return products;
    }

    public void addToCart(WebElement product) {
        product.findElement(By.className("add_to_cart")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("popup-basket__close-btn")));
        popupCartBtn.click();
    }

    public void clickOnCart() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("cart")));
        cartBtn.click();
    }

    public void clickOnCheckout() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), \"Оформить заказ\")]")));
        makeAnOrder.click();
    }

    public void selectDelivery() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), \"Далее\")]")));
        nextBtn.click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("for_delivery_type_0")));
        forDeliveryBtn.click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"delivery_save\"]")));
        saveDeliveryBtn.click();
    }
}



