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
      Assert.assertTrue( driver.findElement(By.cssSelector("input#mail")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("input#under_18")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.cssSelector("textarea#edu")).isDisplayed());
        Assert.assertFalse( driver.findElement(By.xpath("//h5[text()='User Name']")).isDisplayed());
    }

    @Test
    public void TC_02_Enable() {

    }
    @Test
    public void TC_03_Selected() {



    }


    @AfterClass
    public void afterClass() {
     //   driver.quit();
    }
}
