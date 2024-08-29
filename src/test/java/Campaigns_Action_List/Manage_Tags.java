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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Manage_Tags {

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

		driver.findElement(By.xpath("//*[@placeholder='Campaign Name']")).sendKeys("Test Campaign No 1", Keys.ENTER); // First Name
		// Search Box
		//driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Zaidi", Keys.ENTER); // Last Name Search
		// Box
		driver.findElement(By.linkText("Test Campaign No 1")).click(); // Candidate Link Text
		driver.findElement(By.xpath("//*[@data-original-title='Assign Tags']")).click(); // Click on Add Note Icon
		Thread.sleep(2000);
		driver.findElement(By.linkText("Manage Tags")).click(); // Link Button
		driver.findElement(By.cssSelector("i span.add-category")).click(); // Add Category button
		driver.findElement(By.xpath("//*[@name='tag_category']")).sendKeys("ILETS"); // Input field
		driver.findElement(By.xpath("//*[@type='submit' and text()='Add Category']")).click(); // Save Category
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div/div/div[2]/ul[5]/div/div/div[2]/a[1]")).click(); // Add Sub Category
		Thread.sleep(1000);
		WebElement subTagName = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@name='tag_item']"))));
		subTagName.sendKeys("Listening Catrgory");
		driver.findElement(By.xpath("//*[@type='submit' and text()='Add Tag']")).click();
		jsexecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		driver.findElement(By.id("btnDoneManageTags")).click(); // Done Manage Tags

	}

}
