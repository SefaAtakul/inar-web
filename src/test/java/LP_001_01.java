import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LP_001_01 {

	private WebDriver driver;

	@BeforeEach
	void setUpTest() {
		driver = new ChromeDriver();
	}

	@Test
	void testSamplePage() {
		String url = "https://test.inar-academy.com/";
		driver.get(url);
		WebElement element = driver.findElement(By.id("navbar"));
		element.getText();
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println(element);
		element.isDisplayed();
	}

	@AfterEach
	void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
