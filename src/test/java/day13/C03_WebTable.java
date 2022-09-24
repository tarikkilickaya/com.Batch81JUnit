package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.List;

public class C03_WebTable extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() throws InterruptedException {
        // Birr önceki classtaki adrese gidelim
        // login methodunu kullanarak sayfaya giriş yapalım
        login();
        int satir = 3;
        int sutun = 4;
        // input olarak verilen satır sayısı ve sütun sayısına sahip celldeki texti yazdıralım
        Thread.sleep(2000);
        WebElement hucre = driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println("Satır ve sütundaki text = " + hucre.getText());
        // Price başlığındaki tüm numaraları yazdıralım
        List<WebElement> priceBasligi = driver.findElements(By.xpath("//tbody//tr//td[6]"));
        priceBasligi.forEach(t -> System.out.println(t.getText()));
    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}