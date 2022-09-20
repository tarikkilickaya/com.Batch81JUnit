package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.List;


public class C04_Actions extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() {
        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // 3- Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlan).perform();
        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());
        // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        // Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String beklenenBaslik = "Elemental Selenium";
        String asilBaslik = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        Assert.assertTrue(asilBaslik.contains(beklenenBaslik));
    }
}