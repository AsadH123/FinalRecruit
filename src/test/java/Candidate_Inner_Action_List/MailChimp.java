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

public class MailChimp {
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
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[12]/a")).click(); // MailChimp
    
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[1]/div/div/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Testing List");
        Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@name='contact[company]']")).sendKeys("Testing Company Inner Listing");
		driver.findElement(By.xpath("//*[@name='contact[address1]']")).sendKeys("ABC");
		driver.findElement(By.xpath("//*[@name='contact[city]']")).sendKeys("Arkansas");
		driver.findElement(By.xpath("//*[@name='contact[state]']")).sendKeys("Arkansas");
		driver.findElement(By.xpath("//*[@name='contact[zip]']")).sendKeys("442020");
		driver.findElement(By.xpath("//*[@name='contact[city]']")).sendKeys("Arkansas");

		driver.findElement(By.xpath("//*[@name='campaign_defaults[from_name]']")).sendKeys("Asad");
		driver.findElement(By.xpath("//*[@name='campaign_defaults[from_email]']")).sendKeys("asad0900@yopmail.com");
		driver.findElement(By.xpath("//*[@name='permission_reminder']")).sendKeys("ABC");
		
		driver.findElement(By.xpath("//*[@id=\"createmclistfrm\"]/div[2]/button[1]")).click();
    }
}
