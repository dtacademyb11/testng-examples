package tests2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderDemo {



    @DataProvider
   public Object[][] provideData(){

       return new Object[][] {
               {"Hello"},
               {"今天"},
               {"أَبْجَدِيّ"},
               {"999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"},
               {"ЁЂЃЄЅІЇЈЉЊЋЌЍЎЏАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя"},
               {"Hello"},
               {"今天"},
               {"أَبْجَدِيّ"},
               {"999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"},
               {"ЁЂЃЄЅІЇЈЉЊЋЌЍЎЏАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя"}
       };

    }


  @Test (dataProvider = "provideData")
    public void testGoogleSearch(String searchTerm){
        WebDriver driver  = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
//        String searchTerm = "hello";
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains(searchTerm));
        driver.quit();
    }

//    @Test
//    public void testGoogleSearch2(){
//        WebDriver driver  = new ChromeDriver();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
//        driver.manage().window().maximize();
//
//        driver.get("https://www.google.com/");
//        String searchTerm = "今天";
//        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
//        Assert.assertTrue(driver.getTitle().contains(searchTerm));
//        driver.quit();
//    }
}
