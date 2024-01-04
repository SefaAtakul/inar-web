import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WO_013_VAO_04 extends Hooks{
    List<String> orderInformation = new ArrayList<>();
    @Test
    void verifyPaymentInformation() throws InterruptedException {
        // Name
        orderInformation.add("King");
        // Prod name
        orderInformation.add("MyMoney");
        // Quantity
        orderInformation.add("8");
        // Date
        orderInformation.add(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now()));
        // Street
        orderInformation.add("1100 Royal Ave.");
        // City
        orderInformation.add("United");
        //State
        orderInformation.add("Kingdom");
        //Valid ZipCode
        orderInformation.add("78701");
        //ValidCardType
        orderInformation.add("Visa");
        //ValidCardNumber(Visa starts with : 4,Mastercard starts with : 5,American express starts with:34,37)
        orderInformation.add("4938281746192845");
        //Valid Card Expire Date(format must be mm/yy)
        orderInformation.add("11/28");
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
        //Click the Order page
        driver.findElement(By.xpath("//role[@href='weborder/order']")).click();
        String heading3 = driver.findElement(By.id("welcome-heading")).getText();
        Assertions.assertEquals("Welcome, Inar!",heading3,"We can not reach the page.");
        // 5-) Select "MyMoney" from Product dropdown.
        WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
        Select productDropdown = new Select(productDropdownElement);

        productDropdown.selectByVisibleText(orderInformation.get(1));
        // 6-) Enter "8" as quantity number.
        WebElement quantityInputField =driver.findElement(By.id("quantityInput"));
        quantityInputField.sendKeys(orderInformation.get(2));

        // 7-)Enter "20" as discount percentage.
        WebElement discountInputField = driver.findElement(By.id("discountInput"));
        discountInputField.sendKeys("20");

        // 8-) Click on the "Calculate" button.
        WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));
        calculateButton.click();

        //-) Enter Costumer Infos
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement streetField = driver.findElement(By.id("street"));
        WebElement cityField = driver.findElement(By.id("city"));
        WebElement stateField = driver.findElement(By.id("state"));
        WebElement zipCodeField = driver.findElement(By.id("zip"));

        nameField.sendKeys(orderInformation.get(0));
        streetField.sendKeys(orderInformation.get(4));
        cityField.sendKeys(orderInformation.get(5));
        stateField.sendKeys(orderInformation.get(6));
        zipCodeField.sendKeys(orderInformation.get(7));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)");

        Thread.sleep(3000);

        //Enter payment infos
        //WebElement visaTypeCheckbox = driver.findElement(By.id("visa"));
        //visaTypeCheckbox.click();

        WebElement cardNumberField = driver.findElement(By.id("cardNumber"));
        cardNumberField.sendKeys(orderInformation.get(9));

        WebElement expiryDateField = driver.findElement(By.id("expiryDate"));
        expiryDateField.sendKeys(orderInformation.get(10));

        //Click on process button
        WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
        processButton.click();

        //Verify confirmation message
        WebElement confirmationElement = driver.findElement(By.cssSelector("div[role='alert']"));
        String message = confirmationElement.getText();
        String expectedMsg = "New order has been successfully added.";
        Assertions.assertEquals(expectedMsg,message,"Confirmation message can not be seen !");



    }

}
