package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_06_Web_Browser_Command_2 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void TC_01_Page_URL() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
        sleepWebBrowser(2);
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepWebBrowser(2);
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/customer/account/create/");

    }

    @Test
    public void TC_02_Page_Title() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Customer Login");
        sleepWebBrowser(2);
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepWebBrowser(2);
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }
    @Test
    public void TC_03_Page_Navigator() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepWebBrowser(2);

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepWebBrowser(2);

        driver.navigate().back();
        sleepWebBrowser(2);

        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().forward();
        sleepWebBrowser(2);


        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");

    }

    @Test
    public void TC_04_Page_Source() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepWebBrowser(2);

        driver.getPageSource().contains("Login or Create an Account");
        sleepWebBrowser(2);

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepWebBrowser(2);

        driver.getPageSource().contains("Create an Account");


    }
    @AfterClass
    public void  afterClass(){
       // driver.quit();
    }
    void sleepWebBrowser(long seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
