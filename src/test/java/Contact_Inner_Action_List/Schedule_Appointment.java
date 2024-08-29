package Contact_Inner_Action_List;

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

public class Schedule_Appointment {

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
		
		driver.findElement(By.cssSelector("li[data-sort='2'] a.activeAncher span i.dropdown-chevron")).click();
		driver.findElement(By.className("contacts_listing")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"table2_wrapper\"]/div[3]/div[3]/div[2]/div/table/tbody/tr[2]/td[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[7]/a")).click(); // Schedule Appointment
		
		WebElement commMethod = driver.findElement(By.xpath("//*[@name='communication_method']"));
		Select comm_Method = new Select(commMethod);
		comm_Method.selectByVisibleText("In Person");
		
		driver.findElement(By.xpath("//*[@name='appointment_title']")).sendKeys("Testing Inner Listing Schedule Appointment");
		driver.findElement(By.id("appointment_location")).sendKeys("ABC");
		
		driver.findElement(By.xpath("//*[@name='s_date']")).click();
		driver.findElement(By.className("ui-datepicker-today")).click();
		
		driver.findElement(By.xpath("//*[@name='s_time']")).click();
		WebElement hour = driver.findElement(By.xpath("//*[@name='hour']"));
		hour.clear();
		hour.sendKeys("07");
		WebElement minute = driver.findElement(By.xpath("//*[@name='minute']"));
		minute.clear();
		minute.sendKeys("50");
		WebElement meridian = driver.findElement(By.xpath("//*[@name='meridian']"));
		meridian.clear();
		meridian.sendKeys("PM");
		
		driver.findElement(By.xpath("//*[@name='e_date']")).click();
		WebElement selectMonth = driver.findElement(By.className("ui-datepicker-month"));
		Select month = new Select(selectMonth);
		month.selectByVisibleText("Aug");
		Thread.sleep(2000);
		
		WebElement selectYear = driver.findElement(By.className("ui-datepicker-year"));
		Select year = new Select(selectYear);
		year.selectByVisibleText("2024");
		
		Thread.sleep(2000);
		WebElement date = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[7]"));
		date.getAccessibleName();
		date.click();
		
		driver.findElement(By.xpath("//*[@name='e_time']")).click();
		WebElement hour1 = driver.findElement(By.xpath("//*[@id=\"checkvideointerview\"]/div[7]/div/div/div/table/tbody/tr[2]/td[1]/input"));
		hour1.clear();
		hour1.sendKeys("08");
		WebElement minute1 = driver.findElement(By.xpath("//*[@id=\"checkvideointerview\"]/div[7]/div/div/div/table/tbody/tr[2]/td[3]/input"));
		minute1.clear();
		minute1.sendKeys("45");
		WebElement meridian1 = driver.findElement(By.xpath("//*[@id=\"checkvideointerview\"]/div[7]/div/div/div/table/tbody/tr[2]/td[5]/input"));
		meridian1.clear();
		meridian1.sendKeys("PM");
		//driver.findElement(By.xpath("//*[@name='e_time']")).click();
		
		WebElement addForm = driver.findElement(By.id("appointment_form"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", addForm);
		
		Thread.sleep(2000);
		WebElement description_iframe = driver.findElement(By.xpath("//*[@aria-describedby='cke_108']"));
		driver.switchTo().frame(description_iframe); // Switch to IFrame
		WebElement inside_iframe = driver.findElement(By.xpath("/html/body"));
		inside_iframe.sendKeys("Testing Schedule Appointment inner list"); // Comments
		driver.switchTo().defaultContent();
		
//		WebElement upload_file = driver.findElement(By.className("fileuploader-input-button"));
//		upload_file.sendKeys("C:\\Users\\Asad\\Desktop\\Candidates.csv");
		
		driver.findElement(By.xpath("//*[@name='btnSave']")).click();

	}
}
