package tests2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SettingTimeout {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




    @Test (timeOut = 5000L)
    public void testUsername() throws InterruptedException {



        // Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        // Login with valid credentials
        String username = "Tester";
        String pass = "test";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, pass, Keys.ENTER);
        // Verify that the username

        Thread.sleep(10000);
        String actualUsername= driver.findElement(By.xpath("//div[@class='login_info']")).getText();

        Assert.assertTrue(actualUsername.contains(username));


    }

    @Test ()
    public void testUsername2() throws InterruptedException {



        // Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        // Login with valid credentials
        String username = "Tester";
        String pass = "test";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, pass, Keys.ENTER);
        // Verify that the username

        Thread.sleep(10000);
        String actualUsername= driver.findElement(By.xpath("//div[@class='login_info']")).getText();

        Assert.assertTrue(actualUsername.contains(username));


    }


}
