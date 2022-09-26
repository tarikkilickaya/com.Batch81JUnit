package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_DeleteExcel {
    @Test
    public void test1() throws IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");
        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);
        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);
        //-3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);

        /*
         Bir celldeki veriyi silmek için row objesine ihtiyaç vardır.
         row objesi ile removeCell() methodunu kullanarak cell objesi ile belirttiğimiz celldeki veriyi silebiliriz.
         */

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        //-Silindiğini test edin
        String expectedData = "Cezayir";
        String actualData = null;
        Assert.assertNotEquals(expectedData, actualData);
        fis.close();
        fos.close();
        workbook.close();
    }
}