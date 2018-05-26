import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File(".\\ChromeDriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        TestClass test = new TestClass();
        test.SetUp();
        test.UserLogin();
        test.tearDown();
        test.SetUp();
        test.InvalidLogin();
        test.tearDown();
    }

}
