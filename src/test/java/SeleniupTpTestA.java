import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniupTpTestA {
    WebDriver driver;

    @Before
    public void  init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.fr");
    }

    @Test
    public void  testA() {
        Actions actions = new Actions(driver);

        WebElement openCategories = driver.findElement(By.id("nav-shop"));
        actions.moveToElement(openCategories).build().perform();

        WebElement openVideoGamesA = driver.findElement(By.cssSelector("span[data-nav-panelkey='VideogamesConsolesPanel']"));
        actions.moveToElement(openVideoGamesA).build().perform();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-flyout-shopAll>.nav-subcats")));

        WebElement openVideoGamesB = driver.findElement(By.linkText("Nintendo Switch"));
        openVideoGamesB.click();

        WebElement getTopOneSale = driver.findElement(By.linkText("N°1 des ventes"));
        actions.moveToElement(getTopOneSale).build().perform();

        WebElement clickMarioKart8 = driver.findElement(By.linkText("Mario Kart 8 Deluxe"));
        clickMarioKart8.click();

        WebDriverWait webDriverWait1 = new WebDriverWait(driver, 10);
        webDriverWait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.a-section.a-spacing-none.a-padding-none")));

        WebElement addToCart = driver.findElement(By.cssSelector("input#add-to-cart-button.a-button-input"));
        addToCart.click();

        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 10);
        webDriverWait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#hlb-view-cart-announce.a-button-text")));

        WebElement moveToCart = driver.findElement(By.cssSelector("a#hlb-view-cart-announce.a-button-text"));
        moveToCart.click();

        
    }


    @After
    public void  tearDown() {
        driver.quit();
    }

}
