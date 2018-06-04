package pages.mailinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MLetter {
    private WebDriver driver;
    private By text = By.xpath("//body/text()[1]");
    public MLetter(WebDriver driver){
        this.driver = driver;
        this.driver.switchTo().frame(driver.findElement(By.cssSelector("#msg_body")));
    }
    public String getText(){
        return driver.findElement(text).getText();
    }
}
