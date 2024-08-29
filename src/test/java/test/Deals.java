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

public class Deals {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.linkText("Opportunity")).click(); // CLick Link Text Deal
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@placeholder='Opportunity']")))); // Opportunity Name
		driver.findElement(By.xpath("//*[@placeholder='Opportunity']")).sendKeys("Testing Opportuities");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("select2-selection__placeholder")))).click(); // Company click
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("select2-search__field")))).sendKeys("Automated Company"); // company dropdown click
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("select2-company_id-results")))).click(); // Result Click
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"frmMain\"]/div[1]/div[2]/div[5]/div/span/span[1]/span")))).click(); // Contact Click
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("select2-search__field")))).sendKeys("Asad Test"); // Contact dropdown click
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("select2-contact_id-results")))).click(); // Result Click
		
		Thread.sleep(2000);
		Select status = new Select(driver.findElement(By.xpath("//*[@name='module_status_id']"))); // Status Dropdown
		status.selectByVisibleText("Open");
		Select level = new Select(driver.findElement(By.id("level_id"))); // Level Dropdown
		level.selectByVisibleText("Medium");
		Select probability = new Select(driver.findElement(By.xpath("//*[@name='probability_id']"))); // Probability Dropdown
		probability.selectByIndex(3);
		Select industry = new Select(driver.findElement(By.id("industry"))); // Industry Dropdown
		industry.selectByIndex(5);
		Select source = new Select(driver.findElement(By.xpath("//*[@name='pipeline_source']"))); // Source Dropdown
		source.selectByIndex(4);
		driver.findElement(By.xpath("//*[@name='pipeline_value']")).sendKeys("100"); // Enter Value
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"frmMain\"]/div[2]/div[5]/div/div/button")).click(); // Technology Dropdown
		driver.findElement(By.xpath("//*[@id=\"frmMain\"]/div[2]/div[5]/div/div/ul/li[1]/div/input")).sendKeys("Active Directory"); // Technology Search
		Thread.sleep(2000);
		WebElement chkbox_technology = driver.findElement(By.xpath("//*[@type='checkbox' and @value='40' ]")); // CheckBox Click
		chkbox_technology.click();
		//jsExecutor.executeScript("arguments[0].click();", chkbox_technology);
		
		WebElement message_iframe = driver.findElement(By.className("cke_wysiwyg_frame")); // Message in Iframe
		driver.switchTo().frame(message_iframe);
		WebElement message = driver.findElement(By.cssSelector("body.cke_show_borders")); // Message body
		message.click();
		message.sendKeys("This is a deals mail message body");
		driver.switchTo().defaultContent(); // Outside IFrame
		
		driver.findElement(By.xpath("//*[@placeholder='Address']")).sendKeys("Testing Address");
		driver.findElement(By.xpath("//*[@placeholder='City']")).sendKeys("Dallas Texas");
		
		driver.findElement(By.id("select2-state_name-container")).click();
		driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Texas");
		driver.findElement(By.id("select2-state_name-results")).click();
		driver.findElement(By.xpath("//*[@name='zipcode']")).sendKeys("44000");
		
		driver.findElement(By.id("pipeline_submit")).click();
		
		
		
		

		
	}

}