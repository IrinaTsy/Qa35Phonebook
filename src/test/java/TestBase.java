import manager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

public class TestBase {

    WebDriver wd;

    static AppManager app = new AppManager();


    @BeforeSuite //отработает перед каждым методом с аннотацией Test
    public void setUp(){

        app.init();
    }

    @AfterSuite //отработает после каждого метода Test
    public void tearDown(){

        app.stop();

    }
   // ***************************************************************************

    //service methods





}














