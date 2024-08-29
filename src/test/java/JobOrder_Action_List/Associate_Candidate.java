package JobOrder_Action_List;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Associate_Candidate {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.manage().window().maximize();
		// Navigate to the login page
		driver.navigate().to("https://xdev.recruitbpm.com/users/login");

		// Find the email and password input fields and enter the credentials
		driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.className("menutoggle")).click(); // Menu Button
		driver.findElement(By.linkText("Job Orders")).click(); // Job Orders
		Thread.sleep(2000);
		List <WebElement> JobTitles = driver.findElements(By.cssSelector("table#table2 tbody tr td a.item-detail-linkedin-view"));
		for(WebElement element: JobTitles) {
			if(element.getText().equals("Selenium Java")) {
				element.click();
			}
		}
		
		driver.findElement(By.xpath("//*[@data-original-title='Associate Candidate']")).click(); // Associate  Candidate icon 
		WebElement candidate = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span#select2-candidate_ids-container")));
		candidate.click();
		WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.className("select2-search__field")));
		input.sendKeys("Asad");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-candidate_ids-results")).click(); // Candidate Dropdown
		driver.findElement(By.xpath("//*[@value='Save & Associate']")).click();



	}

}
