package Contact_Action_List;

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
		driver.findElement(By.linkText("Contacts")).click(); // Contacts Tab
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Asghar", Keys.ENTER); // First Name Search Box
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Zaidi", Keys.ENTER); // Last Name Search Box
		driver.findElement(By.linkText("Asghar")).click(); // Contact Link Text
		driver.findElement(By.cssSelector("li a.dropdown-toggle i.fa-ellipsis-h")).click(); // Click on More Icon
		List <WebElement> more_drop = driver.findElements(By.cssSelector("ul.dropdown-menu li a.tags-popup"));
		Thread.sleep(1000);
		for(WebElement element: more_drop) {
			if(element.getText().equals("Assign Tags")) { 
				element.click();
				break;
			}
		}
		//driver.findElement(By.cssSelector("div#hacktags div input.filter_tags")).sendKeys("Test", Keys.ENTER); // Search Box
		Thread.sleep(1000);
		WebElement scrollToCategory = driver.findElement(By.id("ilets_724"));
        jsexecutor.executeScript("arguments[0].scrollIntoView();", scrollToCategory);
        Thread.sleep(1000);
        WebElement chkbox = driver.findElement(By.xpath("//*[@value='726']"));
        jsexecutor.executeScript("arguments[0].click();", chkbox);
		driver.findElement(By.id("assignTagsToItems")).click();
	}
	
}