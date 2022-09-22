package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {

    /*
    Bir web sitesine girdiğimizde ya da bir butona tıkladığımızda karşımıza bir uyarı mesajı çıkabilir.
    Eğer bu uyarıya incele (mouse ile sağ tık -> inspect) yapabiliyorsak bu tür alertlere HTML alert denir
    ve istediğimiz locate'i alabiliriz. Ama gelen uyarı kutusan müdahale edemiyorsak (sağ tık -> incele) edemiyorsak
    bu tür alertlere ise js alert denir. JS alertlere müdahale edebilmek için
    - tamam ya da ok için driver.switchTo().alert().accept() kullanılır.
    - iptal için driver.switchTo().alert().dismiss() kullanılır.
    - Alert içindeki mesajı almak için driver.switchTo().alert().getText() kullanılır.
    - Alert bizden bir metin istiyorsa driver.switchTo().alert().sendKeys("...") kullanılır.
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        /*
        Bir metod olusturun: acceptAlert
        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
         */
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String actualMesaj = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj = "You successfully clicked an alert";
        Assert.assertEquals(actualMesaj, expectedMesaj);
    }

    @Test
    public void test2() {
        /*
        Bir metod olusturun: dismissAlert
        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        “successfuly” icermedigini test edin.
         */
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        System.out.println(driver.switchTo().alert().getText()); // alertin üzerindeki yazıyı al
        driver.switchTo().alert().dismiss();
        String actualMesaj = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj = "successfuly";
        Assert.assertFalse(actualMesaj.contains(expectedMesaj));

    }

    @Test
    public void test3() throws InterruptedException {
        /*
        Bir metod olusturun: sendKeysAlert
        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
         */

        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Tarık");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String mesaj = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String mesajdaArananKelime = "Tarık";
        Assert.assertEquals(mesaj, mesajdaArananKelime);
    }
}