package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_GMIBankLogin {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1) https://www.gmibank.com/ adresinde gidiniz
        driver.get("https://www.gmibank.com/");
        // 2) Sign in butonuna tıklayınız
        driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-user fa-w-14 ']")).click();
        driver.findElement(By.id("login-item")).click();
        // 3) Username: Batch81 --- Password: Batch81+ bilgileri ile giriş yapınız
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Batch81");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Batch81+");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.close();
    }
}