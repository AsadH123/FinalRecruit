package Company_Action_List;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_Contacts {

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
		
		driver.findElement(By.className("menutoggle")).click(); // Menu Button
		driver.findElement(By.linkText("Companies")).click(); // Job Orders Tab
		Thread.sleep(2000);

		// Click on companies in which user wants to click reminder button

		List<WebElement> company_table = driver.findElements(By.cssSelector("table#table2 tr td a"));

		for (WebElement element : company_table) {
 
			if (element.getText().equals("Asad Tech")) {
				element.click();
				break;
			}
		}
		driver.findElement(By.xpath("//*[@data-original-title='Add Contact']")).click();
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(newTb.get(1)); //switch to new tab
		driver.findElement(By.id("addcontactfn")).sendKeys("Asghar"); // First Name
		driver.findElement(By.id("addcontactln")).sendKeys("Zaidi"); // Last Name
		driver.findElement(By.id("email1")).sendKeys("zaidi@yopmail.com"); // Email
		driver.findElement(By.id("addcontactjt")).sendKeys("SQA Manager Engineer"); // Job Title
		WebElement company = driver.findElement(By.id("select2-company_id-container")); 
		company.click();
		WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='select2-search__field']")));
		input.sendKeys("Automated Company");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-company_id-results")).click(); // Company
		driver.findElement(By.xpath("//*[@value='Save']")).click(); // Save Button
		driver.switchTo().window(newTb.get(0)); //switch to parent window
	}

}
