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

public class Send_Exclusive_Request {

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
		driver.findElement(By.xpath("//*[@data-original-title='Send Exclusive Request']")).click(); // Click on Send Exclusive Request Icon
		
		Thread.sleep(1000);
		Select salutation = new Select(driver.findElement(By.id("salut")));
		salutation.selectByIndex(2);
		Select template = new Select(driver.findElement(By.id("email_template_id")));
		template.selectByVisibleText("Template 3");
		
		driver.findElement(By.id("select2-exclusive_request_job_id-container")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='select2-search__field']")))).sendKeys("Automation Job");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='select2-exclusive_request_job_id-results']")).click(); // Job Order
		driver.findElement(By.xpath("//*[@name='btnSend']")).click(); // Send Button
	}

}
