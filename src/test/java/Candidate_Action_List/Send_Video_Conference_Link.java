package Candidate_Action_List;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Send_Video_Conference_Link {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		// Navigate to the login page
		driver.navigate().to("https://xdev.recruitbpm.com/users/login");

		// Find the email and password input fields and enter the credentials
		driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.className("menutoggle")).click(); // Menu Button
		driver.findElement(By.linkText("Candidates")).click(); // Candidates Tab
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Asghar", Keys.ENTER); // First Name Search Box
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Zaidi", Keys.ENTER); // Last Name Search Box
		driver.findElement(By.linkText("Asghar")).click(); // Candidate Link Text
		driver.findElement(By.xpath("//*[@data-original-title='Send Video Conference Link']")).click(); // Click on Send Video Conference Link Icon
		
		driver.findElement(By.xpath("//*[@name='video_conference_recipients[]' and @class='form-control']")).click(); // Video Conference Recipients
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@name='candidate_name']")))).sendKeys("Asghar", Keys.ENTER); // Candidate Name
		driver.findElement(By.xpath("//*[@value='Asghar Zaidi']")).isSelected(); // CheckBox 
		driver.findElement(By.xpath("//*[@data-dismiss='modal' and text()='Add & Close']")).click(); // Add and Close Button
		
		Select template = new Select(driver.findElement(By.className("userEmailTemplatesListonboarding_email_templates")));
		template.selectByVisibleText("Template 3");
		Select Tag = new Select(driver.findElement(By.className("emailTemplateTagsList")));
		Tag.selectByVisibleText("Recipient Name");
		
		driver.findElement(By.xpath("//*[@name='submit' and text()='Send']")).click();
		
		

	}

}
