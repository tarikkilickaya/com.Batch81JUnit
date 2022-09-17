package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropDownHerOkuApp {


    WebDriver driver;
    Select select;

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

        //Bir class oluşturun: DropDown
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================================");
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        System.out.println("========================================");
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================================");
        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumDdm = select.getOptions();
        tumDdm.forEach(t-> System.out.println(t.getText()));
        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        System.out.println("Drop Down boyutu : " + tumDdm.size());
        if (tumDdm.size() == 4) {
            System.out.println("True");
        } else System.out.println("False");
        Assert.assertNotEquals(tumDdm.size() , 4);
    }
}