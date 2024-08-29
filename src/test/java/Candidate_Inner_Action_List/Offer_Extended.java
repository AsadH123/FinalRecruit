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

public class Offer_Extended {

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
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[3]/a")).click(); // Offer Extended Status Change
		
		Thread.sleep(2000);
		WebElement chkbox = driver.findElement(By.xpath("//*[@data-statusid='17']"));
		if(!chkbox.isSelected())
			chkbox.click();
		
		Thread.sleep(1000);
		WebElement noteType = driver.findElement(By.id("note_type_id"));
		Select note_Type = new Select(noteType);
		note_Type.selectByVisibleText("Note");
		
		driver.findElement(By.id("mod_status_comments")).sendKeys("Testing Change Status");
		
		driver.findElement(By.className("select2-selection__rendered")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Testing Job 1");
		Thread.sleep(1000);
		driver.findElement(By.id("select2-job_id-results")).click();
		
		WebElement employeeType = driver.findElement(By.id("mod_status_tax_term_id"));
		Select employee_Type = new Select(employeeType);
		employee_Type.selectByVisibleText("Direct Hire");
		
		Thread.sleep(1000);
		WebElement payType = driver.findElement(By.id("mod_status_pay_type_id"));
		Select pay_Type = new Select(payType);
		pay_Type.selectByVisibleText("Monthly");
		
		Thread.sleep(1000);
		WebElement fee = driver.findElement(By.xpath("//*[@id=\"2914\"]/div[6]/div/div/div/select"));
		Select FEE = new Select(fee);
		FEE.selectByVisibleText("Percent");
		
		WebElement fee_Input = driver.findElement(By.id("mod_status_bill_rate"));
		fee_Input.clear();
		fee_Input.sendKeys("15");
		
		WebElement joiningDate = driver.findElement(By.xpath("//*[@name='joining_date']"));
		js.executeScript("arguments[0].scrollIntoView(true);", joiningDate);
		joiningDate.click();
		Thread.sleep(1000);
		driver.findElement(By.className("ui-datepicker-today")).click();
		
		driver.findElement(By.xpath("//*[@name='onboarding_attached_documents_recipients[]']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@name='candidate_name']")).sendKeys("Asad Test Automation");
		Thread.sleep(1000);
		
		WebElement chkBox_Candidate = driver.findElement(By.id("4_2910"));
		if(!chkBox_Candidate.isSelected())
			chkBox_Candidate.click();
		driver.findElement(By.xpath("//*[@id=\"onboarding-recipients-tab1\"]/div[2]/div/div/div/div/button")).click();
		Thread.sleep(1000);
		
		WebElement attachDoc = driver.findElement(By.id("addOnboardingDocuments")); // File Upload
		attachDoc.click();
		WebElement upload_file = driver.findElement(By.id("fileupload"));
		upload_file.sendKeys("C:\\Users\\Asad\\Desktop\\New Upload File.docx");
		driver.findElement(By.id("uploadOnboardingDocumentAndSelect")).click();
		Thread.sleep(1000);
		
		WebElement emailTemplate = driver.findElement(By.className("userEmailTemplatesListonboarding_email_templates"));
		js.executeScript("arguments[0].scrollIntoView(true);", emailTemplate);
		Select email_Template = new Select(emailTemplate);
		email_Template.selectByVisibleText("Template 3");
		Thread.sleep(1000);
		
		WebElement emailTag = driver.findElement(By.className("emailTemplateTagsList"));
		
		Select email_Tag = new Select(emailTag);
		email_Tag.selectByVisibleText("Candidate Name");

		driver.findElement(By.xpath("//*[@id=\"frm-modulestatuses\"]/div[2]/div[2]/button")).click();
		
		
	}

}
