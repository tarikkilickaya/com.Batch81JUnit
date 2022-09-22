package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeClassAfterClass;

import java.time.Duration;

public class C03_SenkronizasyonWait extends TestBaseBeforeClassAfterClass {
    @Test
    public void implicitlyWaitTest1() {

        /*
         imlicitlyWait kullandığımız bu method'da sayfadaki bütün webelementler için
         max belirttiğimiz süre altında bütün web elementler için bekler
        */

        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        // "It's gone!" mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed());
        // Add buttonuna basin
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        // It's back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's back!\"]")).isDisplayed());
    }

    @Test
    public void explicitlyWaitTest2() {
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        // "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneWE.isDisplayed());
        // Add buttonuna basin
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        // It's back mesajinin gorundugunu test edin
        WebElement itsBackWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackWE.isDisplayed());

    }
}