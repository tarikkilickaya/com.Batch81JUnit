package practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        // tüm hayvan emojilerine tıklayın
        List<WebElement> animals = driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img"));
        for (WebElement each : animals) {
            each.click();
        }
        // formu doldurun (dilediğinizi yazabilirsiniz)
        driver.switchTo().defaultContent();
        List<WebElement> boxes = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));


        // Bu listi kullanarak her bir web elementi kolayca boxes listinde bulunan web elementlerimize gönderebileceğiz.
        List<String> text = new ArrayList<>(Arrays.asList("bu", "listi", "kullanara", "her", "bir", "web", "elementi", "kolayca", "boxes", "listinde", "bulunan"));
        for (int i = 0; i < boxes.size(); i++) {
            boxes.get(i).sendKeys(text.get(i));
        }
        // apply butonuna tıklayın
        driver.findElement(By.xpath("//*[@id='send']")).click();
    }
}