package pages.iua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IHome {
    private WebDriver driver;
    private By createLetterButton = By.cssSelector("p.make_message > a");
    public IHome(WebDriver driver){
        this.driver = driver;
    }
    public void clickCreateLetter(){
        driver.findElement(createLetterButton).click();
    }
    public String getTestText(){
        return driver.findElement(createLetterButton).getText();
    }
}
