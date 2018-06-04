package Tests;
import org.apache.commons.net.imap.IMAP;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.iua.*;
import pages.mailinator.*;

public class TestClass {
    private WebDriver driver;
    private String login = "test.epam";
    private String password = "QwErTy123321";
    private String adress = "losilososi@mailinator.com";
    private String subject = "SubjectSubject";
    private String bodyText = "bodyTextbodyText";
    private String sender = "Иван Иванов";

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }
    @Test
    public void loginIUA(){
        String expected = "Создать письмо";
        IMain imain = new IMain(driver);
        IHome ihome = new IHome(driver);
        imain.clickLogin(login, password);
        Assert.assertEquals(expected, ihome.getTestText());
    }
    @Test
    public void invalidLoginIUA(){
        String invalidlogin = "$%^&*(";
        String invalidpassword = "#$%^&*(*&^%$#";
        String expected = "Неверный логин или пароль";
        IMain imain = new IMain(driver);
        ILogin ilogin = new ILogin(driver);
        imain.clickLogin(invalidlogin,invalidpassword);
        Assert.assertEquals(expected, ilogin.getErrorText());
    }
    @Test
    public void testMailinator(){
        IMain imain = new IMain(driver);
        imain.clickLogin(login, password);
        IHome ihome = new IHome(driver);
        ihome.clickCreateLetter();
        ICreateLetter icreateletter = new ICreateLetter(driver);
        icreateletter.sendLetter(adress, subject,bodyText);
        MMain mmain = new MMain(driver);
        mmain.toInbox(adress);
        MHome mhome = new MHome(driver);
        Assert.assertEquals(sender, mhome.getSender());
        Assert.assertEquals(subject,mhome.getSubject());
        mhome.openLetter();
        MLetter mletter = new MLetter(driver);
        Assert.assertEquals(bodyText,mletter.getText());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
