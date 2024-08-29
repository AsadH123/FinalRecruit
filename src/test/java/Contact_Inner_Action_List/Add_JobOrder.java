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

public class Add_JobOrder {

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
		
		driver.findElement(By.xpath("//*[@id=\"table2_wrapper\"]/div[3]/div[3]/div[2]/div/table/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[1]/a")).click(); // Add Job Order
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"collapseDetails\"]/div/div[1]/div[1]/input")).sendKeys("Danny Jobs");
		WebElement jobPriority = driver.findElement(By.id("job_priority_id"));
		Select job_Priority = new Select(jobPriority);
		job_Priority.selectByVisibleText("Alpha Beta Gamma");
		
		WebElement jobType = driver.findElement(By.xpath("//*[@name='employment_type_id']"));
		Select job_Type = new Select(jobType);
		job_Type.selectByVisibleText("Contract");
		
		WebElement workspaceType = driver.findElement(By.id("workspaceTypes"));
		Select workSpace_Type = new Select(workspaceType);
		workSpace_Type.selectByVisibleText("Hybrid");
		Thread.sleep(2000);

		WebElement JD = driver.findElement(By.xpath("//*[@for='job_description']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", JD);
		
		WebElement description_iframe = driver.findElement(By.className("cke_wysiwyg_frame"));
		driver.switchTo().frame(description_iframe); // Switch to IFrame
		WebElement inside_iframe = driver.findElement(By.xpath("/html/body"));
		inside_iframe.sendKeys("Testing Add Job Description inner list"); // Comments
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		WebElement PD = driver.findElement(By.xpath("//*[@for='qnotes']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PD);
        
        WebElement privateDescription_iframe = driver.findElement(By.xpath("//*[@aria-describedby='cke_108']"));
		driver.switchTo().frame(privateDescription_iframe); // Switch to IFrame
		WebElement inside2_iframe = driver.findElement(By.xpath("/html/body"));
		inside2_iframe.sendKeys("Testing Add Job Description inner list"); // Comments
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//*[@name='address']")).sendKeys("ABC");
		
		WebElement country = driver.findElement(By.xpath("//*[@for='country_name']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", country);
		
		driver.findElement(By.id("select2-state_name-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("Arkansas");
		driver.findElement(By.id("select2-state_name-results")).click();
		//driver.findElement(By.id("select2-state_name-result-pzr8-Arkansas")).click();
		
		driver.findElement(By.xpath("//*[@name='city']")).sendKeys("Alabama");
		driver.findElement(By.xpath("//*[@name='zipcode']")).sendKeys("44000");
		
		driver.findElement(By.id("company_submit")).click();
		
		
	}

}
