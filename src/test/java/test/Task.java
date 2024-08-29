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

public class Task {
	
	public static void main (String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Dimension dimension = new Dimension(1500, 1776);
		driver.manage().window().setSize(dimension);
		// Navigate to the login page
		driver.navigate().to("https://xdev.recruitbpm.com/users/login");
		
	    // Find the email and password input fields and enter the credentials
		driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.xpath("//*[@class='hidden-xs' and text()='New']")).click(); // New Link Text
		driver.findElement(By.linkText("Task")).click(); // Click Link Text Task
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement taskType = driver.findElement(By.xpath("//*[@name ='task_type']")); // Task type
		Select task_Type = new Select(taskType);
		task_Type.selectByVisibleText("Meeting");
		
		WebElement privateChk = driver.findElement(By.xpath("//*[@name='is_private' and @type='checkbox']")); // private checkbox
		if(!privateChk.isSelected())
			privateChk.click();
		
		driver.findElement(By.id("task_title")).sendKeys("Testing Task"); // Task Title
		WebElement description_iframe = driver.findElement(By.className("cke_wysiwyg_frame"));
		driver.switchTo().frame(description_iframe); // Switch to IFrame
		WebElement inside_iframe = driver.findElement(By.xpath("/html/body"));
		inside_iframe.sendKeys("Testing Task"); // Profile Summary
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//*[@name='btnSave']")).click();
		
	}

}
