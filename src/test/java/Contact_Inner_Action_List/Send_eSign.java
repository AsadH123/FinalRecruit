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

public class Send_eSign {

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
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[8]/a")).click(); // Send E Sign
		
		WebElement doucmentRecipient = driver.findElement(By.xpath("//*[@name='onboarding_attached_documents_recipients[]']")); // Document Recipient
		doucmentRecipient.click();
		
		WebElement candidate = driver.findElement(By.xpath("//*[@name='candidate_name']")); // Candidate Name
		candidate.sendKeys("Asghar", Keys.ENTER);
		WebElement chkbox = driver.findElement(By.xpath("//*[@value='Asghar Zaidi']")); // Candidate CheckBox
		chkbox.isSelected();
		WebElement saveBtn = driver.findElement(By.xpath("//*[@data-dismiss='modal' and text()='Add & Close']")); // Add Button
		saveBtn.click(); 
		
		WebElement add_file = driver.findElement(By.id("addOnboardingDocuments"));
		add_file.click();
		WebElement upload_file = driver.findElement(By.id("fileupload"));
		upload_file.sendKeys("C:\\Users\\Asad\\Desktop\\DOC A.pdf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='uploadOnboardingDocumentAndSelect']")).click();
		Thread.sleep(2000);
		Select template = new Select(driver.findElement(By.className("userEmailTemplatesListonboarding_email_templates"))); // Template
		template.selectByVisibleText("Template 4");
		Select Tag = new Select(driver.findElement(By.className("emailTemplateTagsList"))); // Tag
		Tag.selectByVisibleText("Recipient Name");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"sendSigningDocumentsFrm\"]/div[2]/button")).click();
	}

}