package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeClassAfterClass;

public class C01_AutomationExercisePageDown extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() {
        // https://www.automationexercise.com/ sitesine gidelim
        driver.get("https://www.automationexercise.com/");
        // Products bölümüne gidelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        // İlk ürüne tıklayalım
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();
    }
}