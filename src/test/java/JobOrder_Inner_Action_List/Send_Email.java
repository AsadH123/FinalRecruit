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

public class Send_Email {

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
		
		WebElement sendEmail = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[16]/a"));
        js.executeScript("arguments[0].scrollIntoView(true);", sendEmail); // Send Email
		
		sendEmail.click();
		Thread.sleep(2000);
		
		WebElement emailType = driver.findElement(By.id("new-email"));
		Select email_Type = new Select(emailType);
		email_Type.selectByVisibleText("Normal Email");
		
		driver.findElement(By.xpath("//*[@name='email_to[]']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@name='candidate_name']")).sendKeys("Asad New Candidate", Keys.ENTER);
		
		WebElement chkbox = driver.findElement(By.id("4_2746"));
		if(!chkbox.isSelected())
			chkbox.click();
		
		driver.findElement(By.xpath("//*[@id=\"tab1\"]/div[2]/div/div/div/div/button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@name='subject']")).sendKeys("Testing Send Email");
		
		Thread.sleep(1000);
		WebElement upload_file = driver.findElement(By.id("fileuploads")); // File Upload
		upload_file.sendKeys("C:\\Users\\Asad\\Desktop\\DOC A.pdf");
		
		WebElement emailTemplate = driver.findElement(By.xpath("//*[@id=\"email_template_id\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", emailTemplate);
        
        Select email_Template = new Select(emailTemplate);
        email_Template.selectByVisibleText("Template 4");
        
		WebElement emailSchedule = driver.findElement(By.xpath("//*[@id=\"email_schedule\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", emailSchedule);

        Select email_Schedule = new Select(emailSchedule);
        email_Schedule.selectByVisibleText("Now");
        
        driver.findElement(By.xpath("//*[@id=\"frmMain\"]/div[2]/div/div/input[1]")).click();
	}

}
