package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Relative_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Relative() {
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        By loginButtonBy= By.cssSelector("button.login-button");
        WebElement loginButtonElement=driver.findElement(By.cssSelector("button.login-button"));

        //Remember Me checkbox
        By rememberMeCheckBoxBy = By.id("RememberMe");

        //Forgot password link

        WebElement forgetPasswordElement = driver.findElement(By.cssSelector("span.forgot-password"));

        //Password textbox
        By passwordTextBoxBy = By.id("input#Password");


        //GUI (location/position)
        WebElement reMemberMeTextElement=driver.findElement(RelativeLocator.with(By.tagName("label")).
                above(loginButtonBy).
                toRightOf(rememberMeCheckBoxBy).
                toLeftOf(forgetPasswordElement)
                .below(passwordTextBoxBy)
                .near(forgetPasswordElement));
        System.out.println( reMemberMeTextElement.getText());

        //Forgot password link
        

    }

    @Test
    public void TC_02_() {
        driver.get("https://portal-hnd.vivas.vn/auth/login");
      driver.findElement(By.id("tcctxh-login-field-name")).sendKeys("Admin");
      driver.findElement(By.id("tcctxh-login-field-password")).sendKeys("Vivas@123");
      driver.findElement(By.id("tcctxh-login-button-login")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
