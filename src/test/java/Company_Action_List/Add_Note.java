package Company_Action_List;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Add_Note {

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

		// Add Note 
		driver.findElement(By.className("menutoggle")).click(); // Menu Button
		driver.findElement(By.linkText("Companies")).click(); // Companies Tab
		Thread.sleep(2000);
		
		// Click on company in which user wants to add note
		
		List <WebElement> company_table = driver.findElements(By.cssSelector("table#table2 tr td a"));
		System.out.println(company_table.size());
		
		for (WebElement element : company_table) {
            
            if(element.getText().equals("Asad Tech")) {
            	System.out.println(element.getText());
            	element.click();
            	break;	
            }
		}
				
		driver.findElement(By.xpath("//*[@data-original-title='Add Note']")).click(); // Click on Add Note Icon
		
		WebElement comment_iframe = driver.findElement(By.className("cke_wysiwyg_frame")); // Inside IFrame
		driver.switchTo().frame(comment_iframe);
		WebElement comment = driver.findElement(By.cssSelector("body.cke_show_borders"));
		Thread.sleep(2000);
		comment.sendKeys("Test Note Has Been Added in Company Asad Tech"); // Comment
		driver.switchTo().defaultContent(); //Outside IFrame
		
		driver.findElement(By.id("btn-addnotes")).click(); // Save Button
		
		// Assert or Verify the Note
		WebElement Note_Text = driver.findElement(By.xpath("//*[@id=\"28455\"]/div/div[2]/p"));

        String actualText = Note_Text.getText(); // Actual Text
        System.out.println(actualText);
        String[] textParts = actualText.split("[|]", 2); // Split the text

        Thread.sleep(2000);
        String expectedText = "Test Note Has Been Added in Company Asad Tech"; // Expected text
        String assertedText = textParts[1].trim(); // Asserted Text
        
        if (assertedText.equals(expectedText)) {
            System.out.println("Assertion Passed: Text is as expected.\n" + assertedText);
        } else {
            System.out.println("Assertion Failed: Text is not as expected.\n" + assertedText);
        }
	}

}
