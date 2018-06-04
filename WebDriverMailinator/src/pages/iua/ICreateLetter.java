package pages.iua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ICreateLetter {
    private WebDriver driver;
    private By destination = By.id("to");
    private By subject = By.name("subject");
    private By textBody = By.id("text");
    private By sendButton = By.cssSelector("p.send_container.clear > input[name=\"send\"]");
    public ICreateLetter(WebDriver driver){
        this.driver = driver;
    }
    public void setDestination(String address){
        driver.findElement(destination).clear();
        driver.findElement(destination).sendKeys(address);
    }
    public void setSubject(String sbj){
        driver.findElement(subject).clear();
        driver.findElement(subject).sendKeys(sbj);
    }
    public void setText(String txt){
        driver.findElement(textBody).clear();
        driver.findElement(textBody).sendKeys(txt);
    }
    public void clickSendButton(){
        driver.findElement(sendButton).click();
    }
    public void sendLetter(String address, String sbj, String txt){
        setDestination(address);
        setSubject(sbj);
        setText(txt);
        clickSendButton();
    }
}
