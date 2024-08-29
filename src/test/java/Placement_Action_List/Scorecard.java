package Placement_Action_List;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scorecard {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        Scanner input = new Scanner(System.in);
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

		// Click on job orders in which user wants to click reminder button

		driver.findElement(By.xpath("//*[@placeholder='Job Title']")).sendKeys("Data Scientists", Keys.ENTER); // Job Title Search Box
		driver.findElement(By.xpath("//*[@placeholder='Candidate']")).sendKeys("Danny Elba", Keys.ENTER); // Candidate Search Box
		driver.findElement(By.linkText("Data Scientists")).click(); // Link Text
		
		driver.findElement(By.xpath("//*[@data-original-title='Scorecard']")).click(); // Click on Scorecard Icon
		
        int numberOfCatergory = 2;
        for (int i = 0; i < numberOfCatergory; i++) {
	    	Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@data-title='Add Category']")).click(); // Add Category Button
			WebElement categoryTitle = driver.findElement(By.xpath("//*[@name='category_title']"));
			wait.until(ExpectedConditions.elementToBeClickable(categoryTitle));
			System.out.print("Enter text to send: ");
	        String userInput = input.nextLine();
			categoryTitle.sendKeys(userInput);
			driver.findElement(By.xpath("//*[@type='submit' and text()='Add Category']")).click();
        }
        int numberOfSkill = 1;
        for (int i = 0; i < numberOfSkill; i++) {
	    	Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@data-title='Add Skill']")).click(); // Add Skill Button
			WebElement skillTitle = driver.findElement(By.xpath("//*[@name='skill_title']")); // Skill Title
			wait.until(ExpectedConditions.elementToBeClickable(skillTitle));
			System.out.print("Enter text to send: ");
	        String userInput = input.nextLine();
			skillTitle.sendKeys(userInput);
			driver.findElement(By.xpath("//*[@type='submit' and text()='Add Skill']")).click();
        }
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div/div/div[3]/button")).click(); 
	}
}
