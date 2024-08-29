package Company_Action_List;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upload_File {

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
		driver.findElement(By.xpath("//*[@data-original-title='Add New Document']")).click(); // Click on Add New Document Icon
		WebElement upload_file = driver.findElement(By.xpath("//*[@id=\"fileupload\"]")); // File Upload
		upload_file.sendKeys("C:\\Users\\Asad\\Desktop\\New Upload File.docx");
		driver.findElement(By.xpath("//*[@name='document_title']")).sendKeys("Muhammad Asad Haider"); // Name
		driver.findElement(By.xpath("//*[@name='document_description']")).sendKeys("New Document has been uploaded"); // Description
		
		
		driver.findElement(By.id("document_submit")).click(); // Add Button

	}

}
