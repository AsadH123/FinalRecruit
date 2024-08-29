package JobOrder_Inner_Action_List;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Add_Manage_Application {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Set<String> windowHandles = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(windowHandles);
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
		
		driver.findElement(By.cssSelector("li[data-sort='6'] a.activeAncher span i.dropdown-chevron")).click();
		driver.findElement(By.className("jobs_listing")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"table2_wrapper\"]/div[3]/div[3]/div[2]/div/table/tbody/tr[2]/td[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[1]/a")).click(); // Add Application
		
		// Manage Application
		
		driver.findElement(By.xpath("//*[@id=\"assignCareerApplicationForm\"]/div/div[1]/h4/a")).click(); // Manage Application
		Thread.sleep(2000);
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(2000);
            driver.switchTo().window(tabs.get(1));
//        driver.switchTo().window(tabs.get(1));
//		WebElement scroll = driver.findElement(By.xpath("/html/body/section[1]/div[2]/div[5]/div[3]/div[1]/div/div/div[1]/h4/span/a"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scroll);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(By.xpath("/html/body/section[1]/div[2]/div[5]/div[3]/div[1]/div/div/div[1]/h4/span/a"))).perform();
//        Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@title='Add Application']")).click(); // Add Application Button
//		driver.findElement(By.id("title")).sendKeys("Testing Add Application"); // Title
//		driver.findElement(By.id("header")).sendKeys("Testing Header"); // Header
//		
//		WebElement appType = driver.findElement(By.id("application_type_1"));
//		
//		if(!appType.isSelected())
//			appType.click();
//		driver.findElement(By.xpath("//*[@id=\"careerApplicationAddForm\"]/div[5]/button")).click();
//         
//         driver.switchTo().window(tabs.get(0));
//         
//         // Assign Application
//         
//         WebElement careerApp = driver.findElement(By.id("career_application_id"));
//         Select career_App = new Select(careerApp);
//         career_App.selectByVisibleText("Testing Add Application");
//         
//         driver.findElement(By.xpath("//*[@id=\"assignCareerApplicationForm\"]/div/div[2]/input[3]")).click();
		
	}

}
