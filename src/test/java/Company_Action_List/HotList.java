package Company_Action_List;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.Timeout;

public class HotList {

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
		driver.findElement(By.linkText("Companies")).click(); // Companies Tab
		Thread.sleep(2000);

		// Click on company in which user wants to add hotlist

		List<WebElement> company_table = driver.findElements(By.cssSelector("table#table2 tr td a"));

		for (WebElement element : company_table) {

			if (element.getText().equals("Asad Tech")) {
				element.click();
				break;
			}
		}
		driver.findElement(By.xpath("//*[@data-original-title='Hotlist']")).click(); // Click on Hotlist Icon
		Thread.sleep(3000);
		List<WebElement> companies_hotlist = driver.findElements(By.cssSelector("tbody#hotlist-listing-table td span.hotlist-item"));
		System.out.println(companies_hotlist.size());


		for (WebElement element : companies_hotlist) {
			if (element.getText().equals("import list1")) {
            	System.out.println(element.getText());
				element.findElement(By.xpath("//*[@value='395']")).click();
				break;
			}
		}
		driver.findElement(By.id("btn-hotlist-items")).click();

	}

}
