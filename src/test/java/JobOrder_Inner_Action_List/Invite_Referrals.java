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

public class Invite_Referrals {

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
		driver.findElement(By.className("jobs_listing")).click();
		Thread.sleep(2000);
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		driver.findElement(By.xpath("//*[@id=\"table2_wrapper\"]/div[3]/div[3]/div[2]/div/table/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[7]/a")).click(); // Invite Referrals
		Thread.sleep(2000);
		
		WebElement email_Type = driver.findElement(By.xpath("//*[@name='email_type']"));
		Select emailType = new Select(email_Type);
		emailType.selectByVisibleText("Normal Email");
		
		driver.findElement(By.xpath("//*[@name='email_to[]']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@name='candidate_name']")).sendKeys("Asad New Candidate", Keys.ENTER);
		Thread.sleep(1000);
		WebElement chkbox = driver.findElement(By.id("4_2746"));
		if(!chkbox.isSelected())
			chkbox.click();
		driver.findElement(By.xpath("//*[@id=\"tab1\"]/div[2]/div/div/div/div/button")).click();
		Thread.sleep(2000);
		
		WebElement subj = driver.findElement(By.xpath("//*[@name='subject']"));
		subj.clear();
		subj.sendKeys("Invitation to apply on Danny Jobs");
		
		WebElement emailSchedule = driver.findElement(By.id("email_schedule"));
		Select email_Schedule = new Select(emailSchedule);
		email_Schedule.selectByIndex(1);
		
		driver.findElement(By.xpath("//*[@name='btnSend']")).click();		
		
		

	}

}
