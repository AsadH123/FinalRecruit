package Company_Action_List;

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
		driver.findElement(By.linkText("Companies")).click(); // Job Orders Tab
		Thread.sleep(2000);

		// Click on companies in which user wants to click reminder button

		List<WebElement> company_table = driver.findElements(By.cssSelector("table#table2 tr td a"));

		for (WebElement element : company_table) {
 
			if (element.getText().equals("Asad Tech")) {
				element.click();
				break;
			}
		}
		driver.findElement(By.xpath("//*[@data-original-title='Assign Tags']")).click();
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
