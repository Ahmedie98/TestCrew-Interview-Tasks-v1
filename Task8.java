package Task4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

public class Task8 {

    @Test
    public void setUP() throws InterruptedException {


// Driver setting
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //Launching the URL
        driver.get("https://www.google.com/");

        //timer after launch
        Thread.sleep(2000);

        //write java tutorial on search box
        WebElement searcheditbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));

        searcheditbox.sendKeys("Java tutorial");

        //capture list of suggestions
        Thread.sleep(1000);
        WebElement ProductsTypes = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]/div/ul"));
        List<WebElement> Types = ProductsTypes.findElements(By.tagName("li"));

        System.out.println("Suggestions:");
        for (int i = 1; i < Types.size(); i++) {

            System.out.println(Types.get(i).getText());
        }

        //clear search box
        Thread.sleep(2000);
        searcheditbox.clear();

        //write Java tutorial w
        Thread.sleep(1000);
        searcheditbox.sendKeys("Java tutorial w");

        //choose Java tutorial w3schools
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]/div/ul/li[1]")).click();

        //  Screenshot of the Date selection
        Thread.sleep(1000);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\ahmed\\Desktop\\الواجبات\\Q8.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


