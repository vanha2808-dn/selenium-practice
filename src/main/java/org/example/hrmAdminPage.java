package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class hrmAdminPage {
    static WebDriver driver = new ChromeDriver();
    public static void main(String arg[]) {
        loginIntoAdminPage();
        navigationAdmin();
        locatorElements();
    }

    private static void loginIntoAdminPage () {
        driver.manage().window().maximize();
        String loginHtml = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        try {
            driver.get(loginHtml);
            Thread.sleep(5000);
            WebElement userNameTextbox = driver.findElement(By.xpath("//input[@name='username']"));
            userNameTextbox.sendKeys("Admin");
            WebElement passwordTextbox = driver.findElement(By.xpath("//input[@name='password']"));
            passwordTextbox.sendKeys("admin123");
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void navigationAdmin() {
        try {
            Thread.sleep(15000);
            WebElement adminMenuItem = driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));

            adminMenuItem.click();
            Thread.sleep(5000);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void locatorElements() {
        try {
            // menu item elements
            WebElement element1 = driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));
            WebElement element2 = driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
            WebElement element3 = driver.findElement(By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']"));
            // system user elements
            WebElement element4 = driver.findElement(By.xpath("//div[@class='oxd-table-filter-area']//input[@class='oxd-input oxd-input--active']"));


            Thread.sleep(5000);
           



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
