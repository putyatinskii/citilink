package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.charset.StandardCharsets;

public class CityPage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    private WebElement newCity;

    public CityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "MainHeader__city")
    private WebElement cityBtn;
    @FindBy(className = "delivery_address")
    private WebElement address;



    public void changeCityClick() {
        cityBtn.click();
    }

    public String getChangeCity() {
        return cityBtn.getText();
    }

    public String getCityName() {
        String cityName = cityBtn.getText();
        return new String(cityName.getBytes(StandardCharsets.UTF_8));
    }

    public String getAddress() {
        return address.getText().split(",")[0];
    }
    public void clickCity(String city_name) {
        newCity = driver.findElement(By.partialLinkText(city_name));
        newCity.click();
    }


}
