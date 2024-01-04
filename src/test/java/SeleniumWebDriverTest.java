import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumWebDriverTest {

	WebDriver driver;

	@BeforeEach
	void setUpTestEnvironment() {
		driver = new ChromeDriver();
	}

	@Test
	void testSeleniumWebDriver() throws InterruptedException {
		driver.get("https://www.google.com/");
		String currentUrl = driver.getCurrentUrl();
		assertEquals("https://www.google.com/", currentUrl);

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(1));
	}

	@AfterEach
	void tearDownTestEnvironment() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
