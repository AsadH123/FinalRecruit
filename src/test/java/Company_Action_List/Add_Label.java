package Company_Action_List;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Add_Label {

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
		driver.findElement(By.className("menutoggle")).click(); // Menu Button
		driver.findElement(By.linkText("Companies")).click(); // Companies Tab
		Thread.sleep(2000);
		
		// Click on company in which user wants to add note
		
		List <WebElement> company_table = driver.findElements(By.cssSelector("table#table2 tr td a"));
		
		for (WebElement element : company_table) {
            
            if(element.getText().equals("Asad Tech")) {
            	element.click();
            	break;	
            }
		}
		driver.findElement(By.xpath("//*[@data-original-title='Hotlist']")).click(); // Click on Hotlist Icon
		driver.findElement(By.xpath("//*[button='Add Label']")).click(); // Add Label Button
		driver.findElement(By.id("hotlist_name")).sendKeys("Asad Automation"); // HotList Name
		driver.findElement(By.id("is_public")).isSelected(); // CheckBox for Public
		driver.findElement(By.id("btn-hotlist-labels")).click(); // Save Button		
	}

}
