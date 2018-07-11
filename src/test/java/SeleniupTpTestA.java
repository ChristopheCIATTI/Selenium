import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;

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

        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 10);
        webDriverWait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#a-autoid-0-announce.a-button-text.a-declarative")));

        WebElement moveToChangeQuantities = driver.findElement(By.cssSelector("span#a-autoid-0-announce.a-button-text.a-declarative"));
        moveToChangeQuantities.click();

        Select quantites = new Select(driver.findElement(By.name("quantity")));
        quantites.selectByValue("2");

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(300, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);


        Boolean foo = fluentWait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                String sousTotal = driver.findElement(By.id("sc-subtotal-label-activecart")).getText();
                return sousTotal.contains("(2 articles):");
            }
        });

        String prixFinal = driver.findElement(By.id("sc-subtotal-amount-activecart")).getText();
        Assert.assertThat(prixFinal, is("EUR 99,98"));

    }

    @After
    public void  tearDown() {
        driver.quit();
    }

}
