package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_Facebook extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() {

        //1- https://www.facebook.com adresine gidelim
        driver.get("https://facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isim = driver.findElement(By.xpath("//*[@name='firstname']"));
        isim.sendKeys("abc");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("def").sendKeys(Keys.TAB).
                sendKeys("techpro@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("techpro@gmail.com").sendKeys(Keys.TAB).sendKeys("123456").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("25").sendKeys(Keys.TAB).sendKeys("Nis").sendKeys(Keys.TAB).sendKeys("2000").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();
    }
}