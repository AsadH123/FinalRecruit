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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Schedule_Meeting {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
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

		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Asghar", Keys.ENTER); // First Name Search Box
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Zaidi", Keys.ENTER); // Last Name Search Box
		driver.findElement(By.linkText("Asghar")).click(); // Contact Link Text
		driver.findElement(By.xpath("//*[@data-original-title='Schedule Meeting']")).click(); // Click on Schedule Appointment Icon
		Thread.sleep(1000);

		WebElement Interview_type = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[@name='communication_method']"))));
		Select select = new Select(Interview_type);
		select.selectByVisibleText("In Person"); // Interview Type
		driver.findElement(By.id("appointment_title")).sendKeys("Technical Interview"); // Appointment Title
		WebElement DatePickerElement = driver.findElement(By.id("s_date")); // Set Date
		DatePickerElement.click();
		List<WebElement> date = driver.findElements(By.xpath("//*[@data-handler='selectDay']"));
		for (WebElement element1 : date) {
			if (element1.getText().equals("25")) {
				element1.click();
				break;
			}
		}
		WebElement TimePickerElement = driver.findElement(By.id("timepicker1667")); // Set Time
		TimePickerElement.click();
		WebElement hour = driver.findElement(By.xpath("//*[@name='hour']"));
		hour.clear();
		hour.sendKeys("11"); // Hour
		WebElement minute = driver.findElement(By.xpath("//*[@name='minute']"));
		minute.clear();
		minute.sendKeys("25"); // Minute
		WebElement meridian = driver.findElement(By.xpath("//*[@name='meridian']"));
		meridian.clear();
		meridian.sendKeys("AM"); // AM PM
		jsExecutor.executeScript("window.scrollBy(0, 500);");
		WebElement JobOrder_Reference = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.id("select2-appointment_job_id-container")))); // Job Order
		JobOrder_Reference.click();
		WebElement JO_SearchBox = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[@class='select2-search__field']"))));
		JO_SearchBox.sendKeys("Automation Job");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[@class='select2-results__options']")))).click();
		jsExecutor.executeScript("window.scrollBy(0, 700);");
		driver.findElement(By.id("init_recipient_modal")).click(); // Attendees
		WebElement candidate = driver.findElement(By.xpath("//*[@name='candidate_name']")); // Candidate Name
		candidate.sendKeys("Asghar", Keys.ENTER);
		WebElement chkbox = driver.findElement(By.xpath("//*[@value='Asghar Zaidi']")); // CheckBox
		chkbox.isSelected();
		driver.findElement(By.xpath("//*[@data-dismiss='modal' and text()='Add & Close']")).click(); // Add Button

		driver.findElement(By.xpath("//*[@name='btnSave']")).click();
	}

}