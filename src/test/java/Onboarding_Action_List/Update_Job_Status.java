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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Update_Job_Status {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

		driver.findElement(By.xpath("//*[@placeholder='Job Title']")).sendKeys("DB Engr", Keys.ENTER); // Job Title Search Box
		driver.findElement(By.xpath("//*[@placeholder='Candidate']")).sendKeys("Edward Tim", Keys.ENTER); // Candidate Search Box
		driver.findElement(By.linkText("DB Engr")).click(); // Link Text
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("li a.dropdown-toggle i.fa-ellipsis-h")).click(); // Click on More Icon
		List <WebElement> more_drop = driver.findElements(By.cssSelector("ul.dropdown-menu li a span"));
		Thread.sleep(1000);
		for(WebElement element: more_drop) {
			if(element.getText().equals("Update Job Status")) {
				element.click();
				break;
			}
		}
		Thread.sleep(2000);
		System.out.println("Console logsssss");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@name='module_status_id[]' and @id='module_status_id[]']"))));
		Select select = new Select(driver.findElement(By.id("module_status_id[]")));
		Thread.sleep(1000);
		select.selectByVisibleText("On Hold");
		driver.findElement(By.id("comments[]")).sendKeys("Testing update status");
		//driver.findElement(By.xpath("//*[@type='reset']")).click();
		driver.findElement(By.id("submit")).click();

	}

}
