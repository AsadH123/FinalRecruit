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

public class Send_Video_Conference_Link {

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
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[9]/a")).click(); // Send Video Conference Link
		
		driver.findElement(By.xpath("//*[@name='video_conference_recipients[]' and @class='form-control']")).click(); // Video Conference Recipients
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@name='candidate_name']")))).sendKeys("Asghar", Keys.ENTER); // Candidate Name
		driver.findElement(By.xpath("//*[@value='Asghar Zaidi']")).isSelected(); // CheckBox 
		driver.findElement(By.xpath("//*[@data-dismiss='modal' and text()='Add & Close']")).click(); // Add and Close Button
		
		Select template = new Select(driver.findElement(By.className("userEmailTemplatesListonboarding_email_templates")));
		template.selectByVisibleText("Template 3");
		Select Tag = new Select(driver.findElement(By.className("emailTemplateTagsList")));
		Tag.selectByVisibleText("Recipient Name");
		
		driver.findElement(By.xpath("//*[@name='submit' and text()='Send']")).click();

	}

}
