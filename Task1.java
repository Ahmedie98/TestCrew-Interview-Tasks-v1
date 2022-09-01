package Firstprojecttesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.Test;
import org.openqa.selenium.Keys;



public class Task1 {


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
////////////////////////////////////////////////////////////////////

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Live Posting']")).click();

        WebElement searcheditbox = driver.findElement(By.id("autocomplete"));

        searcheditbox.clear();

        searcheditbox.sendKeys("Toronto OH");
        Thread.sleep(1000);


        String suggestion;
        do {
            searcheditbox.sendKeys(Keys.ARROW_DOWN);

            suggestion = searcheditbox.getAttribute("value");
            Thread.sleep(1000);
            if (suggestion.equals("Toronto, OH, USA")) {
                searcheditbox.sendKeys(Keys.ENTER);
                break;
            }
            Thread.sleep(1000);
        } while (!suggestion.isEmpty());

    }
}


