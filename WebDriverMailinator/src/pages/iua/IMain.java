package pages.iua;

import org.openqa.selenium.*;

public class IMain {
    private WebDriver driver;
    private By login = By.name("login");
    private By password = By.name("pass");
    private By loginButton = By.cssSelector("p > input[type=\"submit\"]");
    private String baseUrl = "http://www.i.ua/";
    public IMain(WebDriver driver){
        this.driver = driver;
        this.driver.get(baseUrl);
    }
    public void setUserLogin(String name){
        driver.findElement(login).clear();
        driver.findElement(login).sendKeys(name);
    }
    public void setUserPasswor(String pass){
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public void clickLogin(String login, String pass){
        setUserLogin(login);
        setUserPasswor(pass);
        clickLogin();
    }
}
