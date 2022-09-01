package Task4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;


public class Task6 {


    @Test
    public void setUP() throws InterruptedException {

//Bypass Notification popup window
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

// Driver setting
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);


        //Launching the URL
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/\n");

        //timer after launch
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"dob\"]")).click();

//month AKA JUN
        driver.findElement(By.className("ui-datepicker-month")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]/option[6]")).click();

//year AKA 2005
        Thread.sleep(2000);
        driver.findElement(By.className("ui-datepicker-year")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]/option[84]")).click();

        //Day AKA 30
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[5]")).click();


        //Screenshot of the Date selection
        Thread.sleep(1000);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\ahmed\\Desktop\\الواجبات\\Q6.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
