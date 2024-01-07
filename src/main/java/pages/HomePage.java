package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    //Locators
    private By webOrderLink = new By.ByLinkText("Weborder");
    private By webAutomationLink = new By.ByLinkText("Webautomation");
    private By targetMarketLink = new By.ByLinkText("Target Market");
    private By bookingLink = new By.ByLinkText("Booking");
    private By handlingCertificationLink = new By.ByLinkText("Handling Certifications");
    private By fileupLoadingLink = By.linkText("File uploading");
    private By exploreInarTestingWorldTitleText = By.cssSelector("h1.display-1  text-fifth");
    //Constructors
    public HomePage(WebDriver driver){
        this.driver = driver ;
    }

    //Page actions with java methods
    public WeborderLoginPage clickOnWeborderLink(){
        driver.findElement( webOrderLink).click();
        return new WeborderLoginPage(driver);
    }
    public void clickOnWebAutomationLink(){
        driver.findElement( webAutomationLink).click();
    }
    public void clickOnBookingLink(){
        driver.findElement( bookingLink).click();
    }
    public void clickOnHandlingCertificationLink(){
        driver.findElement( handlingCertificationLink).click();
    }
    public void clickFileUploadingLink(){
        driver.findElement( fileupLoadingLink).click();
    }
    public String getWelcomeText(){
        return driver.findElement(exploreInarTestingWorldTitleText).getText();
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
}
