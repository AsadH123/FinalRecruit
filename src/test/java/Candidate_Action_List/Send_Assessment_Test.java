package Candidate_Action_List;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Send_Assessment_Test {

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
		driver.findElement(By.xpath("//*[@data-original-title='Send Assessment Test']")).click(); // Click on Send Assessment Test Icon
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='assessment_id']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@value='221312e5be7a5066____Demo 1']"))));
		driver.findElement(By.xpath("//*[@value='221312e5be7a5066____Demo 1']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("select2-assessment_job_id-container")))).click(); // Job Order
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='select2-search__field']")))).sendKeys("Automation Job");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='select2-assessment_job_id-results']")).click();
		WebElement btn = driver.findElement(By.xpath("//*[@value='Send']")); // Send Button
        action.moveToElement(btn).perform();
        wait.until(ExpectedConditions.elementToBeClickable(btn));
        btn.click();


	}

}
