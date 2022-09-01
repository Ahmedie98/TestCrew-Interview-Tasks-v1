package Task3;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Task3 {
    @Test
    public void setUP() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\ahmed\\Documents\\EdgeDriver\\msedgedriver.exe");


        WebDriver driver = new EdgeDriver();


        //Username
        String username = "admin";

        //Password
        String password = "admin";

        String URL = "https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        Thread.sleep(1000);
        String title = driver.getTitle();


        String text = driver.findElement(By.tagName("p")).getText();

        System.out.println("The test present in page is: "+text);




    }

}



