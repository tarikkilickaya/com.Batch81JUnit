package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_AssertionBestBuy {

    /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    ○ logoTest => BestBuy logosunun görüntülendigini test edin
    ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void urlTest() {
        // Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void titleTest() {
        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedTitle = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(expectedTitle.contains(actualTitle));
    }

    @Test
    public void logoTest() {
        // logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void fransizcaLink() {
        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement fransizcaLink = driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(fransizcaLink.isDisplayed());
    }
}