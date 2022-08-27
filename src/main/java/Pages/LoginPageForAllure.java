package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageForAllure extends BasePage{

    @FindBy(id = "username")
    private WebElement loginElement;

    @FindBy (id = "password")
    private WebElement passwordElement;

    @FindBy (className = "radius")
    private WebElement buttonElement;

    @FindBy(id = "flash")
    private WebElement messageElement;

    public LoginPageForAllure (WebDriver driver) {
        super(driver);
        pageUr1 = "http://the-internet.herokuapp.com/login";
    }
    public void login(User user){
        loginElement.sendKeys(user.getLogin());
        passwordElement.sendKeys(user.getPassword());
        buttonElement.click();
    }

    public String waitButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(messageElement));
        return messageElement.getText();
    }
}

