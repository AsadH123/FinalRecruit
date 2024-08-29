package Candidate_Action_List;

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

public class Request_Information {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
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
		driver.findElement(By.linkText("Asghar")).click(); // Contact Link Text
		driver.findElement(By.xpath("//*[@data-original-title='Request Information']")).click(); // Click on Request Information Icon
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("salut"))));
		Select salutation = new Select(driver.findElement(By.id("salut"))); // Salutations
		salutation.selectByIndex(2);
		Select template = new Select(driver.findElement(By.id("email_template_id"))); // Template
		template.selectByVisibleText("My first email template");
		WebElement request = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("select2-request_id-container")))); // Request
		request.click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='select2-search__field']")))).sendKeys("Candidate Details");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='select2-request_id-results']")))).click();
		
		jsExecutor.executeScript("window.scrollBy(0, 1000);");
		driver.findElement(By.xpath("//*[@name='btnSend']")).click(); // Send Button
		
	}

}
