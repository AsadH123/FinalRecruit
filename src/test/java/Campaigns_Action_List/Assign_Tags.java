package Campaigns_Action_List;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assign_Tags {

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
		driver.findElement(By.linkText("Campaigns")).click(); // Campaigns Tab
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//*[@placeholder='Campaign Name']")).sendKeys("Test Campaign No 1", Keys.ENTER); // First Name Search Box
		//driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Zaidi", Keys.ENTER); // Last Name Search Box
		driver.findElement(By.linkText("Test Campaign No 1")).click(); // Candidate Link Text
		driver.findElement(By.xpath("//*[@data-original-title='Assign Tags']")).click(); // Click on Add Note Icon
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@placeholder='search tags']")).sendKeys("IELTS", Keys.ENTER); // Search Box
		WebElement chkbox = driver.findElement(By.xpath("//*[@value='746']")); // Every CheckBox has a unique value_id
        jsexecutor.executeScript("arguments[0].click();", chkbox);
		driver.findElement(By.id("assignTagsToItems")).click();
	}
	
}
