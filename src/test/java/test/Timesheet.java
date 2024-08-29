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

public class Timesheet {

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
		driver.findElement(By.linkText("Timesheet")).click(); // Click Link Text Placement
		Thread.sleep(2000);
		
		// Day View
		
		driver.findElement(By.cssSelector("ul li a[data-url='/timesheets/add?viewType=day']")).click(); // Day view
		Thread.sleep(2000);
		WebElement employee = driver.findElement(By.xpath("//*[@id=\"time-sheet-add-form\"]/div[2]/div[2]/span/span[1]/span")); // Employee
		employee.click();
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(employee));
//		element.click();
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", employee);
		driver.findElement(By.className("select2-search__field")).sendKeys("New Candid");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-time-module-add-form-candidate-id-results")).click();
		
		WebElement Job = driver.findElement(By.id("time-sheet-job-id")); // Job
		Select select = new Select(Job); // Job
		select.selectByVisibleText("Testing Job 1");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@name='log_date']")).click(); // Date
		driver.findElement(By.className("ui-datepicker-today")).click();
		
		WebElement time = driver.findElement(By.xpath("//*[@name='dayViewFieldsetCollection[0][log_type]']")); // Time Type
		Select timeType = new Select(time);
		timeType.selectByVisibleText("Standard Time");
		
		driver.findElement(By.xpath("//*[@name='dayViewFieldsetCollection[0][log_hours]']")).sendKeys("1");
		driver.findElement(By.className("time-module-add-form-dayview-add-row")).click();
		
		driver.findElement(By.xpath("//*[@name='submit']")).click();
		
	}

}
