package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05_FileExist_Download extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() throws InterruptedException {

        // https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        // test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();
        // Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        Thread.sleep(2000);
        String dosyaYolu = "C:\\Users\\Tarik\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        // İndirildiğini konsolda gösterin
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
    }
}