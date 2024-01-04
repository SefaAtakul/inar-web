import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1-) Open the URL
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the view all order page.
 * 5-) Click "Add More Data" "4" times.
 * 6-) Click "Check All" button.
 * 7-) Verify all orders selected.
 *
 */




public class WO_010_VAO_01 extends Hooks{


    @Test
    void verifyCheckAllFunctionalityInViewAllOrderPage(){

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
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.xpath("//button[contains(text(),'Add More Data')]")).click();

        }

        // 6-) Click "Check All" button.
        driver.findElement(By.xpath("//button[contains(text(),'Check All')]")).click();

        // 7-) Verify all orders selected.
        for (int i = 1; i < 5; i++) {
            boolean rowCheck = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]/div[1]/input[1]")).isSelected();
            Assertions.assertTrue(rowCheck);
        }

    }





}
