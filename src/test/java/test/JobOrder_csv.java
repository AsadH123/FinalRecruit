package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JobOrder_csv {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		// Navigate to the login page
		driver.navigate().to("https://xdev.recruitbpm.com/users/login");
		
	    // Find the email and password input fields and enter the credentials
		driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();
		
		// Add Companies through CSV
		driver.findElement(By.className("menutoggle")).click(); // Menu Button
		driver.findElement(By.linkText("Job Orders")).click(); // Job Orders button
		driver.findElement(By.xpath("//*[@id=\"sticky\"]/div[2]/div[1]")).click(); // More Actions Menu Button
		driver.findElement(By.linkText("Mass Import")).click(); // Mass Import Button
		
		// Upload CSV File
		Thread.sleep(2000);
		WebElement upload_file = driver.findElement(By.xpath("//*[@name='fileupload']"));
		upload_file.sendKeys("C:\\Users\\Asad\\Desktop\\Job Orders.csv");
		driver.findElement(By.id("import_submit")).click();
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement process = driver.findElement(By.xpath("//*[@name='submit']"));
		process.click();
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement finish = driver.findElement(By.xpath("//*[@value='Finish']"));
		finish.click();		
		

	}

}
