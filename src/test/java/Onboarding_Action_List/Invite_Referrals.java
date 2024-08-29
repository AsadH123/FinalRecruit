package Onboarding_Action_List;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
		driver.findElement(By.linkText("Onboarding")).click(); // Onboarding Tab
		Thread.sleep(2000);
		
		// Click on Job Orders in which user wants to assign sourcer
		
		driver.findElement(By.xpath("//*[@placeholder='Job Title']")).sendKeys("DB Engr", Keys.ENTER); // Job Title Search Box
		driver.findElement(By.xpath("//*[@placeholder='Candidate']")).sendKeys("Edward Tim", Keys.ENTER); // Candidate Search Box
		driver.findElement(By.linkText("DB Engr")).click(); // Link Text
		
		driver.findElement(By.xpath("//*[@data-original-title='Invite Referrals']")).click(); // Click on Invite Referrals Icon
		driver.findElement(By.xpath("//*[@name='email_to[]']")).click(); // Click on receiver email input 
		driver.findElement(By.xpath("//*[@name='candidate_name']")).sendKeys("Asghar", Keys.ENTER); // Candidate Name
		driver.findElement(By.id("4_1842")).isSelected();
		driver.findElement(By.xpath("//*[text()='Add & Close']")).click();
		
		Select select = new Select(driver.findElement(By.id("email_schedule")));
		select.selectByIndex(1);
		driver.findElement(By.xpath("//*[@name='btnSend']")).click();
		

	}

}
