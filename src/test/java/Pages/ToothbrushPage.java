package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToothbrushPage {
    WebDriver driver;

    public ToothbrushPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "MainHeader__catalog")
    private WebElement catalog;

    @FindBy(partialLinkText = "Красота и здоровье")
    private WebElement category;

    @FindBy(partialLinkText = "Зубные щетки")
    private WebElement toothbrushCategory;

    @FindBy(className = "ProductCardVerticalLayout__wrapper-cart")
    private WebElement cartAdd;

    @FindBy(name = "input-min")
    private WebElement min;

    @FindBy(name = "input-max")
    private WebElement max;

    @FindBy(className = "UpsaleBasket__header-link")
    private WebElement cartIn;

    public void clickCatalogBtn() {
        catalog.click();
    }

    public void cursorAction() {
        Actions actions = new Actions(driver);
        actions.moveToElement(category).build().perform();
    }

    public void clickToothbrushBtn() {
        toothbrushCategory.click();
    }

    public void inputPrice(Integer minPrice, Integer maxPrice) {
        min.clear();
        min.sendKeys(minPrice.toString());
        max.clear();
        max.sendKeys(maxPrice.toString());
        max.sendKeys(Keys.ENTER);
    }

    public void clickAddInCartBtn() {
        cartAdd.click();
    }

    public void clickInCartBtn() {
        cartIn.click();
    }

}
