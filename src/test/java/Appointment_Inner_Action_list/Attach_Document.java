package Appointment_Inner_Action_list;

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

public class Attach_Document {

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
		driver.findElement(By.className("appointments_listing")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"appointmentTable_wrapper\"]/div[3]/div[3]/div[2]/div/table/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[1]/a")).click(); // Attach Document
		
		WebElement upload_file = driver.findElement(By.xpath("//*[@id=\"fileupload\"]")); // File Upload
		upload_file.sendKeys("C:\\Users\\Asad\\Desktop\\New Upload File.docx");
		driver.findElement(By.xpath("//*[@name='document_title']")).sendKeys("Testing"); // Name
		driver.findElement(By.xpath("//*[@name='document_description']")).sendKeys("Testing");
		
		driver.findElement(By.id("document_submit")).click();
		
		

	}

}