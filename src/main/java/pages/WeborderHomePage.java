package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WeborderHomePage {
    private WebDriver driver;

    //Product Informations
    private By viewAllOrders = new By.ByLinkText("View all orders");
    private By viewAllProductsLink = new By.ByLinkText("View all products");
    private By orderLink = new By.ByLinkText("Order");

    //Customer Informations
     private By nameField = By.id("name");
     private By streetField = By.id("street");
     private By cityField = By.id("city");
     private By stateField = By.id("state");
     private By zipCodeField = By.id("zip");

     //Payment Informations


    //CardValues
    private By visaCheckBox = By.id("visa");
    private By masterCardCheckBox = By.id("MasterCard");
    private By americanExpressCheckbox = By.id("American Express");


    //CardNumbers
    private By cardNumberField = By.id("cadNumber");

    //ExpiryDate
    private By expiryDateField = By.id("expiryDate");


    private By processButton = By.xpath("//button[text()='Process']");

    //Constructors
    public WeborderHomePage(WebDriver driver){
        this.driver = driver ;
    }
    public  viewAllOrdersPage navigateToViewAllOrders(){
        driver.findElement(viewAllOrders).click();
        return new viewAllOrdersPage(driver);
    }
    public  OrderPAge navigateToOrder(){
        driver.findElement(orderLink).click();
        return new OrderPAge(driver);
    }
    public  OrderPAge navigateToAllProducts(){
        driver.findElement(viewAllProductsLink).click();
        return new OrderPAge(driver);
    }

    public void enterCustomerInfo(String name,String streets,String city,String state,String zip){
        enterName(name);
        enterStreet(streets);
        enterCity(city);
        enterState(state);
        enterZip(zip);
    }
    public void enterName(String name){
        WebElement nameElement = driver.findElement(nameField);
        nameElement.clear();
        nameElement.sendKeys(name);
    }
    public void enterStreet(String street){
        WebElement streetElement = driver.findElement(streetField);
        streetElement.clear();
        streetElement.sendKeys(street);
    }
    public void enterCity(String city){
        WebElement cityElement = driver.findElement(cityField);
        cityElement.clear();
        cityElement.sendKeys(city);
    }
    public void enterState(String state){
        WebElement enterState = driver.findElement(stateField);
        enterState.clear();
        enterState.sendKeys(state);
    }
    public void enterZip(String zip){
        WebElement enterZip = driver.findElement(zipCodeField);
        enterZip.clear();
        enterZip.sendKeys(zip);
    }

    public void selectPaymentMethod(String paymentMethod){
        switch (paymentMethod.toLowerCase()){
            case"visa":
                clickCheckBox(visaCheckBox);
                break;
            case"mastercard":
                clickCheckBox(masterCardCheckBox);
                break;
            case"american express":
                clickCheckBox(americanExpressCheckbox);
                break;
            default:
                System.out.println("Payment Method does not exist");
                break;

        }

    }

    private void clickCheckBox(By checkboxLocator) {
        WebElement checkbox = driver.findElement(checkboxLocator);
        if (!checkbox.isSelected()){
            checkbox.click();
        }
    }
    public void enterCardNumber(String cardNumber){
        WebElement cardNumberElement = driver.findElement(cardNumberField);
        cardNumberElement.clear();
        cardNumberElement.sendKeys(cardNumber);
    }
    public void enterExpiryDate(String expiryDate){
        WebElement expiryDateElement = driver.findElement(expiryDateField);
        expiryDateElement.clear();
        expiryDateElement.sendKeys(expiryDate);
    }
    public void enterPaymentInformation(String paymentMethod,String cardNumber,String expiryDate){
        selectPaymentMethod(paymentMethod);
        enterCardNumber(cardNumber);
        enterExpiryDate(expiryDate);

    }

    public void clickOnProcessButton(){
        driver.findElement(processButton).click();
    }

}
