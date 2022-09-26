package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeClassAfterClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() throws IOException {
        // Amazon sayfasına gidip tüm sayfanın resmini alalım
        driver.get("https://techproeducation.com");

        /*
        Bir web sayfasının resmini alabilmek için TakesScreenshot classından obje oluşturup
        geçici bir file classından değişkene TakesScrenshot'tan oluşturduğumuz objeden getScreenshotAs()
        methodunu kullanarak geçici bir File oluştururuz.
         */

        TakesScreenshot ts = (TakesScreenshot) driver;

        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/allPage" + tarih + ".jpeg"));

    }
}