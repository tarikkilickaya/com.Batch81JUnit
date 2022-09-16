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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDownSelect {
    WebDriver driver;
    Select select;

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
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        /*
        Dropdown menüye ulaşmak için Select classından bir obje oluştururuz.
        Locate ettiğimiz dropdown web elementini select classına tanımlarız.
        getOptions() methodunu kullanarak dropdown'u bir liste atarak dropdown menünün bütün elemanlarının sayısına ulaşırız.
         */
        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddmList.size());
        int expectedSayi = 45;
        int actualSayi = ddmList.size();
        Assert.assertNotEquals(expectedSayi, actualSayi);
    }

    @Test
    public void test2() {
        //-Test2
        //1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        select.selectByIndex(5); // indexle ulaşılabilir
        //select.selectByVisibleText("Books"); // text ile ulaşılabilir
        //select.selectByValue("search-alias=stripbooks-intl-ship"); // value ile ulaşılabilir
        //2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //3.Bulunan sonuc sayisini yazdirin
        String sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(sonuc);
        //4.Sonucun Java kelimesini icerdigini testedin
        String arananKelime = "Java";
        Assert.assertTrue(sonuc.contains(arananKelime));

        /*
        Dropdown menüde seçtiğimiz option'a ulaşmak istersek select.getFirstSelectedOption() methodunu kullanırız.
         */
    }
}