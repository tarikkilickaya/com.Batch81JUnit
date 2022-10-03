package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;


public class C02_FileExits_Upload extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement dosyaSecButonu = driver.findElement(By.xpath("//*[@id='file-upload']"));

        /*
        Dosya seç butonuna doğrudan click yapamayabiliriz çünkü windows'a müdahaleye izin verilmez.
        Bu yüzden dosya seç butonunu doğrudan locate edip sendKeys() methodu ile ilgili dosyanın yolunu gönderdik.
         */

        //Yuklemek istediginiz dosyayi secelim.

        // "C:\Users\Tarik\Desktop\a.png"

        String dosyaYolu = "C:\\Users\\Tarik\\Desktop\\text.txt";
        dosyaSecButonu.sendKeys(dosyaYolu);
        //Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());
    }
}