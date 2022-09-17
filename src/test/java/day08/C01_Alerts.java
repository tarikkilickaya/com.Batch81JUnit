package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() throws InterruptedException {
        // 1) https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 2) Click for JS Alert butonuna tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        // 3) Tıkladıktan sonra çıkan uyarı mesajına Tamam diyelim
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
}
