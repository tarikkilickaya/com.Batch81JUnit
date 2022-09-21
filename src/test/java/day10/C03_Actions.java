package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

public class C03_Actions extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        // Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        // Account menüsünden create a list linkine tıklayalım
        WebElement accounList = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        Actions action = new Actions(driver);
        action.moveToElement(accounList).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek actions.moveToElement() methodunu kullanmamız gerekir.
        Aksi takdirde html kodları arasında web elementi bulur
        ama ulaşamadığı için ElemenNotInteractableException: element not interactable exception'i fırlatır
        */

    }
}