import Tests.TestClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.iua.*;
import pages.mailinator.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File(".\\Driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        //WebDriver driver = new ChromeDriver();
        TestClass test = new TestClass();
        test.setUp();
        test.loginIUA();
        test.tearDown();
        test.setUp();
        test.invalidLoginIUA();
        test.tearDown();
        test.setUp();
        test.testMailinator();
        test.tearDown();

        /*String login = "test.epam";
        String password = "QwErTy123321";
        String destination = "losilososi@mailinator.com";
        String subject = "SubjectSubjectaaaaa";
        String text = "texttextaaaaa";*/

    }
}
