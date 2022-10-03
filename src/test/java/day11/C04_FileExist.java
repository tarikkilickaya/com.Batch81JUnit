package day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExist extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() {
        System.out.println(System.getProperty("user.dir")); // İçinde bulunduğumuz yolu gösterir.
        System.out.println(System.getProperty("user.home")); // Geçerli kullanıcının ana dizinini verir.

        //String farkliBolum = System.getProperty("user.home");
        // C:\Users\Tarik\Desktop\text.txt
        //String ortakBolum = "\\Desktop\\text.txt";
        //String masaUstuDosyaYolu = farkliBolum + ortakBolum; // Masaüstündeki dosya yolunu gösterir.
        //System.out.println(masaUstuDosyaYolu);
        //System.out.println(Files.exists(Path.of(masaUstuDosyaYolu)));
        //Assert.assertTrue(Files.exists(Path.of(masaUstuDosyaYolu)));


        String dosyaYolu = "C:\\Users\\Tarik\\Desktop\\text.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
        Bir web sitesinden indirdiğimiz ya da windows içinde oluşturduğumuz dosyanın indiğini veya orada bulunduğunu
        test edebilmek için o dosyanın üzerine shift tuşuna basılı tutarak sağ click yapıp dosyanın yolunu kopyalayıp
        String bir değişkene atarız ve dosyayı doğrulamak için Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        methodunu kullanırız.
         */
    }
}