package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        //http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
        //Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();
        //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        WebElement email = driver.findElement(By.xpath("//*[@id='email_create']"));
        email.sendKeys("tarikgmail.com", Keys.ENTER);
        WebElement uyariYazisi = driver.findElement(By.xpath("//*[@id='create_account_error']"));

        Assert.assertTrue(uyariYazisi.isDisplayed());

    }
}