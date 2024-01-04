import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 1-) Open the URL. // 2-) Click "WebOrder" button on top bar. // 3-) Enter valid
 * username "Inar" and password "Academy". // 4-) Navigate to the order page. // 5-)
 * Select "MyMoney" from Product dropdown. // 6-) Enter "8" as quantity number. // 7-)
 * Enter "20" as discount percentage. // 8-) Click on the "Calculate" button. // 9-) Enter
 * "Inar Academy" as Name. // 10-) Enter "1100 Congress Ave" as Street. // 11-) Enter
 * "Austin" as City. // 12-) Enter "TX" State. // 13-) Enter "78701" as Zip Code(number).
 * // 14-) Select "Visa" as Card Type. // 15-) Enter "4938281746192845" as Card Number. //
 * 16-) Enter "11/28" Expire Date(mm/yy format). // 17-) Click "Process"" button. " + //
 * 18-) Verify the confirmation message is displayed. // 19-) Navigate to view all orders
 * page. // 20-) Verify the order is successfully placed.
 */

public class WO_006_OP_01 {

	WebDriver driver = new ChromeDriver();

	List<String> orderInformation = new ArrayList<>();

	@BeforeEach
	void setUp() {
		// Open the URL.
		driver.get("https://InarAcademy:Fk16621.@test.inar-academy.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() {
		driver.close();
	}

	@Test
	void testSuccessfulOrderPlacement() throws InterruptedException {
		// Name
		orderInformation.add("Inar Academy");
		// Prod name
		orderInformation.add("MyMoney");
		// Quantity
		orderInformation.add("8");
		// Date
		orderInformation.add(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now()));
		// Street
		orderInformation.add("1100 Congress Ave.");
		// City
		orderInformation.add("Austin");
		//State
		orderInformation.add("TX");
		//Valid ZipCode
		orderInformation.add("78701");
		//ValidCardType
		orderInformation.add("Visa");
		//ValidCardNumber(Visa starts with : 4,Mastercard starts with : 5,American express starts with:34,37)
		orderInformation.add("4938281746192845");
		//Valid Card Expire Date(format must be mm/yy)
		orderInformation.add("11/28");

		// 2.Click on weborder link
		WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderLink.click();

		// 3.Enter "Inar" as username and "Academy" password.
		WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement passwordInputField = driver.findElement(By.id("login-password-input"));

		userNameInputField.sendKeys("Inar");
		passwordInputField.sendKeys("Academy");

		// Click on the "login" button.
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		//By elementLocator = By.id("welcome-heading");

		// Verify that the user logged in successfully.
		WebElement heading = driver.findElement(By.id("welcome-heading"));
		String headingText = heading.getText();

		Assertions.assertEquals("Welcome, Inar", headingText, "Heading text is wrong!");

		// 4.Navigate to the order page.
		WebElement orderTabLink = driver.findElement(By.cssSelector("#order-tab > a"));
		orderTabLink.click();

		// 5-) Select "MyMoney" from Product dropdown.
		WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
		Select  productDropdown = new Select(productDropdownElement);

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
		WebElement visaTypeCheckbox = driver.findElement(By.id("visa"));
		visaTypeCheckbox.click();

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

		js.executeScript("window.scroll(0,-1000)");

		Thread.sleep(3000);

		//Navigate to view all orders page.
		WebElement viewAllOrderLink = driver.findElement(By.cssSelector("#view-orders-tab > a"));
		viewAllOrderLink.click();

		//Verify the order is successfully placed
		List<WebElement> tableRows =driver.findElements(By.cssSelector("tbody > tr"));
		List<WebElement> columnValuesInLastRow = tableRows.get(tableRows.size()-1).findElements(By.xpath("td"));

		for (int i = 0; orderInformation.size() > i  ; i++) {
			String expectedValue = orderInformation.get(i);
			String actualValue = columnValuesInLastRow.get(i+1).getText();

			Assertions.assertEquals(expectedValue,actualValue,"Wrong order information!" );
		}
		Thread.sleep(4000);


	}

}
