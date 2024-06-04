package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebElement_Commands_02 {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        Assert.assertTrue(driver.findElement(By.cssSelector("input#mail")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("textarea#edu")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//h5[text()='User Name']")).isDisplayed());
    }

    @Test
    public void TC_02_Enable() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.cssSelector("input#mail")).isEnabled()) {
            System.out.println("Email TextBox is Enable");
        } else {
            System.out.println("Email TextBox is Disable");
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("input#mail")).isEnabled());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isEnabled());
        Assert.assertTrue(driver.findElement(By.cssSelector("textarea#edu")).isEnabled());

    }

    @Test
    public void TC_03_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.cssSelector("input#under_18")).click();
        if (driver.findElement(By.cssSelector("input#under_18")).isSelected()) {
            System.out.println("Email TextBox is Selected");
        } else {
            System.out.println("Email TextBox is De-Selected");
        }

    }

    @Test
    public void TC_04_MainChimp() {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("nguyenthuyth@gmail.com");
        //Case 1 Number
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.8 -char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check completed")).isDisplayed());

    }

    @Test
    public void TC_05_Login_Empty() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepWebBrowser(2);
        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(), "This is a required field.");
    }

    @Test
    public void TC_05_Login_Invalid_Email() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepWebBrowser(2);
        driver.findElement(By.cssSelector("input#email")).sendKeys("123434234@12312.12312");
        driver.findElement(By.cssSelector("input#password")).sendKeys("123456");

        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void TC_05_Login_Low_Password() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepWebBrowser(2);
        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123");

        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_05_Login_Incorrect() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepWebBrowser(2);
        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123123123");

        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span[contains(text(),'Invalid')]")).getText(), "Invalid login or password.");
    }

    @Test
    public void TC_06_Login_PortalHND() {
        driver.get("https://portal-hnd-hanoi-dev.vivas.vn");
        driver.findElement(By.cssSelector("input#tcctxh-login-field-name")).sendKeys("admin_hanoi");
        driver.findElement(By.cssSelector("input#tcctxh-login-field-password")).sendKeys("Vivas@123");
        driver.findElement(By.cssSelector("button#tcctxh-login-button-login")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.Vue-Toastification__toast-body")).getText(), "Tài khoản hoặc mật khẩu không đúng");
    }
    @Test
    public void TC_06_Login_ClickCreateTypeQuestion() {
        driver.get("https://portal-hnd-nghean-stag.vivas.vn");
        driver.findElement(By.cssSelector("input#tcctxh-login-field-name")).sendKeys("admin_nghean");
        driver.findElement(By.cssSelector("input#tcctxh-login-field-password")).sendKeys("Vivas@123");
        driver.findElement(By.cssSelector("button#tcctxh-login-button-login")).click();
       // Assert.assertEquals(driver.findElement(By.cssSelector("div.Vue-Toastification__toast-body")).getText(), "Tài khoản hoặc mật khẩu không đúng");
        sleepWebBrowser(2);
        driver.findElement(By.xpath("//span[contains(text(),'Quản lý Hỏi')]")).click();
        sleepWebBrowser(5);
        driver.findElement(By.xpath("//span[contains(text(),'Loại hỏi')]")).click();
        sleepWebBrowser(3);
        driver.findElement(By.cssSelector("button#faq-create-button")).click();

    }


    @AfterClass
    public void afterClass() {
        //   driver.quit();
    }

    void sleepWebBrowser(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
