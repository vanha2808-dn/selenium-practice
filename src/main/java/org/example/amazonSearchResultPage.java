package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class amazonSearchResultPage {
    static WebDriver driver = new ChromeDriver();
    private static boolean hadNotification = false;
    public static void main(String args[]) {
        loadAmazonHomePage();
        checkNotification();
        if (hadNotification) {
            dismissNotification();
        }
        searchAdidasOnHomePage();
        locatorElementsAfterSearch();
    }

    private static void loadAmazonHomePage() {
        driver.manage().window().maximize();
        String amazonHomePage = "https://www.amazon.com/";
        try {
            driver.get(amazonHomePage);
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // dismiss notification if any
    private static void checkNotification() {
        try {
            WebElement notif = driver.findElement(By.xpath("//div[@class='glow-toaster-content']"));
            hadNotification = true;
        } catch (Exception e) {
            hadNotification = false;
        }
    }

    private static void dismissNotification() {
        try {
            WebElement notif = driver.findElement(By.xpath("//div[@class='glow-toaster-content']"));
            WebElement dismissButton = notif.findElement(
                    By.xpath("//span[contains(@class,'glow-toaster-button-dismiss')]")
            );
            dismissButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchAdidasOnHomePage () {
        try {
            // Find Search
            WebElement element4 = driver.findElement(
                    By.xpath("//input[@id='twotabsearchtextbox' and @placeholder='Search Amazon']")
            );
            // send keys
            element4.sendKeys("Adidas");
            WebElement searchElement = driver.findElement(
                    By.xpath("//input[@id='nav-search-submit-button']")
            );
            // search
            searchElement.click();
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void locatorElementsAfterSearch() {
        try {

        }
        finally {
            driver.quit();
        }
    }

}
