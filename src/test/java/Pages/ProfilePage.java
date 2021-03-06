package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProfilePage {
    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "delivery_address")
    private WebElement deliveryAddress;

    @FindBy(className = "MainHeader__city")
    private WebElement currentCity;

    public String getDeliveryAddress(){
        return deliveryAddress.getText().split(",")[0];
    }

    public String getCurrentCityityName(){
        return currentCity.getText();
    }

}
