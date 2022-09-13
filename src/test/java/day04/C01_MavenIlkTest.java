package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com.tr");
        //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);
        //4- Bulunan sonuc sayisini yazdiralim
        List<WebElement> sonucYazisi = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        for (WebElement each : sonucYazisi) {
            System.out.println(each.getText());
        }
        //5- Ilk urunu tiklayalim

        //6- Sayfadaki tum basliklari yazdiralim

    }
}
