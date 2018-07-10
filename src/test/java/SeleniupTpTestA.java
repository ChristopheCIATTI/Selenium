import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniupTpTestA {
    WebDriver driver;


    @Before
    public void  init() {
        driver = new ChromeDriver();
    }

    @Test
    public void  testA() {
        driver.get("http://www.google.com");
    }


    @After
    public void  tearDown() {
        driver.quit();
    }

}
