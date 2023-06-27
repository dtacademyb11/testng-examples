package tests2;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DataProviderDemo2 {




    @DataProvider (name = "customers")
    public Object[][] getData(){

        return  new Object[][] {
                {"John", "Doe", "123 Main St", "Springfield", "VA", "22150", "3216563217356125"},
                {"Jane", "Smith", "123 Fairfax St", "Fairfax", "VA", "22301", "5437865786875432"},
                {"Justin", "Timberlake", "123 Alexandria Ct", "Alexandria", "VA", "22301", "63278647367834234"}
        };
    }


    @DataProvider (name = "customersFile")
    public Object[][] getData2(){

        return Utility.readFromCSVFile("customers.csv");
    }






    @Test (dataProvider = "customersFile")
    public void testUsername(String firstName,
                             String lastName,
                             String streetAddress,
                             String city,
                             String state,
                             String zip,
                             String cardNumber ) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();



        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        // Login with valid credentials
        String username = "Tester";
        String pass = "test";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, pass, Keys.ENTER);


        driver.findElement(By.linkText("Order")).click();
        int quantity = (new Random().nextInt(100));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity+"");
        Thread.sleep(1000);






        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(firstName+" "+lastName);


        //Faker faker = new Faker();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(streetAddress);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);


        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));

        radioButtons.get(new Random().nextInt(3)).click();




        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNumber);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("01/24");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();


        Assert.assertTrue(driver.getPageSource().contains("New order has been successfully added."));


        driver.quit();


    }
}
