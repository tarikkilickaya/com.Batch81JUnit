package day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBaseBeforeAfter;
import utilities.TestBaseBeforeClassAfterClass;

import java.time.Duration;

public class C01_IlkTestBaseClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() {
        driver.get("https://amazon.com");
    }
}