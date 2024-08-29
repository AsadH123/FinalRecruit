package Deals_Action_List;

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

public class Hotlist {

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
		driver.findElement(By.xpath("//*[@data-original-title='Opportunities']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"table2_wrapper\"]/div[3]/div[3]/div[2]/div/table/tbody/tr[1]/td[2]/a/h2/i")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[3]/a")).click();
		
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/div/div[2]/button")).click();
		driver.findElement(By.id("hotlist_name")).sendKeys("Testing Hotlist");
		
		WebElement chkPublic = driver.findElement(By.id("is_public"));
		
		if(!chkPublic.isSelected())
			chkPublic.click();
		
		driver.findElement(By.id("btn-hotlist-labels")).click();
		Thread.sleep(2000);
		
        WebElement element = driver.findElement(By.tagName("input"));
		WebElement chkHotList = driver.findElement(By.cssSelector("label.chkbox input[data-item-id='492']"));
		
		if(!chkHotList.isSelected())
			chkHotList.click();
		
		driver.findElement(By.id("btn-hotlist-items")).click();
		
	}

}