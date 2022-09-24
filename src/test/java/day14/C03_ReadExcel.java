package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {

        //Belirtilen satır no ve sütun no değerlerini parametre olarak alıp o celldeki datayı konsola yazdıralım
        //Sonucun konsolda yazanla aynı olduğunu doğrulayalım.

        int satir = 12;
        int sutun = 2;

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String actualData = workbook.getSheet("Sayfa1").getRow(satir - 1).getCell(sutun - 1).toString();
        String expectedData = "Baku";
        System.out.println(actualData);
        Assert.assertEquals(actualData, expectedData);
    }
}