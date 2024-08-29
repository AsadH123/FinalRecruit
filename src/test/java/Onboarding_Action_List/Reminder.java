package Onboarding_Action_List;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reminder {

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
		driver.findElement(By.linkText("Onboarding")).click(); // Onboarding Tab
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@placeholder='Job Title']")).sendKeys("DB Engr", Keys.ENTER); // Job Title Search Box
		driver.findElement(By.xpath("//*[@placeholder='Candidate']")).sendKeys("Edward Tim", Keys.ENTER); // Candidate Search Box
		driver.findElement(By.linkText("DB Engr")).click(); // Link Text
		
		driver.findElement(By.xpath("//*[@data-original-title='Reminder']")).click(); // Click on Reminder Icon
		driver.findElement(By.xpath("//*[@name='reminder_description']")).sendKeys("Test Reminder"); // Reminder Description
		WebElement DatePickerElement = driver.findElement(By.id("reminder_date")); // Set Date
		DatePickerElement.click();
        List<WebElement> date = driver.findElements(By.xpath("//*[@data-handler='selectDay']"));
        for(WebElement element: date) {
        	if(element.getText().equals("25")) {
        		System.out.println(element.getText());
        		element.click();
        		break;
        	}
        }
		WebElement TimePickerElement = driver.findElement(By.id("reminder_time")); // Set Time
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
		
		driver.findElement(By.id("submit")).click(); // Save Button
		
	}

}
