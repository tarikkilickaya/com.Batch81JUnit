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
import java.util.List;

public class C02_DropDownHandleAmazon {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void test1() {
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        List<WebElement> dropDownMenu = driver.findElements(By.xpath("//option"));
        System.out.println(dropDownMenu.size());
        int dropDownList = dropDownMenu.size();
        int expectedSayi = 45;
        Assert.assertNotEquals(expectedSayi, dropDownList);
    }

    @Test
    public void test2() {

        //-Test2
        //1.Kategori menusunden Books secenegini secin
        driver.findElement(By.xpath("//*[text()='Books']")).click();
        //2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //3.Bulunan sonuc sayisini yazdirin
        String sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(sonuc);
        //4.Sonucun Java kelimesini icerdigini testedin
        String arananKelime = "Java";
        Assert.assertTrue(sonuc.contains(arananKelime));
    }
}