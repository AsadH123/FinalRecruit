package JobOrder_Action_List;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bulk_Email {

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
		driver.findElement(By.linkText("Job Orders")).click(); // Job Orders Tab
		Thread.sleep(2000);

		// Click on job orders in which user wants to click reminder button

		List<WebElement> JobTitles = driver.findElements(By.cssSelector("table#table2 tbody tr td a.item-detail-linkedin-view"));
		for (WebElement element : JobTitles) {
			if (element.getText().equals("Selenium Java")) {
				element.click();
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-original-title='Send Email']")).click(); // Click on Send Email Icon
		Select select = new Select(driver.findElement(By.id("new-email")));
		select.selectByVisibleText("Bulk Email");
		driver.findElement(By.xpath("//*[@placeholder='Subject']")).sendKeys("Automation Email");
		driver.findElement(By.xpath("//*[@name='btnSend']")).click();

		 


	}

}