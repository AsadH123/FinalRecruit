package Candidate_Inner_Action_List;

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

public class Interview {

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
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[3]/a")).click(); // Interview Status Change
		
		Thread.sleep(2000);
		WebElement chkbox = driver.findElement(By.xpath("//*[@data-statusid='16']"));
		if(!chkbox.isSelected())
			chkbox.click();
		
		Thread.sleep(1000);
		WebElement noteType = driver.findElement(By.id("note_type_id"));
		Select note_Type = new Select(noteType);
		note_Type.selectByVisibleText("Note");
		
		driver.findElement(By.id("mod_status_comments")).sendKeys("Testing Change Status");
		
		WebElement interviewType = driver.findElement(By.xpath("//*[@name='communication_method']"));
		Select interview_Type = new Select(interviewType);
		interview_Type.selectByVisibleText("In Person");
		
		driver.findElement(By.id("appointment_title")).sendKeys("Testing Interview Change Status");
		
		WebElement chkBox_Live = driver.findElement(By.cssSelector("label.chkbox input[value='live']"));
		//WebElement chkBox_Recorded = driver.findElement(By.xpath("label.chkbox input[value='recorded']"));
		
		if(!chkBox_Live.isSelected()) {
//			WebElement smsLink = driver.findElement(By.id("is_sms_interview_link"));
//			if(!smsLink.isSelected())
//				smsLink.click();
			
			driver.findElement(By.id("appointment_location")).sendKeys("Test ABC");
			
			WebElement scroll_To_Date = driver.findElement(By.id("s_date"));
	        js.executeScript("arguments[0].scrollIntoView(true);", scroll_To_Date);
			
			WebElement startDate = driver.findElement(By.id("s_date"));
			startDate.click();
			driver.findElement(By.className("ui-datepicker-current-day")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.id("timepicker1666")).click();
			
			WebElement hour = driver.findElement(By.xpath("//*[@name='hour']"));
			hour.clear();
			hour.sendKeys("03");
			WebElement minute = driver.findElement(By.xpath("//*[@name='minute']"));
			minute.clear();
			minute.sendKeys("30");
			WebElement meridian = driver.findElement(By.xpath("//*[@name='meridian']"));
			meridian.clear();
			meridian.sendKeys("PM");
			
			WebElement endDate = driver.findElement(By.xpath("//*[@name='e_date']"));
			endDate.click();
			driver.findElement(By.className("ui-datepicker-current-day")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.id("timepicker2555")).click();
			
			WebElement hour1 = driver.findElement(By.cssSelector("div div.open table tbody tr td input[name='hour']"));
			hour1.clear();
			hour1.sendKeys("04");
			WebElement minute1 = driver.findElement(By.cssSelector("div div.open table tbody tr td input[name='minute']"));
			minute1.clear();
			minute1.sendKeys("30");
			WebElement meridian1 = driver.findElement(By.cssSelector("div div.open table tbody tr td input[name='meridian']"));
			meridian1.clear();
			meridian1.sendKeys("PM");
			
			WebElement chkBox_Private = driver.findElement(By.cssSelector("label.chkbox input[type='checkbox'][name='is_private']"));
			if(!chkBox_Private.isSelected())
				chkBox_Private.click();
			
			driver.findElement(By.id("select2-appointment_job_id-container")).click();
			driver.findElement(By.className("select2-search__field")).sendKeys("Testing Job 1");
			Thread.sleep(1000);
			driver.findElement(By.id("select2-appointment_job_id-results")).click();
			
			Thread.sleep(1000);
			WebElement upload_file = driver.findElement(By.xpath("//*[@id='fileuploads']")); // File Upload
			js.executeScript("arguments[0].scrollIntoView(true);", upload_file);
			upload_file.sendKeys("C:\\Users\\Asad\\Desktop\\New Upload File.docx");
			
			WebElement chkBoxEmail = driver.findElement(By.xpath("//*[@data-module-status-trigger-id='504']"));
			if(!chkBoxEmail.isSelected())
				chkBoxEmail.click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//*[@name='trigger_subject_504']")).sendKeys(" Successfully");
			
			WebElement emailTemplate = driver.findElement(By.className("userEmailTemplatesListtrigger_504"));
			Select email_Template = new Select(emailTemplate);
			email_Template.selectByVisibleText("Template 3");
			Thread.sleep(1000);
			
			WebElement emailTag = driver.findElement(By.className("emailTemplateTagsList"));
			Select email_Tag = new Select(emailTag);
			email_Tag.selectByVisibleText("Candidate Name");
			
			driver.findElement(By.xpath("//*[@id=\"frm-modulestatuses\"]/div[2]/div[2]/button")).click();
		}
		
		else {
			
			Thread.sleep(1000);
			WebElement chkBox_Recorded = driver.findElement(By.cssSelector("label.chkbox input[value='recorded']"));
			//js.executeScript("arguments[0].scrollIntoView(true);", chkBox_Recorded);
			if(!chkBox_Recorded.isSelected())
				chkBox_Recorded.click();
			
			driver.findElement(By.id("select2-appointment_job_id-container")).click();
			driver.findElement(By.className("select2-search__field")).sendKeys("Testing Job 1");
			Thread.sleep(1000);
			driver.findElement(By.id("select2-appointment_job_id-results")).click();
			
			Thread.sleep(1000);
			WebElement upload_file = driver.findElement(By.xpath("//*[@id='fileuploads']")); // File Upload
			js.executeScript("arguments[0].scrollIntoView(true);", upload_file);
			upload_file.sendKeys("C:\\Users\\Asad\\Desktop\\New Upload File.docx");
			
			WebElement chkBoxEmail = driver.findElement(By.xpath("//*[@data-module-status-trigger-id='504']"));
			if(!chkBoxEmail.isSelected())
				chkBoxEmail.click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//*[@name='trigger_subject_504']")).sendKeys(" Successfully");
			
			WebElement emailTemplate = driver.findElement(By.className("userEmailTemplatesListtrigger_504"));
			Select email_Template = new Select(emailTemplate);
			email_Template.selectByVisibleText("Template 3");
			Thread.sleep(1000);
			
			WebElement emailTag = driver.findElement(By.className("emailTemplateTagsList"));
			Select email_Tag = new Select(emailTag);
			email_Tag.selectByVisibleText("Candidate Name");
			
			driver.findElement(By.xpath("//*[@id=\"frm-modulestatuses\"]/div[2]/div[2]/button")).click();
		}
	}
}
