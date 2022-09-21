package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

public class C03_Facebook extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() {
       // "https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
       // “create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
       // “firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        WebElement isim = driver.findElement(By.xpath("//*[@name='firstname']"));
        Actions actions = new Actions(driver);
        String email = faker.internet().emailAddress();
        actions.click(isim).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).sendKeys("123456").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("25").sendKeys(Keys.TAB).sendKeys("Nis").sendKeys(Keys.TAB).sendKeys("2000").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();
    }
}