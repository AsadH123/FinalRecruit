package test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Job_Order {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		// Navigate to the login page
		driver.navigate().to("https://xdev.recruitbpm.com/users/login");
		
	    // Find the email and password input fields and enter the credentials
		driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();

		//Add Single New Job Order
		driver.findElement(By.xpath("/html/body/section[1]/div[2]/div[1]/ul/li[1]/div/button")).click();
		driver.findElement(By.id("jobs_listing")).click();
		driver.findElement(By.xpath("//*[@name='job_title']")).sendKeys("Automation Job"); // Job Title
		WebElement company = driver.findElement(By.id("select2-company_id-container"));
		company.click();
		WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='select2-search__field']")));
		input.sendKeys("Automated Company");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-company_id-results")).click();
		//input.click();
//		List<WebElement> elements = driver.findElements(By.cssSelector("ul.select2-results__options li div.finding_text"));
//		System.out.println("Number of elements found: " + elements.size());
//        for (WebElement element : elements) {
//            String text = element.getText();
//            System.out.println("Element text: " + text);
//            if(element.getText() == "Automated Company") {
//            	Thread.sleep(3000);
//            	element.sendKeys(Keys.ENTER);
//            	break;
//            }
//        }
		
        
		Select Job_Priority = new Select(driver.findElement(By.id("job_priority_id")));
		Job_Priority.selectByVisibleText("A-Direct Relationship"); // Job Priority
		driver.findElement(By.id("company_submit")).click(); // Save Button
		
		
	
		

	}

}
