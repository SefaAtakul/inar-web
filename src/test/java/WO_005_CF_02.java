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
 * 5-) Select "ScreenSaver" from Product dropdown.
 * 6-) Leave blank the quantity box.
 * 7-) Enter "20" as discount percentage.
 * 8-) Click on the "Calculate" button.
 * 9-) Verify the invalid Quantity error message is displayed.
 */


public class WO_005_CF_02 extends Hooks {
    @Test
    void verifyCalculationFunctionalityInOrderPageWithInvalidInput() {
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

        //6-) Select "ScreenSaver" from Product dropdown.
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='productSelect']"));
        Select dropDownElement = new Select(dropDownMenu);
        dropDownElement.selectByValue("ScreenSaver");

        //7-) Leave blank the quantity box.
        driver.findElement(By.xpath("//input[@id='quantityInput']")).sendKeys("0");

        //8-) Enter "20" as discount percentage.
        driver.findElement(By.xpath("//input[@id='discountInput']")).sendKeys("20");

        //9-) Click on the "Calculate" button.
        driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).click();

        //10-)Verify the invalid Quantity error message is displayed.
        try {
            driver.findElement(By.xpath("//em[contains(text(),\"Field 'Quantity' must be greater than zero.\")]"));
        } catch (Exception ex) {
            Assertions.fail();
        }
    }
}
