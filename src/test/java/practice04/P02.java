package practice04;

import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P02 {
    @Test
    public void test() {
        //Verify that we have pom.xml file in our project => please try in 4 min s
        String dosyaYolu = "C:\\Users\\Tarik\\IdeaProjects\\com.Batch81Junit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}