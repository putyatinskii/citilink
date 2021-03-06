package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора кнопки входа в аккаунт
     */
    @FindBy(className = "AuthPopup")
    private WebElement loginBtn;
    @FindBy(className = "SignIn__actions")
    private WebElement loginBtn2;
    @FindBy(name = "login")
    private WebElement loginField;
    @FindBy(name = "pass")
    private WebElement passwdField;
    @FindBy(className = "HeaderUserName")
    private WebElement userMenu;
    @FindBy (partialLinkText = "Мой профиль")
    private WebElement profile;
    @FindBy(partialLinkText = "Выйти")
    private WebElement signOutBtn;
    /**
     * метод для ввода логина
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    /**
     * метод для ввода пароля
     */
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void clickLoginBtn2() {
        loginBtn2.click();
    }

    public void clickUserMenu() {
        userMenu.click();
    }
    public void clickProfile() {
        profile.click();
    }

    public String getUserName() {
        return userMenu.getText();
    }

    public void SignOutClick() {
        signOutBtn.click();
    }

}
