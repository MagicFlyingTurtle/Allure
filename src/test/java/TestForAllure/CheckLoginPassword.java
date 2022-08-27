package TestForAllure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckLoginPassword {

    private WebDriver driver;
    @FindBy(id = "flash")
    private WebElement messageElement;

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(description = "Correct login and password")
    public void Test() {
        LoginPasswordSteps steps = new LoginPasswordSteps(driver);
        Assert.assertEquals(steps.test("tomsmith", "SuperSecretPassword!"),"You logged into a secure area!\n×");
    }

    @Test
    public void WrongLogin() {
        LoginPasswordSteps steps = new LoginPasswordSteps(driver);
        Assert.assertEquals(steps.test("bla-bla", "SuperSecretPassword!"),"Your username is invalid!\n×");
    }

    @Test
    public void WrongPassword() {
        LoginPasswordSteps steps = new LoginPasswordSteps(driver);
        Assert.assertEquals(steps.test("tomsmith", "bla-bla"),"Your password is invalid!\n×");
    }
}


