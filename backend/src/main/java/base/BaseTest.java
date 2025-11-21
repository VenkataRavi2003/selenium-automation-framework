package base;
import java.time.Duration;
import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {
    protected static SelfHealingDriver driver;
    public static void initializeWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver delegate = new ChromeDriver();
        driver = SelfHealingDriver.create(delegate);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public static WebDriver getWebDriver() {
        return driver;
    }

}
