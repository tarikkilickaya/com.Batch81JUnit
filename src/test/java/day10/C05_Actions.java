package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

public class C05_Actions extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() throws InterruptedException {
        // https://demoqa.com/droppable adrsine gidelim
        driver.get("https://demoqa.com/droppable");
        // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions action = new Actions(driver);
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        action.dragAndDrop(dragMe, dropHere).perform();
        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Dropped!']")).isDisplayed());
    }
}