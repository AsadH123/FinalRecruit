package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vendors {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		driver.manage().window().maximize();
		// Navigate to the login page
		driver.navigate().to("https://xdev.recruitbpm.com/users/login");
		
	    // Find the email and password input fields and enter the credentials
		driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.xpath("//*[@class='hidden-xs' and text()='New']")).click(); // New Link Text
		driver.findElement(By.linkText("Vendor")).click(); // Click Link Text Vendor
		
		driver.findElement(By.xpath("//*[@name='vendor_name']")).sendKeys("Testing Vendor"); // Vendor Name
		driver.findElement(By.xpath("//*[@name='vendor_email']")).sendKeys("test111@yopmail.com"); // Vendor Email
		driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("Asad"); // First Name
		driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys("Haider"); // Last Name
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("test222@yopmail.com"); // Email
		driver.findElement(By.xpath("//*[@name='job_title']")).sendKeys("Testing"); // Job Title
		
		driver.findElement(By.id("vendor_submit")).click(); // Submit
		


	}

}
