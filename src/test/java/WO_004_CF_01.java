import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * 1-) Open the URL.
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the order page.
 * 5-) Select "HomeDecor" from Product dropdown.
 * 6-) Enter "5" as quantity number.
 * 7-) Enter "15" as discount percentage.
 * 8-) Click on the "Calculate" button.
 * 9-) Verify that the total amount is successfully displayed.
 */



public class WO_004_CF_01 extends Hooks {

    @Test
    void verifyCalculationFunctionalityInOrderPage(){
        // 2.Click on weborder link
        WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder'"));
        webOrderLink.click();

        // 3.Enter "Inar" as username and "Academy" password.
        WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
        userNameInputField.sendKeys("Inar");
        WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
        passwordInputField.sendKeys("Academy");

        // 4.Click on the "login" button.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //5.Navigate to the order page.
        WebElement orderPage = driver.findElement(By.xpath("//role[@href='weborder/order']"));
        orderPage.click();

        //6.Select "Home Decor"  from product dropdown
        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='productSelect']"));
        Select dropdownElement = new Select(dropdownMenu);
        dropdownElement.selectByValue("HomeDecor");

        //7-) Enter "5" as quantity number.
        driver.findElement(By.xpath("//input[@id='quantityInput']")).sendKeys("5");

        //8-) Enter "15" as discount percentage.
        driver.findElement(By.xpath("//input[@id='discountInput']")).sendKeys("15");

        //9-) Click on the "Calculate" button.
        driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).click();

        // 10-) Verify that the total amount is successfully displayed.
        String result = driver.findElement(By.xpath("//input[@id='totalInput']")).getAttribute("value");
        String expected = String.valueOf((5 * 150) - ((5 * 150) * 15 / 100.0));
        Assertions.assertEquals(expected, result);



    }

}
