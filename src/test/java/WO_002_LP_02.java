import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**1-) Open the URL.
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter invalid username "InvalidUserName" and/or password "InvalidPassword".
 * 4-) Click on the "Login" button
 5-) Verify that the appropriate error message is displayed.
 */





public  class WO_002_LP_02 extends Hooks {

    @Test
    void testLoginProcessWithInvalidCredentials() {
        // 2.Click on weborder link
        // Click "WebOrder" button on top bar.
        WebElement webOrderPage = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderPage.click();

        // 3.Enter "Inar" as username and "Academy" password.
        WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
        userNameInputField.sendKeys("Inary");
        WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
        passwordInputField.sendKeys("Academ");

        // 4.Click on the "login" button.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //5.Verify that appropriate error message is displayed.
        WebElement usernameErrorMessage = driver.findElement(By.id("username-error-alert"));
        Assertions.assertEquals("Invalid username",usernameErrorMessage,"Invalid username error message have to displayed!");

        WebElement passwordErrorMessage = driver.findElement(By.id("password-error-alert"));
        Assertions.assertEquals("Invalid password",passwordErrorMessage,"Invalid password error message have to displayed!");


    }
}