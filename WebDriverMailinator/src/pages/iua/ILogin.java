package pages.iua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ILogin {
    WebDriver driver;
    By error = By.cssSelector("div.content.clear");
    public ILogin(WebDriver driver){
        this.driver = driver;
    }
    public String getErrorText(){
        return driver.findElement(error).getText();
    }
}
