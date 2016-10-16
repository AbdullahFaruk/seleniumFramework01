package com.paxotech;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by shawon on 10/15/16.
 */
public class ReportTest {


    public static void main (String args[]) {

        WebDriver driver = new FirefoxDriver();
        Reporter.initialize();
        driver.get("http://www.macys.com");

        for (int i = 1; i <=5; i++) {
            WebElement el = driver.findElement(By.id("textfield" + Integer.toString(i)));
            Reporter.report(el.getAttribute("value"), "Text field " + Integer.toString(i));
        }

        Reporter.writeResults();
        driver.close();
    }


}
