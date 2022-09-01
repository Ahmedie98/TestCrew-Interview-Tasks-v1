package Firstprojecttesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Task2 {


    @Test
    public void setUP() throws InterruptedException {
/////////////////////////////////////////////////////////////////////
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\Documents\\ChromeDriver\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
////////////////////////////////////////////////////////////////////


        //Create instance of ChromeOptions Class
        ChromeOptions handlingSSL = new ChromeOptions();

        //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
        handlingSSL.setAcceptInsecureCerts(true);

        //Creating instance of Chrome driver by passing reference of ChromeOptions object
        WebDriver driver = new ChromeDriver(handlingSSL);

        //Launching the URL
        driver.get("https://www.twoplugs.com/");
//////////////////////////////////////////////////////////////////////

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Live Posting']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"services\"]/div/div[1]/div/div[1]/div/div/div")).click();
        Thread.sleep(1000);
        WebElement ProductsTypes = driver.findElement(By.xpath("//*[@id=\"services\"]/div/div[1]/div/div[1]/div/div/div/div[2]/ul"));
        List<WebElement> Types = ProductsTypes.findElements(By.tagName("li"));


        ArrayList<String> catagories = new ArrayList<String>();
        for(WebElement ele:Types)
        {
            String data = ele.getText();
            catagories.add(data);


        }
        Collections.sort(catagories);
        System.out.println("Sorted ArrayList in Ascending order : " + catagories);

        Collections.sort(catagories, Collections.reverseOrder());
        System.out.println("Sorted ArrayList in Descending order : " + catagories);

    }


}


