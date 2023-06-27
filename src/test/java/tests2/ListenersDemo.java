package tests2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Listeners (MyListener.class)
public class ListenersDemo {


    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) throws IOException {

        if(testResult.getStatus() == ITestResult.FAILURE){
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("target/screenshots/screenshot"+System.currentTimeMillis()+".png"));
        }



        driver.quit();
    }




    @Test
    public void testUsername(){



        // Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        // Login with valid credentials
        String username = "Tester";
        String pass = "test";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, pass, Keys.ENTER);
        // Verify that the username

        String actualUsername= driver.findElement(By.xpath("//div[@class='login_info']")).getText();

        Assert.assertTrue(actualUsername.contains(username));


    }

    @Test
    public void testViewAllOrdersLink(){


        // Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        // Login with valid credentials
        String username = "Tester";
        String pass = "test";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, pass, Keys.ENTER);
        // Verify that the link is displayed

        WebElement link= driver.findElement(By.linkText("View all ordersdscds"));

        Assert.assertTrue(link.isDisplayed());

    }
}
