package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Contacts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
		driver.manage().window().maximize();
		// Navigate to the login page
		driver.navigate().to("https://xdev.recruitbpm.com/users/login");
		
	    // Find the email and password input fields and enter the credentials
		driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();
		
		//Add Single New Contact
		driver.findElement(By.xpath("/html/body/section[1]/div[2]/div[1]/ul/li[1]/div/button")).click(); // Menu Button
		driver.findElement(By.id("contacts_listing")).click(); // Contact Listing
		driver.findElement(By.id("addcontactfn")).sendKeys("Hassan"); // First Name
		driver.findElement(By.id("addcontactln")).sendKeys("Haider"); // Last Name
		driver.findElement(By.id("email1")).sendKeys("hassan3333@yopmail.com"); // Email
		driver.findElement(By.id("addcontactjt")).sendKeys("Senior SQA Engineer"); // Job Title
		WebElement company = driver.findElement(By.id("select2-company_id-container")); 
		company.click();
		WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='select2-search__field']")));
		input.sendKeys("Automated Company");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-company_id-results")).click(); // Company
		driver.findElement(By.xpath("//*[@value='Save']")).click(); // Save Button


		
	}

}
