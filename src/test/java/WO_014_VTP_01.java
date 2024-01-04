/**
 * Open the URL
 *  Click "WebOrder" button on top bar.
 *  Enter valid username "Inar" and password "Academy".
 *  Click to Login button.
 * Verify the Success of order page opening
 * Click ViewAllOrders button
 * Click ViewAllProducts button
 * Click the Order page
 * Click process changing without anything and see
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class WO_014_VTP_01 extends Hooks {

    @Test
    void verifyTheTransitionOnWebOrderPage() throws InterruptedException {
        //Click WebOrderButton.
        driver.findElement(By.xpath("//class[@href='Weborder']")).click();
        //Enter valid username and password
        driver.findElement(By.id("login-username-input")).sendKeys("Inar");
        driver.findElement(By.id("login-password-input")).sendKeys("Academy");
        //Click to Login button.
        driver.findElement(By.id("login-button")).click();
        //Verify the Success of order page opening
        String headingText = driver.findElement(By.id("welcome-heading")).getText();
        Assertions.assertEquals("welcome-heading",headingText,"Log in process could not make successfully");
        //Click ViewAllOrders button
        driver.findElement(By.xpath("//role[@href='/weborder/view-orders']")).click();
        String heading1 = driver.findElement(By.xpath("//class[contains(text(),'View All Orders')]")).getText();
        Assertions.assertEquals("View All Orders",heading1,"We can not reach the page.");
        //Click ViewAllProducts button
        driver.findElement(By.xpath("//role[@href='/weborder/view-products']")).click();
        String heading2 = driver.findElement(By.xpath("//class[contains(text(),'View All Products']")).getText();
        Assertions.assertEquals("View All Products",heading2,"We can not reach the page.");
        //Click the Order page
        driver.findElement(By.xpath("//role[@href='weborder/order']")).click();
        String heading3 = driver.findElement(By.id("welcome-heading")).getText();
        Assertions.assertEquals("Welcome, Inar!",heading3,"We can not reach the page.");
        //Click process changing without anything and see
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[contains(text(),'Process']")).click();


        js.executeScript("window.scroll(0,-1000)");
        Thread.sleep(3000);

        driver.findElement(By.id("logout-button")).click();

        Assertions.assertEquals("https://test.inar-academy.com/weborder",driver.getCurrentUrl(),"Logout process failed...");








    }
}
