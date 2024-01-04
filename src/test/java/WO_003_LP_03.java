import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1-) Open the URL
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Click "Logout" button.
 * 5-) Verify logout successfully.
 */

public class WO_003_LP_03 extends Hooks{


    @Test
            void verifyLogOutProcess(){
    // 2.Click on weborder link
    WebElement webOrderLink = driver.findElement(By.xpath("//*[@id=‘navbar’]/div/a[1]"));
		webOrderLink.click();

    // 3.Enter "Inar" as username and "Academy" password.
    WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		userNameInputField.sendKeys("Inar");
    WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
		passwordInputField.sendKeys("Academy");

    // 4.Click on the "login" button.
    WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

    //5.Click the "log out" button.
        WebElement logOutButton = driver.findElement(By.id("logout-button"));
        logOutButton.click();

    //6.Verify LogOut successfully .
        Assertions.assertEquals("Login",loginButton.getText(),"The user can not log out properly! ");


    }
}


