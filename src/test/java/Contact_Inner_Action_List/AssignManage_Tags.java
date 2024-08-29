package Contact_Inner_Action_List;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignManage_Tags {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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
		
		driver.findElement(By.cssSelector("li[data-sort='2'] a.activeAncher span i.dropdown-chevron")).click();
		driver.findElement(By.className("contacts_listing")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"table2_wrapper\"]/div[3]/div[3]/div[2]/div/table/tbody/tr[5]/td[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[13]/a")).click(); // Assign Tags
		
		// Manage Tags
		
		driver.findElement(By.xpath("//*[@id=\"hacktags\"]/div/div[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div/a")).click();
		driver.findElement(By.xpath("//*[@name='tag_category']")).sendKeys("Testing Oppourtunity");
		driver.findElement(By.xpath("//*[@id=\"frmTagCategory\"]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[2]/ul[6]/div/div/div[2]/span/a")).click();
		driver.findElement(By.xpath("//*[@name='tag_item']")).sendKeys("Testing 1");
		driver.findElement(By.xpath("//*[@id=\"frmTagItem\"]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnDoneManageTags")).click();
				
		// Assign Tags
				
		driver.findElement(By.xpath("//*[@id=\"table2_wrapper\"]/div[3]/div[3]/div[2]/div/table/tbody/tr[5]/td[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[13]/a")).click(); // Assign Tags
				
		driver.findElement(By.xpath("//*[@placeholder='Search Tags']")).sendKeys("Testing Oppourtunity");
		WebElement tagChkbox = driver.findElement(By.xpath("//*[@id=\"assignTagsFrm\"]/div[1]/ul[6]/li[1]/label[1]/input"));
				
		if(!tagChkbox.isSelected())
			tagChkbox.click();
				
		driver.findElement(By.id("assignTagsToItems")).click();
			

	}

}
