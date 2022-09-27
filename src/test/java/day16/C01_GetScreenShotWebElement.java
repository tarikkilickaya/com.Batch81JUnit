package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenShotWebElement extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() throws IOException {
        // amazon sayfasına gidelim
        driver.get("https://amazon.com");
        // nutella aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nuttela" + Keys.ENTER);
        // arama sonucunun resmini alalım
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu = aramaSonucu.getScreenshotAs(OutputType.FILE);
        /*
        Sadece web elementin resmini alacaksak TakeScreenshot classını kullanmaya gerek yoktur.
        Locate edilen web elementi doğrudan geçici bir file'a atıp FileUtils ile kopyalayıp yolunu belirtiriz.
         */
        FileUtils.copyFile(nutellaAramaSonucu, new File("target/ekranGoruntusu/webElementSS" + tarih + ".jpeg"));
    }
}