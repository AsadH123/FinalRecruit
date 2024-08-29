package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class company {
	
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	// Navigate to the login page
	driver.navigate().to("https://xdev.recruitbpm.com/users/login");
	
    // Find the email and password input fields and enter the credentials
	driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.id("submit")).click();
	
	//Add Single New Company
	driver.findElement(By.xpath("/html/body/section[1]/div[2]/div[1]/ul/li[1]/div/button")).click();
	driver.findElement(By.id("companies_listing")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@name='company_name']")).sendKeys("testing Company 01"); // Company Name
	
	WebElement status = driver.findElement(By.xpath("//*[@name='module_status_id']")); // Company Status
	Select select = new Select(status);
	select.selectByVisibleText("Pipeline"); // Status
	driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("090078601"); // Phone Number
	driver.findElement(By.xpath("//*[@name='phone_ext']")).sendKeys("123"); // Phone Number ext
	driver.findElement(By.xpath("//*[@name='website_url']")).sendKeys("https://xdev.recruitbpm.com/"); // Phone Number ext
	
	driver.findElement(By.id("company_submit")).click(); // Save button
	
	}
}
