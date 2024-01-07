package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OrderPAge {
    private WebDriver driver;
    private By productDropdownElement = By.id("productSelect");
    private By quantityInputField  = By.id("quantityInput");
    private By totalPriceField  = By.id("totalInput");

    private By dicountInputField  = By.id("discountInput");
    private By calculateButton  = By.id("//button[text()='calculate']");


    //Constructors
    public OrderPAge(WebDriver driver){
        this.driver = driver ;
    }

    public void selectProduct(String productName){
        WebElement dropdownElement = driver.findElement(productDropdownElement);
        Select productDropDown = new Select(dropdownElement);
        productDropDown.selectByVisibleText(productName);

    }
    public void enterQuantity(String quantity){
        WebElement quantityElement = driver.findElement(quantityInputField);
        quantityElement.clear();
        quantityElement.sendKeys(quantity);
    }
    public void enterDiscount(String discount){
        WebElement discountElement = driver.findElement(dicountInputField);
        discountElement.clear();
        discountElement.sendKeys(discount);
    }
    public void  clickOnCalculateButton(){
        driver.findElement(calculateButton).click();
    }
    public String calculatePrice(String productName,String quantity,String discount){
        selectProduct(productName);
        enterQuantity(quantity);
        enterDiscount(discount);
        clickOnCalculateButton();
        WebElement totalPriceElement = driver.findElement(totalPriceField);
        return totalPriceElement.getAttribute("value") ;
    }
    public void enterProduct(String productName,String quantity,String discount) {
        selectProduct(productName);
        enterQuantity(quantity);
        enterDiscount(discount);
        clickOnCalculateButton();
    }

}
