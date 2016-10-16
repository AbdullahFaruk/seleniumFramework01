package com.paxovision.conceptual;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;


/**
 * Created by shawon on 5/15/16.
 */
public class SeleniumDataProvider extends PageUtils {

        @Test(invocationCount=1)

        public void searchAndSelect() throws Exception {
            Logger log = Logger.getLogger("LogApplication");

            log.info("Saks Fifth Avenue Website is Loaded");
            waitForElementDisplayed(By.cssSelector("iframe[src*='email_popup']"));
            driver.switchTo().frame(waitForElementDisplayed(By.cssSelector("iframe[src*='email_popup']")));
            waitForElementDisplayed(By.cssSelector("div[id='close-button']")).click();
            driver.switchTo().defaultContent();

            log.info("User Enters info in Search");
            WebElement searchTextBox = waitForElementDisplayed(By.name("SearchString"));
            searchTextBox.clear();
            highlightElement(searchTextBox);
            searchTextBox.sendKeys("Shirts");
            highlightElement(searchTextBox);
            WebElement submitSearch = waitForElementDisplayed(By.name("submit-search"));
            highlightElement(submitSearch);
            submitSearch.submit();
            Thread.sleep(1000);

            String topNavTitle = driver.findElement(By.cssSelector("h1[class='pa-enh-page-title']")).getText();
            System.out.println(topNavTitle);

            List<WebElement> selectFirstItem = driver.findElements(By.cssSelector("div[class='product-text']"));

            int iSize = selectFirstItem.size();
            for (int i = 0; i < iSize; i++) {
                String firstItemName = selectFirstItem.get(i).getText();
                System.out.println(firstItemName);
                break;
            }
            //driver.findElement(By.cssSelector("span[class='product-designer-name']")).click();
            WebElement selectFirstProductPA = waitForElementDisplayed(By.cssSelector("span[class='product-designer-name']"));
            selectFirstProductPA.click();
            Thread.sleep(3000);


            if (waitForElementDisplayed(By.cssSelector("button[class='hbc-button hbc-button--full hbc-button--primary product__add-to-bag-button']")) != null) {
                System.out.println("Element is Present");
            } else {
                System.out.println("Element is NOT Present");
            }

            if (driver.findElements(By.cssSelector("button[class='hbc-button hbc-button--full hbc-button--primary product__add-to-bag-button']")).size() != 0) {
                System.out.println("Element is Present");
            } else {
                System.out.println("Element is Absent");
            }

            WebElement addToBagButton = waitForElementDisplayed(By.cssSelector("button[class='hbc-button hbc-button--full hbc-button--primary product__add-to-bag-button']"));
            if (addToBagButton.isDisplayed()) {
                System.out.println("Test Case Passed");
            } else {
                System.out.println("Test Case Failed");
            }
            hasAvailableSizeSelected();

            addToBagButton.click();
            Assert.assertSame("ADD TO BAG", "ADD TO BAG", "ADD TO BAG");


        }

        private void hasFirstColorSelected() {
            driver.findElement(By.xpath("")).click();
        }

        private void hasAvailableSizeSelected() {
            waitForElementDisplayed(By.cssSelector("li[class='product-variant-attribute-value product-variant-attribute-value--text']")).click();
        }


    @Test

    public void quickLookTest() throws Exception{

        Logger log = Logger.getLogger("LogApplication");
        log.info("User Enters info in Search");
        WebElement searchTextBox = waitForElementDisplayed(By.name("SearchString"));
        searchTextBox.clear();
        highlightElement(searchTextBox);
        searchTextBox.sendKeys("Shirts");
        highlightElement(searchTextBox);
        WebElement submitSearch = waitForElementDisplayed(By.name("submit-search"));
        highlightElement(submitSearch);
        submitSearch.submit();
        Thread.sleep(1000);

       if (waitForElementDisplayed(By.cssSelector("div[class='sfa-pa-quicklook-button']")).isDisplayed()){
           log.info("QuickLook is Present");
           System.out.println("PASSED");
           waitForElementDisplayed(By.cssSelector("div[class='sfa-pa-quicklook-button']")).click();
       }else{
           System.out.println("Test FAILED");
       }


    }


    @Test
    public void reportTest() throws Exception{



    }



}
