package com.paxovision.conceptual;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by shawon on 8/13/16.
 */
public class PageUtils {



    protected WebDriver driver = null;


    @BeforeMethod
    public void setUp(){

        /*System.setProperty(
                "webdriver.chrome.driver",
                    "/usr/local/bin/chromedriver");


        driver = new ChromeDriver();*/
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.navigate().to("http://www.saksoff5th.com/");
        driver.navigate().to("http://www.saksfifthavenue.com/");

    }


    public void jsClick(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",  element);
    }

    public void hoverItem(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
    public void hoverItem(By by){
        WebElement element = driver.findElement(by);
        hoverItem(element) ;
    }

    public void hoverItemEx(WebElement element){
        Locatable hoverItem = (Locatable) element;
        Mouse mouse = ((HasInputDevices) driver).getMouse();
        mouse.mouseMove(hoverItem.getCoordinates());
    }
    public void hoverItemEx(By by){
        WebElement element = driver.findElement(by);
        hoverItemEx(element);
    }
    public WebElement waitForElementDisplayed(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    return element;
                }
                return null;
            }
        });
        return foo;
    }

    public void highlightElement(WebElement element) {

        String originalStyle = element.getAttribute("style");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 4px solid red;');", element);
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {}
        js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);

    }

    public boolean isTextPresent(String text) {
        if (driver.getPageSource().contains(text))
            return true;
        else
            return false;
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
