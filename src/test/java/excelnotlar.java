public class excelnotlar {
    /*
    Exceldeki bir dosyaya ve dosyadaki bir bölüme ulaşmak istediğimizde
uygulayacağımız aşamalar :
Ara-->dosyaYolu      --> String dosyaYolu="src/resources/ulkeler.xlsx";
Windows Gezgini ile ac- ->FileInputStream    --> FileInputStream fis = new FileInputStream(dosyaYolu);
Excel i ac              -->Workbook        --> Workbook workbook = WorkbookFactory.create(fis)
workbook olusturduktan sonra :
String actualData = workbook.
                getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();
Sayfa1 e git-->Sheet    --> getSheet()
Satiri bul-->Row       --> getRow()
Sutunu bul-->Cell     --> getCell()
Secilen bolumu getir  --> toString()
     */
}
