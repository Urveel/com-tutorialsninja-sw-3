package browsefactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {


    public static WebDriver driver;
    static String browser = "Chrome";
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @BeforeClass
    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}

