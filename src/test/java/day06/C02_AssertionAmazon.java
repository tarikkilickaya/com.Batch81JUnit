package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AssertionAmazon {
    /*
    amazon sayfasına gidelim
    3 farklı test methodu oluşturalım
    a- url'in amazon içerdiğini test edelim
    b- title'ın facebook içermediğini test edelim
    c- sol üst köşede amazon logosunun göründüğünü test edelim
    d- url'in www.facebook.com olmadığını test edin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void urlTest() {
        //a- url'in amazon içerdiğini test edelim
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void titleTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void logoTest() {
        WebElement logo = driver.findElement(By.xpath("//*[@aria-label='Amazon']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void urlTest2() {
        // d- url'in www.facebook.com olmadığını test edin
        String expectedUrl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl, actualUrl);
    }
}