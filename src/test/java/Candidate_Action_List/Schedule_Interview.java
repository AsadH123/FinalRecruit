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

public class Schedule_Interview {

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
		driver.findElement(By.linkText("Candidates")).click(); // Candidates Tab
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Asghar", Keys.ENTER); // First Name Search Box
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Zaidi", Keys.ENTER); // Last Name Search Box
		driver.findElement(By.linkText("Asghar")).click(); // Candidate Link Text
		driver.findElement(By.xpath("//*[@data-original-title='Schedule Interview']")).click(); // Click on Schedule Interview Icon
		
		Select noteType = new Select(driver.findElement(By.id("note_type_id")));
		noteType.selectByVisibleText("Note"); // Note Type
		Select interviewType = new Select(driver.findElement(By.xpath("//*[@name='communication_method']")));
		interviewType.selectByVisibleText("In Person"); // Interview Type
		WebElement appointmentTitle = driver.findElement(By.id("appointment_title"));
		appointmentTitle.sendKeys("Test Title"); // Title
		WebElement chkbox = driver.findElement(By.id("is_sms_interview_link"));
		chkbox.isSelected();
		WebElement Interview_type = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[@name='communication_method']"))));
		Select select = new Select(Interview_type);
		select.selectByVisibleText("In Person"); // Interview Type
		driver.findElement(By.id("appointment_title")).sendKeys("Technical Interview"); // Appointment Title
		jsexecutor.executeScript("window.scrollBy(0, 500);");
		WebElement DatePickerElement = driver.findElement(By.id("s_date")); // Set Date
		DatePickerElement.click();
		List<WebElement> date = driver.findElements(By.xpath("//*[@data-handler='selectDay']"));
		for (WebElement element1 : date) {
			if (element1.getText().equals("25")) {
				element1.click();
				break;
			}
		}
		WebElement TimePickerElement = driver.findElement(By.id("timepicker1666")); // Set Time
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
		jsexecutor.executeScript("window.scrollBy(0, 500);");
		WebElement JobOrder_Reference = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.id("select2-appointment_job_id-container")))); // Job Order
		JobOrder_Reference.click();
		WebElement JO_SearchBox = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[@class='select2-search__field']"))));
		JO_SearchBox.sendKeys("Automation Job");
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[@class='select2-results__options']")))).click();
		driver.findElement(By.xpath("//*[@type='submit' and text()='Save']")).click();
	}

}
