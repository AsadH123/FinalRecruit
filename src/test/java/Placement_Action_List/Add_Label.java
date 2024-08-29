package Placement_Action_List;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Add_Label {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		// Navigate to the login page
		driver.navigate().to("https://xdev.recruitbpm.com/users/login");
		
	    // Find the email and password input fields and enter the credentials
		driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.className("menutoggle")).click(); // Menu Button
		driver.findElement(By.linkText("Placements")).click(); // Placements Tab
		Thread.sleep(2000);
				
		driver.findElement(By.xpath("//*[@placeholder='Job Title']")).sendKeys("Data Scientists", Keys.ENTER); // Job Title Search Box
		driver.findElement(By.xpath("//*[@placeholder='Candidate']")).sendKeys("Danny Elba", Keys.ENTER); // Candidate Search Box
		driver.findElement(By.linkText("Data Scientists")).click(); // Link Text
		
		driver.findElement(By.xpath("//*[@data-original-title='Hotlist']")).click(); // Click on Hotlist Icon
		driver.findElement(By.xpath("//*[button='Add Label']")).click(); // Add Label Button
		driver.findElement(By.id("hotlist_name")).sendKeys("Asad Automation"); // HotList Name
		WebElement chkbox = driver.findElement(By.id("is_public")); // CheckBox for Public
		jsExecutor.executeScript("arguments[0].click();", chkbox);
		driver.findElement(By.id("btn-hotlist-labels")).click(); // Save Button		
	}

}
