package TestForAllure;

import Pages.LoginPageForAllure;
import Pages.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPasswordSteps {

    private WebDriver driver;

    public LoginPasswordSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check login: '{login}' and password: '{password}'")
    public String test (String login, String password) {
        User user = new User(login, password);
        LoginPageForAllure loginPageForAllure = new LoginPageForAllure(driver);
        loginPageForAllure.navigatore();
        loginPageForAllure.login(user);
        return loginPageForAllure.waitButton();
    }
}

