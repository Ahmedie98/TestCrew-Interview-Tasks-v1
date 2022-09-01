package Task4;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task7 {

    @Test
    public void setUP() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\Documents\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        Thread.sleep(1000);

        driver.switchTo().frame(0);
        System.out.println("First frame title: "+driver.findElement(By.xpath("/html/body/main/h2")).getText());
//
        driver.switchTo().defaultContent();


        Thread.sleep(1000);
        driver.switchTo().frame(1);
        System.out.println("Second frame title: "+ driver.findElement(By.xpath("/html/body/h1")).getText());
        driver.switchTo().defaultContent();

        Thread.sleep(1000);
        driver.switchTo().frame(2);
        System.out.println("Third frame, name of package you choose: "+ driver.findElement(By.xpath("//*[@id=\"i0\"]/th/a")).getText());
        driver.findElement(By.xpath("/html/body/main/div/table/tbody[2]/tr[1]/th/a")).click();

        Thread.sleep(3000);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\ahmed\\Desktop\\الواجبات\\Q7.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }


}


