package Onboarding_Action_List;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Copy_Video_Questionaire {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
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
		driver.findElement(By.linkText("Onboarding")).click(); // Onboarding Tab
		Thread.sleep(2000);
		// Click on job orders in which user wants to click reminder button

		driver.findElement(By.xpath("//*[@placeholder='Job Title']")).sendKeys("Db Engr", Keys.ENTER); // Job Title Search Box
		driver.findElement(By.xpath("//*[@placeholder='Candidate']")).sendKeys("Edward Tim", Keys.ENTER); // Candidate Search Box
		driver.findElement(By.linkText("DB Engr")).click(); // Link Text
		
		driver.findElement(By.xpath("//*[@data-original-title='Copy Video Questionnaire']")).click(); // Click on Copy Video Questionnaire Icon
		Thread.sleep(2000);
		WebElement questionnarieDropdown = driver.findElement(By.id("select2-job_id-container"));
		questionnarieDropdown.click();
		Thread.sleep(2000);
		WebElement searchJob = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='select2-search__field']"))));
		searchJob.sendKeys("Data Scientists");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-job_id-results")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@name='save']")).click();

	}

}