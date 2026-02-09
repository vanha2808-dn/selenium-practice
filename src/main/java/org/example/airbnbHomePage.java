package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class airbnbHomePage {
    static WebDriver driver = new ChromeDriver();
    public static void main(String arg[]) {
        checkLocatorsOnHomePage();

    }

    private static void checkLocatorsOnHomePage () {
        driver.manage().window().maximize();
        String airbnbHomePage = "https://demo5.cybersoft.edu.vn/";
        try {
            driver.get(airbnbHomePage);
            Thread.sleep(7000);

            // Navigation tab elements
            WebElement element1 = driver.findElement(By.xpath("//a[@class='flex items-center space-x-3 rtl:space-x-reverse active']"));
            WebElement element2 = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
            WebElement element3= driver.findElement(By.xpath("//a[normalize-space()='About']"));
            WebElement element4 = driver.findElement(By.xpath("//div[@class='flex items-center md:order-2 space-x-3 md:space-x-0 rtl:space-x-reverse relative']"));

            // Destination elements
            //-> make container visible by scroll
            WebElement container = driver.findElement(
                    By.xpath("//div[@class='grid grid-cols-12 smm:grid-cols-1 border-2 border-gray-300 md:rounded-full']//parent::div")
            );
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", container);

            // destination, date, customer
            WebElement element5 = container.findElement(By.xpath("//p[normalize-space()='Địa điểm']//parent::div"));
            WebElement element6 = container.findElement(By.xpath("//div[contains(@class,'col-span-4') and contains(@class,'flex-col') and contains(@class,'relative')]"));
            WebElement element7 = container.findElement(By.xpath("//div[contains(@class,'col-span-3') and contains(@class,'relative') and contains(@class,'gap-3')]"));

            // add quality of customer
            // click "Thêm khách"
            WebElement customerEditQuality =
                    driver.findElement(By.xpath("//p[text()='Thêm khách']"));
            customerEditQuality.click();
            Thread.sleep(5000);
            // add and minus button
            WebElement element8 = element7.findElement(By.xpath("//button[normalize-space()='+']"));
            WebElement element9 = element7.findElement(By.xpath("//button[normalize-space()='-']"));

            // destination option1 -- Ho Chi Minh
            WebElement element10 = driver.findElement(By.xpath("//div[@class='container space-y-12']//a[1]"));

            // destination2 - get name of Can Tho
            WebElement element11 = driver.findElement(By.xpath("//div[@class='container space-y-12']//a[2]//h2[@class='font-bold']"));

            // destination 3 - tripDurationHours of Nha Trang
            WebElement element14 = driver.findElement(By.xpath("//div[@class='container space-y-12']//a[3]//p[contains(@class, 'text-sm')]"));

            // Accomodation type - loại nơi ở element
            WebElement element12 = driver.findElement(By.xpath("//div[contains(@class,'container') and contains(@class,'py-10 relative')]//button[normalize-space()='Loại nơi ở']"));
            WebElement element13 = driver.findElement(By.xpath("//div[contains(@class,'container') and contains(@class,'py-10 relative')]//button[normalize-space()='Giá']"));

            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
