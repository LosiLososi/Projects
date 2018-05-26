import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;

import java.io.File;

public class TestClass {
    WebDriver driver;
    String baseUrl;



    @Before
    public void SetUp() {
        driver = new ChromeDriver();
        File file = new File(".\\ChromeDriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        baseUrl = "http://i.ua/";
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void UserLogin() {
        String expected = "Создать письмо";
        //driver.get(baseUrl + "/");
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("test.epam");
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys("QwErTy123321");
        driver.findElement(By.xpath("//input[@value='Войти']")).click();
        Assert.assertEquals(expected, driver.findElement(By.xpath("//a[contains(text(),'Создать письмо')]")).getText());
    }
    @Test
    public void InvalidLogin(){
        String expected = "Неверный логин или пароль";
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("%^&$&$&@*#");
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys("%&#$*^%$#$%^&*");
        driver.findElement(By.xpath("//input[@value='Войти']")).click();
        Assert.assertEquals(expected, driver.findElement(By.xpath("//div[@id='lform_errCtrl']/div")).getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
