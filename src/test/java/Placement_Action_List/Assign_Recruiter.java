package Placement_Action_List;

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
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assign_Recruiter {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().window().maximize();
		// Navigate to the login page
		driver.navigate().to("https://xdev.recruitbpm.com/users/login");
		
	    // Find the email and password input fields and enter the credentials
		driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();

		driver.findElement(By.className("menutoggle")).click(); // Menu Button
		driver.findElement(By.linkText("Placements")).click(); // Placements Tab
		Thread.sleep(2000);
		
		// Click on Placements in which user wants to assign recruiter
		
		driver.findElement(By.xpath("//*[@placeholder='Job Title']")).sendKeys("Data Scientist", Keys.ENTER); // Job Title Search Box
		driver.findElement(By.xpath("//*[@placeholder='Candidate']")).sendKeys("Danny Elba", Keys.ENTER); // Candidate Search Box
		driver.findElement(By.linkText("Data Scientists")).click(); // Link Text
		
		driver.findElement(By.xpath("//*[@data-original-title='Assign Recruiter']")).click(); // Click on Assign Recruiter Icon
		Thread.sleep(2000);
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("td button.multiselect"))));
		dropdown.click(); // Click on Dropdown
		List <WebElement> Recruiters = driver.findElements(By.cssSelector("ul.multiselect-container li a label.checkbox")); // List of Recruiters
		for(WebElement element: Recruiters) {
			System.out.println(element.getText());
			if(element.getText().equals("Ahsan")) {
				element.click();
			}
		}
		driver.findElement(By.xpath("//*[@type='submit' and text()='Assign']")).click();

	}

}
