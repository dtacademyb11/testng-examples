package tests2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DependencyTest {


    WebDriver driver;

    @Test ()
    public void testLogin(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        // Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        // Login with valid credentials
        String username = "Tester";
        String pass = "testsc"; //wrong password
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, pass, Keys.ENTER);


        Assert.assertEquals(driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");


    }

    @Test (dependsOnMethods = {"testLogin", "testDeleteSelectedButton"})
    public void testLogOutLink(){
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
    }

    @Test (dependsOnMethods = "testLogin")
    public void testDeleteSelectedButton(){
        Assert.assertTrue(driver.findElement(By.id("ctl00_MainContent_btnDelete")).isDisplayed());
    }



}
