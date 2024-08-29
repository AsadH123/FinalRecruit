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

public class Campaign {

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
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[3]/a")).click(); // Placement Status Change
		
		Thread.sleep(2000);
		WebElement chkbox = driver.findElement(By.xpath("//*[@data-statusid='287']"));
		js.executeScript("arguments[0].scrollIntoView(true);", chkbox);
		if(!chkbox.isSelected())
			chkbox.click();
		
		Thread.sleep(1000);
		WebElement noteType = driver.findElement(By.id("note_type_id"));
		Select note_Type = new Select(noteType);
		note_Type.selectByVisibleText("Note");
		
		driver.findElement(By.id("mod_status_comments")).sendKeys("Testing Change Status");
		
		WebElement chkBoxEmail = driver.findElement(By.xpath("//*[@data-module-status-trigger-id='339']"));
		if(!chkBoxEmail.isSelected())
			chkBoxEmail.click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("To")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@name='candidate_name']")).sendKeys("Asad Test Automation", Keys.ENTER);
		Thread.sleep(1000);
		
		WebElement chkBox_Candidate = driver.findElement(By.id("4_2910"));
		if(!chkBox_Candidate.isSelected())
			chkBox_Candidate.click();
		driver.findElement(By.xpath("//*[@id=\"tab1\"]/div[2]/div/div/div/div/button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@name='trigger_subject_339']")).sendKeys(" Successfully");
		
		WebElement emailTemplate = driver.findElement(By.className("userEmailTemplatesListtrigger_339"));
		Select email_Template = new Select(emailTemplate);
		email_Template.selectByVisibleText("Template 3");
		Thread.sleep(1000);
		
		WebElement emailTag = driver.findElement(By.className("emailTemplateTagsList"));
		Select email_Tag = new Select(emailTag);
		email_Tag.selectByVisibleText("Candidate Name");

		driver.findElement(By.xpath("//*[@id=\"frm-modulestatuses\"]/div[2]/div[2]/button")).click();

	}

}
