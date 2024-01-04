import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter "Inar" as username
 * and "Academy" password. 4-) Click on the "Login" button. 5-) Verify that the user is
 * successfully logged in.
 */

public class WO_001_LP_01 {

	WebDriver driver = new ChromeDriver();

	@BeforeEach
	void setUp() {
		// Open the URL.
		driver.get("https://InarAcademy:Fk16621.@test.inar-academy.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() {
		driver.close();
	}

	@Test
	void testLoginProcessWithValidCredentials() throws InterruptedException {

		// 2.Click on weborder link
		WebElement webOrderLink = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/a[1]"));
		webOrderLink.click();

		// 3.Enter "Inar" as username and "Academy" password.
		WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		userNameInputField.sendKeys("Inar");
		WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
		passwordInputField.sendKeys("Academy");

		// 4.Click on the "login" button.
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		By elementLocator = By.id("welcome-heading");

		// 5. Verify that the user logged in successfully.
		WebElement heading = driver.findElement(By.id("welcome-heading"));
		String headingText = heading.getText();

		Assertions.assertEquals("Welcome, Inar", headingText, "Heading text is wrong!");

	}

}
