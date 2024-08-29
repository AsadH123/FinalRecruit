package JobOrder_Action_List;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Invite_Referrals {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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
		driver.findElement(By.linkText("Job Orders")).click(); // Companies Tab
		Thread.sleep(2000);

		// Click on Job Orders in which user wants to assign sourcer

		List<WebElement> JobTitles = driver.findElements(By.cssSelector("table#table2 tbody tr td a.item-detail-linkedin-view"));
		for (WebElement element : JobTitles) {
			if (element.getText().equals("Selenium Java")) {
				element.click();
			}
		}
		// Assert or Verify the Note
		WebElement Note_Text = driver.findElement(By.id("is_accept_referrals"));
		String actualText = Note_Text.getText(); // Actual Text
		System.out.println(actualText);
		String expectedText = "No"; // Expected text
		if (actualText.equals(expectedText)) {
			System.out.println("Assertion Passed: Text is as expected.\n");
			driver.findElement(By.className("btnjob_recruiters-white")).click();
			Note_Text.click();
			Select select = new Select(driver
					.findElement(By.xpath("//*[@id=\"popover302181\"]/div[2]/div/form/div/div[1]/div[1]/div/select")));
			select.selectByVisibleText("Yes");
			driver.findElement(By.className("editable-submit")).click();
		} else {
			System.out.println("Assertion Failed: Text is not as expected.\n");
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-original-title='Invite Referrals']")).click(); // Click on Invite Referrals Icon
		List <WebElement> Add_Recepiant = driver.findElements(By.cssSelector("ul.borderTopul li a"));
		for(WebElement element: Add_Recepiant) {
			if(element.getText().equals("Candidates")) {
				element.click();
				
				
			}
		}

	}

}
