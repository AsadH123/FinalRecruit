package Candidate_Action_List;

import java.time.Duration;
import java.util.List;
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

public class Reference_Check {

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

		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Asghar", Keys.ENTER); // First Name
																										// Search Box
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Zaidi", Keys.ENTER); // Last Name Search
																										// Box
		driver.findElement(By.linkText("Asghar")).click(); // Candidate Link Text
		driver.findElement(By.cssSelector("ul.vertical-menu li a.dropdown-toggle")).click(); // Click on DropDown Toggle
		// Menu Icon

		List<WebElement> vertical_sub_menu = driver.findElements(By.cssSelector("ul.vertical-submenu li a ")); // Vertical
		// SubMenu
		for (WebElement element : vertical_sub_menu) {
			if (element.getText().equals("Reference Check")) {
				element.click();
				break;
			}
		}
		WebElement references = driver.findElement(By.id("references_required")); // No.of References
		references.clear();
		references.sendKeys("2");
		
		Select questionnaire = new Select(driver.findElement(By.id("reference_questionnaire_id"))); // Questionnaire
		questionnaire.selectByVisibleText("Alpha");
		driver.findElement(By.id("select2-reference_request_job_id-container")).click(); //Job Order
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='select2-search__field']")))).sendKeys("Automation Job");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='select2-reference_request_job_id-results']")).click();
		//jsexecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement sentBtn = driver.findElement(By.xpath("//*[@name='btnSend']"));
		wait.until(ExpectedConditions.elementToBeClickable(sentBtn));
		sentBtn.click();
		
	}

}
