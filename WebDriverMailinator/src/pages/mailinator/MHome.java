package pages.mailinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MHome {
    private WebDriver driver;
    //private By subjLetter = By.cssSelector("div.all_message-min_text.all_message-min_text-3");
    private By subjLetter = By.xpath("//li/div/div[4]");
    private By sender = By.xpath("//li/div/div[3]");

    public MHome(WebDriver driver) {
        this.driver = driver;
    }
    public void openLetter() {
        driver.findElement(subjLetter).click();
    }
    public String getSubject(){
        return driver.findElement(subjLetter).getText();
    }
    public String getSender(){
        return driver.findElement(sender).getText();
    }
}
