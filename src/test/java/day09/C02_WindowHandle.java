package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        //2- Url'nin amazon içerdiğini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        String amazonWindowHandle = driver.getWindowHandle();
        /*
        Eğer bize verilen taskte sayfalar arası geçiş varsa her driver.get() methodundan sonra
        driverın window handle değerini String bir değişkene atarız.
        Sonrasında farklı bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
        String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz.
         */
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://bestbuy.com"); // Yeni bir pencere açmak için bu methodu kullanılır.
        String bestBuyWindowHandle = driver.getWindowHandle();
        //4- title'in Best Buy içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle); // Sayfalar arası geçiş için bu method kullanılır.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
        //6- Arama sonuclarının java içerdiğini test edelim
        String aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(aramaSonucu.contains("java"));
        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);
        //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@alt='Best Buy Logo'])[1]")).isDisplayed());
    }
}