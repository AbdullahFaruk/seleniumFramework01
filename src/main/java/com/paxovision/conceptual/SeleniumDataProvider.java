package com.paxovision.conceptual;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by shawon on 5/15/16.
 */
public class SeleniumDataProvider {


         protected WebDriver driver = null;


    @Before
    public void setUp(){

        System.setProperty(
                "webdriver.chrome.driver",
                    "/usr/local/bin/chromedriver");


        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://www.saksoff5th.com/");

    }



    @Test
    public void firstTest(){

        String pageTitle = driver.getTitle();

        if (pageTitle.contentEquals("Saks OFF 5TH Fashion Outlet: Discount Designer Handbags, Shoes, Dresses, Sunglasses & More")){
            System.out.println(pageTitle + " \n Test Case Passed");
        }else{
            System.out.println("Test Case Failed");
        }
        //System.out.println(pageTitle);

    }

    private void highlightElement(WebElement element) {

        String originalStyle = element.getAttribute("style");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {}
        js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);

    }


    @Test
    public void secondTest() throws Exception{
        WebElement searchTextBox = driver.findElement(By.className("o5-search-form-input"));
        searchTextBox.clear();
        highlightElement(searchTextBox);
        searchTextBox.sendKeys("Shirts");
        highlightElement(searchTextBox);
        WebElement submitSearch = driver.findElement(By.className("o5-search-form-submit"));
        highlightElement(submitSearch);
        submitSearch.submit();
        Thread.sleep(1000);

    }


    public boolean isTextPresent(String text) {
        if (driver.getPageSource().contains(text))
            return true;
        else
            return false;
    }


    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }



}
