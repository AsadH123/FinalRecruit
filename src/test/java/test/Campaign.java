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

public class Campaign {

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
		driver.findElement(By.linkText("Campaign")).click(); // CLick Link Text Campaign
		
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@placeholder='Campaign Name']"))));
		driver.findElement(By.xpath("//*[@placeholder='Campaign Name']")).sendKeys("Testing Campaign No 2"); // Campaign Name
		driver.findElement(By.id("To")).click(); // Click on To
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@placeholder='Candidate']"))));
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@placeholder='Candidate']")).sendKeys("Asghar", Keys.ENTER); // Enter Candidate Name
		Thread.sleep(1000);
		WebElement chkbox = driver.findElement(By.id("4_1842")); // CheckBox Click
		jsExecutor.executeScript("arguments[0].click();", chkbox);
		driver.findElement(By.xpath("//*[@data-dismiss='modal' and text()='Add & Close']")).click(); // Add & Close Button
		
		driver.findElement(By.xpath("//*[@placeholder='Subject']")).sendKeys("Campaign Subject"); // Enter Subject
		Thread.sleep(1000);
		Select salutation = new Select(driver.findElement(By.id("salut"))); // Salutation Dropdown
		salutation.selectByIndex(2);
		
		WebElement message_iframe = driver.findElement(By.className("cke_wysiwyg_frame")); // Message in Iframe
		driver.switchTo().frame(message_iframe);
		WebElement message = driver.findElement(By.cssSelector("body.cke_show_borders")); // Message body
		message.sendKeys("This is a campaign email message body");
		driver.switchTo().defaultContent(); // Outside IFrame
		
		driver.findElement(By.xpath("//*[@name='btnSend']")).click();


		
		
		

		
		
		
		

	}

}
