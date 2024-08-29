package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Appointment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		// Navigate to the login page
		driver.navigate().to("https://xdev.recruitbpm.com/users/login");
		
	    // Find the email and password input fields and enter the credentials
		driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.cssSelector("div a.menutoggle")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("li[data-sort='3'] a.activeAncher span i.dropdown-chevron")).click();
		driver.findElement(By.cssSelector("ul li.appointments_listing")).click();
		
		driver.findElement(By.xpath("//*[@title='More Items']")).click();
		driver.findElement(By.xpath("//*[@href='/appointment/add/interview']")).click();
		
		WebElement interviewType = driver.findElement(By.xpath("//*[@name='communication_method']"));
		Select communication_Type = new Select(interviewType);
		communication_Type.selectByVisibleText("Live");
		
		driver.findElement(By.id("appointment_title")).sendKeys("Testing Appoinment");
		
		WebElement radioBtn = driver.findElement(By.xpath("//*[@value='live']"));
		if(!radioBtn.isSelected())
			radioBtn.click();
		else
			driver.findElement(By.id("appointment_location")).sendKeys("Testing California");
		
		driver.findElement(By.id("select2-appointment_job_id-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Testing Job 1");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-appointment_job_id-results")).click();
		
		WebElement sideAppointmentForm = driver.findElement(By.id("appointment_form"));
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", sideAppointmentForm);

//		driver.findElement(By.id("select2-appointment_candidate_id-container")).click();
//		driver.findElement(By.className("select2-search__field")).sendKeys("")
		
		WebElement description_iframe = driver.findElement(By.className("cke_wysiwyg_frame"));
		driver.switchTo().frame(description_iframe); // Switch to IFrame
		WebElement inside_iframe = driver.findElement(By.xpath("/html/body"));
		inside_iframe.sendKeys("Testing Task"); // Profile Summary
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//*[@name='btnSave']")).click();
		
		
	}

}
