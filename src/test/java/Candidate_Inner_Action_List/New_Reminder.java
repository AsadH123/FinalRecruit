package Candidate_Inner_Action_List;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class New_Reminder {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        // Navigate to the login page
        driver.navigate().to("https://xdev.recruitbpm.com/users/login");
           
        // Find the email and password input fields and enter the credentials
        driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("submit")).click();
           
        driver.findElement(By.cssSelector("div a.menutoggle")).click();
        Thread.sleep(2000);
           
        driver.findElement(By.cssSelector("li[data-sort='6'] a.activeAncher span i.dropdown-chevron")).click();
        driver.findElement(By.className("candidates_listing")).click();
        Thread.sleep(2000);
           
        driver.findElement(By.xpath("//*[@id=\"table2_wrapper\"]/div[3]/div[3]/div[2]/div/table/tbody/tr[5]/td[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[13]/a")).click(); // New Reminder

        driver.findElement(By.xpath("//*[@name='reminder_description']")).sendKeys("Testing Reminder description");
		
		driver.findElement(By.id("reminder_date")).click();
		driver.findElement(By.className("ui-datepicker-today")).click();
		Thread.sleep(2000);
		WebElement reminderTime = driver.findElement(By.id("reminder_time"));
		reminderTime.click();
		reminderTime.clear();
		
		WebElement hour = driver.findElement(By.xpath("//*[@name='hour']"));
		hour.clear();
		hour.sendKeys("03");
		WebElement minute = driver.findElement(By.xpath("//*[@name='minute']"));
		minute.clear();
		minute.sendKeys("30");
		WebElement meridian = driver.findElement(By.xpath("//*[@name='meridian']"));
		meridian.clear();
		meridian.sendKeys("PM");
		
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
    }
}
