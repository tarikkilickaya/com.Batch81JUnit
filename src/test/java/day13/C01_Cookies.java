package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.Set;

public class C01_Cookies extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {

        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        //-tum cookie’leri listeleyin
        Set<Cookie> tumCookie = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie each : tumCookie) {
            System.out.println(sayac + ". cookie : " + each);
            System.out.println(sayac + ". name : " + each.getName());
            System.out.println(sayac + ". value : " + each.getValue());
            sayac++;
        }
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = tumCookie.size();
        Assert.assertTrue(cookieSayisi > 5);
        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each : tumCookie) {
            if (each.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", each.getValue());
            }
        }
        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);
        tumCookie = driver.manage().getCookies();
        sayac = 1;
        for (Cookie each : tumCookie) {
            System.out.println(sayac + ". cookie : " + each);
            System.out.println(sayac + ". name : " + each.getName());
            System.out.println(sayac + ". value : " + each.getValue());
            sayac++;
        }
        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookie.contains(yeniCookie));
        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(tumCookie.contains("skin"));
        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookie = driver.manage().getCookies();
        Assert.assertTrue(tumCookie.isEmpty());
    }
}