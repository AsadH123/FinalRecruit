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

public class Invoice {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.linkText("Invoice")).click(); // Click Link Text Invoice
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#select2-invoice_company_id-container")).click(); // Company
		driver.findElement(By.className("select2-search__field")).sendKeys("Testing Comp 1");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-invoice_company_id-results")).click();
		
		driver.findElement(By.id("select2-invoice_job_id-container")).click(); // Job Order
		driver.findElement(By.className("select2-search__field")).sendKeys("Testing Job 1");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-invoice_job_id-results")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#select2-invoice_candidate_id-container")).click(); // Employee Name
		driver.findElement(By.className("select2-search__field")).sendKeys("New Candid");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-invoice_candidate_id-results")).click();
		
		Thread.sleep(2000);
		WebElement invoicingTerm = driver.findElement(By.id("invoicing_term_id")); // Invoicing Term
		Select invoicing_Term = new Select(invoicingTerm);
		invoicing_Term.selectByVisibleText("Net 10");
		
		driver.findElement(By.id("invoice_date")).click(); // Invoice Date
		driver.findElement(By.className("ui-datepicker-today")).click();
		
		driver.findElement(By.id("due_date")).click(); // Due Date
		driver.findElement(By.className("ui-datepicker-today")).click();
		
		driver.findElement(By.id("from_address")).sendKeys("Testing"); // Address
		driver.findElement(By.id("to_address")).sendKeys("Testing"); // Billing Address
		
		driver.findElement(By.id("invoice_submit")).click(); // Submit
		
		
		
		
		
		
	}

}
