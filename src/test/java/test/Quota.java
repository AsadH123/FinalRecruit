package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Quota {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		driver.findElement(By.cssSelector("li[data-sort='2'] a.activeAncher span i.dropdown-chevron")).click();
		
		driver.findElement(By.cssSelector("li.quotas_listing ")).click();
		driver.findElement(By.xpath("//*[@title='More Items']")).click();
		driver.findElement(By.xpath("//*[@href='/quotas/add']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='quota_title']")).sendKeys("Testing Quota");
		//driver.findElement(By.xpath("//*[@id='select2-quota_user[]-dl-container' and @class='select2-selection__rendered']")).click();
		driver.findElement(By.className("select2-selection__rendered")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("adeelkazmi");
		Thread.sleep(2000);
		driver.findElement(By.className("select2-results__options")).click();
		
		driver.findElement(By.xpath("//*[@name='quota_user_amount[]']")).sendKeys("12");
		driver.findElement(By.xpath("//*[@name='quota_user_deals[]']")).sendKeys("12");
		
		driver.findElement(By.xpath("//*[@id=\"misc_Info\"]/div/div[2]/div/button")).click();
		
		

		
	}

}
