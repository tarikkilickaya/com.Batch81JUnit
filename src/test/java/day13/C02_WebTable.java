package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.List;

public class C02_WebTable extends TestBaseBeforeClassAfterClass {


    @Test
    public void test1() {

        //Bir class oluşturun : C02_WebTables
        //login() metodun oluşturun ve oturum açın.
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        login();
        //Username : manager
        //Password : Manager1!
        //table() metodu oluşturun

        table();

        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //printRows() metodu oluşturun //tr

        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //4.satirdaki(row) elementleri konsolda yazdırın.
    }

    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        /*
        Tabloda <table> tagı altında tablonun başlığını gösteren <thead> tagı bulunur. Eğer başlıkta satır (row) varsa
        <thead> tagı altında <tr> (satır-row) tagı vardır. Ve başlıktaki sütunlara yani hücrelere (cell) de <th> tagı ile ulaşılır.
        Başlığın altındaki tablodaki verilere <tbody> tagı ile altındaki satırlara (row) <tr> tagı ile sütunlara yani hücrelere
        <td> tagı ile ulaşılır.
         */
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println(sutunSayisi.size());
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println(basliklar.getText());
        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println(body.getText());
        //printRows() metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(satirList.size());
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.forEach(t -> System.out.println(t.getText()));
        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println();
        System.out.println("4. satırdaki elementler : " + driver.findElement(By.xpath("//tbody//tr[4]")).getText());
    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}