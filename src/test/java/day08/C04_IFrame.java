package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_IFrame {
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
        //driver.quit();
    }

    @Test
    public void test1() {
        // https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");

        /*
        Bir web sitesinde bir video (youtube vb.) varsa ve <iframe> tagı içerisindeyse bu videoyu doğrudan locate edip
        çalıştırmak dinamik olmaz. Çünkü link değişebilir ve locate çalışmaz. Bunun için bütün frameleri bir array liste atıp
        index ile frame'i seçip sonrasında play tuşunu locate edip çalıştırabiliriz.
         */

        // youtube videosunu çalıştırınız
        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        WebElement youtubeFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframeList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
    }
}