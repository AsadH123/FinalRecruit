package Candidate_Action_List;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Change_Status {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		// Navigate to the login page
		driver.navigate().to("https://xdev.recruitbpm.com/users/login");
		
	    // Find the email and password input fields and enter the credentials
		driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();

		driver.findElement(By.className("menutoggle")).click(); // Menu Button
		driver.findElement(By.linkText("Candidates")).click(); // Candidates Tab
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Asghar", Keys.ENTER); // First Name Search Box
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Zaidi", Keys.ENTER); // Last Name Search Box
		driver.findElement(By.linkText("Asghar")).click(); // Contact Link Text
		driver.findElement(By.xpath("//*[@data-original-title='Contact Submission']")).click(); // Click on Contact Submission Icon
		
		List<WebElement> status_list = driver.findElements(By.cssSelector("ul.list-unstyled li button"));
		for(WebElement element: status_list) {
			if(element.getText().equals("Pipeline")) { // Status Clicked
				element.click();
			}
		}
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.id("note_type_id"))); // Note Type
		select.selectByVisibleText("Note");
		driver.findElement(By.id("mod_status_comments")).sendKeys("This is a test comment"); // Comment
		WebElement JobOrder = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("select2-job_id-container"))));
		JobOrder.click();
		driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("Data Scientist"); // Job Order DropDown
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='select2-job_id-results']")))).click(); 
//		Select source = new Select(driver.findElement(By.xpath("//*[@name='sourcer_id']")));
//		source.selectByVisibleText("Linkedin"); // Source DropDown
		driver.findElement(By.xpath("//*[@type='submit' and text()='Save']")).click(); // Save Button
	}

}
