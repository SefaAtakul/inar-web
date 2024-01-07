package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeborderLoginPage {
    private WebDriver driver;
    private By userInputField = By.id("login-username-input");
    private By passwordInputField = By.id("login-password-input");
    private By loginButton = By.id("login-button");



    public WeborderLoginPage(WebDriver driver){
        this.driver = driver ;
    }

    public void enterUserName(String userName){
        driver.findElement(userInputField).sendKeys(userName);
    }
    public void enterPassword(String password){
        driver.findElement(passwordInputField).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public WeborderHomePage login(String userName,String password){
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
return new WeborderHomePage(driver);

    }


}
