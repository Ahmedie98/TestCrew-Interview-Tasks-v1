package Task4;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class Task4 {


    @Test
    public void setUP() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\Documents\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/tooltip/");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
        WebElement element = driver.findElement(By.id("age"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        WebElement toolTipElement = driver.findElement(By.cssSelector(".ui-tooltip"));
        String toolTipText = toolTipElement.getText();
        System.out.println("The Tooltip Text is: "+toolTipText);


    }
}


