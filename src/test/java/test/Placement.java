package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Placement {

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
		
		driver.findElement(By.xpath("//*[@class='hidden-xs' and text()='New']")).click(); // New Link Text
		driver.findElement(By.linkText("Placement")).click(); // Click Link Text Placement
		Thread.sleep(2000);
		
		driver.findElement(By.id("select2-job_id-container")).click(); // Job Order
		driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("Selenium Java"); 
		Thread.sleep(2000);
		driver.findElement(By.id("select2-job_id-results")).click();
		
		driver.findElement(By.id("select2-candidate_ids-container")).click();
		String candidate_text = "Testing Candidate 2";
		driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys(candidate_text, Keys.ENTER);
		
		driver.findElement(By.id("joining_date"));
		


	}

}
