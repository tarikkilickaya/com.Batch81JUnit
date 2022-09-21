package practise;

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

public class C03_KoalaResortLoginTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }

    @Test
    public void test01() {
        // 1) https://koalaresorthotels.com sayfasına gidiniz
        driver.get("https://koalaresorthotels.com");
        // 2) Login butonuna tıklayınız
        driver.findElement(By.xpath("//*[text()='Log in']")).click();
        // 3) Login ekranına girdiğinizi 4 farklı web elementi kullanarak doğrulayınız
        WebElement loginYazisi = driver.findElement(By.xpath("//*[@class='mb-4 bread']"));
        WebElement loginButonu = driver.findElement(By.xpath("//*[@id='btnSubmit']"));
        WebElement emailGirisi = driver.findElement(By.xpath("//*[@id='UserName']"));
        WebElement passwordGirisi = driver.findElement(By.xpath("//*[@id='Password']"));
        Assert.assertTrue(loginYazisi.isDisplayed() && loginButonu.isDisplayed() &&
                emailGirisi.isDisplayed() && passwordGirisi.isDisplayed());
        // 4)
    }
}