package Task4;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;



public class Task5 {

    @Test
    public void setUP() throws InterruptedException {

//Bypass Notification popup window
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

// Driver setting
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\Documents\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);



        //Launching the URL
        driver.get("https://www.hdfcbank.com/");

        //timer after launch
        Thread.sleep(2000);

        //Choose first dropdown list
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[12]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[2]/div/a")).click();
        Thread.sleep(1000);



// Print all options
        WebElement ProductsTypes = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[12]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[2]/div/ul"));
        List<WebElement> Types = ProductsTypes.findElements(By.tagName("li"));

        System.out.println("Products Types:");
        for (int i = 1; i < Types.size(); i++)
        {

            System.out.println(Types.get(i).getText());
        }
        //Space
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        //Action Option
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[12]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[2]/div/ul/li[3]")).click();


        //Select Products, Choose second dropdown list
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[12]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[3]/div/a")).click();
        Thread.sleep(1000);



// Print all options
        WebElement SelectProducts = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[12]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[3]/div/ul"));
        List<WebElement> Select = SelectProducts.findElements(By.tagName("li"));

        System.out.println("Products:");
        for (int i = 1; i < Select.size(); i++)
        {

            System.out.println(Select.get(i).getText());
        }

        //Choose Saving Action
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[12]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[3]/div/ul/li[2]")).click();


        Thread.sleep(1000);


        String winHandleBefore = driver.getWindowHandle();

// Button
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[12]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/a[1]")).click();

// Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }


        //Screenshot of the new webpage
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\ahmed\\Desktop\\الواجبات\\Q5.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


