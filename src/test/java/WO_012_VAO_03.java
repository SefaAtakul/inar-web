import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 1-) Open the URL
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the view all order page.
 * 5-) Click "Add More Data" "8" times.
 * 6-) Click 1st, 3rd and 5th orders checkbox's.
 * 7-) Click "Delete All" button.
 * 8-) Verify the orders are deleted.
 */




public class WO_012_VAO_03 extends Hooks{

    @Test
    void verifyDeleteFunctionalityInViewAllOrderPage () throws InterruptedException {
        //2-) Click "WebOrder" button on top bar.
        WebElement webOrderButton = driver.findElement(By.xpath("//class[@href='/weborder']"));
        webOrderButton.click();

        //3-) Enter valid username "Inar" and password "Academy".
        WebElement userNameField = driver.findElement(By.id("login-username-input"));
        WebElement passwordField = driver.findElement(By.id("login-password-input"));
        userNameField.sendKeys("Inar");
        passwordField.sendKeys("Academy");

        // 4.Click on the "login" button.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify that the user is successfully logged in.
        WebElement heading = driver.findElement(By.id("welcome-heading"));
        String headingText = heading.getText();
        Assertions.assertEquals("Welcome, Inar!",headingText,"Heading text is wrong!");

        //4-) Navigate to the view all order page.
        WebElement viewAllOrderPage = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        viewAllOrderPage.click();

        //5-) Click "Add More Data" "4" times.
        for (int i = 0; i < 8; i++) {
            driver.findElement(By.xpath("//button[contains(text(),'Add More Data')]")).click();

        }
        //6-) Click 1st, 3rd and 5th orders checkbox's.
        List<String> nameOfOrdersDeleted = new ArrayList<>();
        for (int i = 1; i <= 5; i += 2) {
            WebElement element = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]/span[1]"));
            nameOfOrdersDeleted.add(element.getText());
        }

        for (int i = 1 ; i <6 ; i+=2) {
            WebElement checkbox = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]/div[1]/input[1]"));
            checkbox.click();
        }


        //7-) Click "Delete All" button.
        driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
        Thread.sleep(3000);

        // 8-) Verify the orders are deleted.
        List<WebElement> orders = driver.findElements(By.xpath(
                "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr/td[2]/span[1]"));
        boolean result = false;
        for (WebElement order : orders) {
            if (nameOfOrdersDeleted.contains(order.getText())) {
                result = true;
            }
        }
        Assertions.assertFalse(result);
    }


    }


