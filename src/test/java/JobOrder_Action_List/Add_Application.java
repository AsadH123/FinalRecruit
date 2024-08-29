package JobOrder_Action_List;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Add_Application {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
		
		driver.findElement(By.xpath("//*[@data-original-title='Add Application']")).click(); // Add Application icon
		Thread.sleep(2000);
		Select application = new Select(driver.findElement(By.id("career_application_id")));
		application.selectByVisibleText("Knockout Questions");
		driver.findElement(By.xpath("//*[@name='save']")).click();
				
		

	}

}
