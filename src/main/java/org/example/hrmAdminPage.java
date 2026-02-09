package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
            Thread.sleep(10000);
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

            // system user - user mane
            WebElement element4 = driver.findElement(By.xpath("//div[@class='oxd-table-filter-area']//input[@class='oxd-input oxd-input--active']"));

            // user role dropdown list
            WebElement element5 = driver.findElement(By.xpath(
                    "//div[@class='oxd-input-group__label-wrapper' and .//label[normalize-space()='User Role']]"
                            + "/following-sibling::div"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element5).click().perform();
            Thread.sleep(2000);
            WebElement element6 = driver.findElement(By.xpath("//div[@role='option']//span[normalize-space()='Admin']"));
            WebElement element7 = driver.findElement(By.xpath("//div[@role='option']//span[normalize-space()='ESS']"));

            Thread.sleep(2000);
            actions.moveToElement(element5).click().perform();

            // employee name text box
            WebElement element8 = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']//input"));

            // Button reset and search
            WebElement element9 = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']"));
            WebElement element10 = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));

            // tab User management
            WebElement element11 = driver.findElement(
                    By.xpath("//span[@class='oxd-topbar-body-nav-tab-item' and normalize-space()='User Management']")
            );

            // get first row in information table
            WebElement firstUserInfoRow = driver.findElement(
                    By.xpath("//div[@class='oxd-table-card'][1]")
            );

            // get user name and user role in first row

            WebElement element12 = firstUserInfoRow.findElement(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][2]"));
            WebElement element13 = firstUserInfoRow.findElement(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][3]"));

            // icon delete and edit in first row
            WebElement actionCell = firstUserInfoRow.findElement(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][6]"));
            WebElement element14 = actionCell.findElement(By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space']\n" +
                    "       [.//i[@class='oxd-icon bi-trash']]"));
            WebElement element15 = actionCell.findElement(By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space']\n" +
                    "       [.//i[@class='oxd-icon bi-pencil-fill']]"));
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
