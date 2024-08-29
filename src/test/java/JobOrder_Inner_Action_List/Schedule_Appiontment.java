package JobOrder_Inner_Action_List;

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

public class Schedule_Appiontment {

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
		
		driver.findElement(By.cssSelector("li[data-sort='6'] a.activeAncher span i.dropdown-chevron")).click();
		driver.findElement(By.className("candidates_listing")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"table2_wrapper\"]/div[3]/div[3]/div[2]/div/table/tbody/tr[5]/td[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[7]/a")).click(); // Schedule Appointment
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@data-form='interview']")).click();
		
		Thread.sleep(1000);
		WebElement interviewType = driver.findElement(By.xpath("//*[@name='communication_method']"));
		Select communicationType = new Select(interviewType);
		communicationType.selectByVisibleText("Live");
		
		driver.findElement(By.id("appointment_title")).sendKeys("Testing Schedule Appointment");
		driver.findElement(By.id("appointment_location")).sendKeys("ABC");
		
		driver.findElement(By.id("s_date")).click();
		driver.findElement(By.className("ui-datepicker-current-day")).click();
		
		driver.findElement(By.id("timepicker1666")).click();
		
		Thread.sleep(1000);
		WebElement hour = driver.findElement(By.xpath("//*[@name='hour']"));
		hour.clear();
		hour.sendKeys("03");
		WebElement minute = driver.findElement(By.xpath("//*[@name='minute']"));
		minute.clear();
		minute.sendKeys("30");
		WebElement meridian = driver.findElement(By.xpath("//*[@name='meridian']"));
		meridian.clear();
		meridian.sendKeys("PM");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@name='e_date']")).click();
		driver.findElement(By.className("ui-datepicker-today")).click();
		
		driver.findElement(By.id("timepicker2555")).click();
		
		Thread.sleep(1000);
		WebElement hour1 = driver.findElement(By.cssSelector("div div.open table tbody tr td input[name='hour']"));
		hour1.clear();
		hour1.sendKeys("04");
		WebElement minute1 = driver.findElement(By.cssSelector("div div.open table tbody tr td input[name='minute']"));
		minute1.clear();
		minute1.sendKeys("30");
		WebElement meridian1 = driver.findElement(By.cssSelector("div div.open table tbody tr td input[name='meridian']"));
		meridian1.clear();
		meridian1.sendKeys("PM");
		
	}

}
