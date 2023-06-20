package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicDemo {




    // Test case - a collection of steps to validate an expected behavior of an application
    // Usually a test case consists of id, pre-conditions, test steps, expected and actual behavior, result of comparison


    // Launch the browser
    // Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
    // Login with valid credentials
    // Verify that the username
    // Quit the browser


//    public static void main(String[] args) {
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().window().maximize();
//
//        // Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
//        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
//        // Login with valid credentials
//        String username = "Tester";
//        String pass = "test";
//        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, pass, Keys.ENTER);
//        // Verify that the username
//
//        String actualUsername= driver.findElement(By.xpath("//div[@class='login_info']")).getText();
//
//        Assert.assertTrue(actualUsername.contains(username));
//        driver.quit();
//
//
//
//
//    }
   WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
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

    @Test
    public void testViewAllProductsLink(){



        // Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        // Login with valid credentials
        String username = "Tester";
        String pass = "test";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, pass, Keys.ENTER);
        // Verify that the link is displayed

        WebElement link= driver.findElement(By.linkText("View all products"));

        Assert.assertTrue(link.isDisplayed());


    }

    @Test
    public void testOrderLink(){



        // Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        // Login with valid credentials
        String username = "Tester";
        String pass = "test";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, pass, Keys.ENTER);
        // Verify that the link is displayed

        WebElement link= driver.findElement(By.linkText("Order"));

        Assert.assertTrue(link.isDisplayed());


    }


}
