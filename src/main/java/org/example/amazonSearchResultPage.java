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
            Thread.sleep(5000);
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
            // element cart
            WebElement element5 = driver.findElement(
                    By.xpath("//a[@id='nav-cart']")
            );

            // numbers of result element
            WebElement element13 = driver.findElement(
                    By.xpath("//div[@class='sg-col-inner']//span[1]")
            );

            // select box gender <man> on right menu
            WebElement genderOptions = driver.findElement(
                    By.xpath("//div[@id='gender']")
            );

            WebElement element11 = genderOptions.findElement(
                    By.xpath("//span[normalize-space()='Men']/preceding-sibling::div//i")
            );

           // Product Information of results
            WebElement product = driver.findElement(
                    By.xpath("//div[@role='listitem' and @data-cel-widget='search_result_1']")
            );

            // Thumbnail
            WebElement element1 = product.findElement(
                    By.xpath("//div[contains(@class, 's-image-square-aspect')]")
            );

            // Name
            WebElement element10 = product.findElement(
                    By.xpath("//div[@data-cy='title-recipe']//span[contains(@class, 'a-size-base-plus')]")
            );
            // Subname
            WebElement element8 = product.findElement(
                    By.xpath("//div[@data-cy='title-recipe']//h2[contains(@class, 'a-size-base-plus')]//span")
            );
            System.out.println(element8.getText());

            // delivery date
            WebElement element9 = product.findElement(
                    By.xpath("//div[contains(@class, 'udm-primary-delivery-message')]//span[@class='a-text-bold']")
            );
            System.out.println(element9.getText());

            // Price
            WebElement element3 = product.findElement(
                    By.xpath("//span[@class='a-price-whole']")
            );
            System.out.println(element3.getText());

            // Original Price
            // Because not all the time the product is sole. so if it not for saling, the original price is the price
            // -> not found this below the element
            WebElement element2 = product.findElement(
                    By.xpath("//span[normalize-space()='List:']/parent::div")
            );
            System.out.println(element2.getText());

            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Không có giamr giá");
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
