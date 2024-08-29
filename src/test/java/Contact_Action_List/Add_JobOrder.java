package Contact_Action_List;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_JobOrder {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Scanner input = new Scanner(System.in);
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
		driver.findElement(By.linkText("Contacts")).click(); // Contacts Tab
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Asghar", Keys.ENTER); // First Name Search Box
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Zaidi", Keys.ENTER); // Last Name Search Box
		
		driver.findElement(By.linkText("Asghar")).click(); // Contact Link Text 
		driver.findElement(By.xpath("//*[@data-original-title='Add Job Order']")).click(); // Click JobOrder icon
		driver.findElement(By.xpath("//*[@data-original-title='job_title']")).sendKeys("Selenium Java"); // Enter Job Title
		Select select = new Select(driver.findElement(By.id("job_priority_id"))); // Select Job Priority
		select.selectByVisibleText("D-Direct Hire");
		Select select1 = new Select(driver.findElement(By.id("module_status_id"))); // Select Status
		select1.selectByVisibleText("Offer Out");
		driver.findElement(By.xpath("//*[@name='pay_rate']")).sendKeys("100$");
		jsexecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		driver.findElement(By.id("company_submit")).click();
		

		
		

	}

}
