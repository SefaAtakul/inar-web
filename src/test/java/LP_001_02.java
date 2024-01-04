import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LP_001_02 {

	WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = new ChromeDriver();

	}

	@Test
	void testSeleniumWebDriver() {
		driver.get("https://test.inar-academy.com/weborder");
		String currentUrl = driver.getCurrentUrl();
		assertEquals("https://test.inar-academy.com/weborder", currentUrl);
		WebElement webOrderUserName = driver.findElement(By.id("login-username-input"));
		webOrderUserName.sendKeys("Inar");
		WebElement webOrderPassword = driver.findElement(By.id("login-password-input"));
		webOrderPassword.sendKeys("Academy");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		assertEquals("https://test.inar-academy.com/weborder", driver.getCurrentUrl());

	}

}
