package pages.mailinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMain {
    private WebDriver driver;
    private By inbox = By.id("inboxfield");
    private By submitButton = By.cssSelector("button.btn.btn-dark");
    private String baseUrl = "http://www.mailinator.com/";
    public MMain(WebDriver driver){
        this.driver = driver;
        this.driver.get(baseUrl);
    }
    public void setInbox(String inbx){
        driver.findElement(inbox).clear();
        driver.findElement(inbox).sendKeys(inbx);
    }
    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }
    public void toInbox(String inbx){
        setInbox(inbx);
        clickSubmit();
    }
}
