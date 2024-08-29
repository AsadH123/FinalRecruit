package test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Candidate {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		driver.manage().window().maximize();
		// Navigate to the login page
		driver.navigate().to("https://xdev.recruitbpm.com/users/login");
		
	    // Find the email and password input fields and enter the credentials
		driver.findElement(By.name("identity")).sendKeys("asad@recruitbpm.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submit")).click();
		
		//Add Single New Contact
		driver.findElement(By.xpath("/html/body/section[1]/div[2]/div[1]/ul/li[1]/div/button")).click(); // Menu Button
		driver.findElement(By.id("candidates_listing")).click(); // Candidates Listing
		driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("Ali"); // First Name
		driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys("Haider"); // Last Name
		driver.findElement(By.xpath("//*[@name='candidate_job_title']")).sendKeys("Software Quality Assurance Engineer"); // Candidate Job Title
		driver.findElement(By.xpath("//*[@name='email1']")).sendKeys("ali2@yopmail.com"); // Email
		driver.findElement(By.xpath("//*[@name='mobile']")).sendKeys("9134136977"); // Mobile
		Select status = new Select(driver.findElement(By.xpath("//*[@name='module_status_id']")));
		status.selectByVisibleText("Lead"); // Status
		jsExecutor.executeScript("window.scrollTo(0, 500)");
//		WebElement skills = driver.findElement(By.xpath("//*[@id=\"collapse411396\"]/div/div/div[12]/div[6]/div[1]/div/div[2]/span/span[1]/span"));
//		skills.click();
//		WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.className("select2-search__field")));
//		input.sendKeys("SQA Automation");
//		Thread.sleep(2000);
//		driver.findElement(By.id("select2-skill0-results")).click(); // Skills
//		Select select_exprience = new Select(driver.findElement(By.id("experience0")));
//		select_exprience.selectByVisibleText("3 Years"); // Experience
//		
//		// Rating Skills
//		        try {
//		            List<WebElement> starRatingElements = driver.findElements(By.className("rating-stars"));
//
//		            // Iterate over each star rating element and simulate hover
//		            for (WebElement starElement : starRatingElements) {
//		                actions.moveToElement(starElement).perform();
//		                actions.moveByOffset(50, 0).perform();
//
//		                Thread.sleep(3000);
//
//		                // Verify if the star is highlighted by checking its CSS class
//		                String starClass = starElement.getAttribute("style");
//		                System.out.println(starClass);
//		                if (starClass.equals("width: 60%;")) {
//		                    System.out.println("Star is highlighted on hover!");
//		                    starElement.click();
//		                    break;
//		                } else {
//		                    System.out.println("Star is not highlighted on hover!");
//		                }
//		            }
//		        } catch (InterruptedException e) {
//		            e.printStackTrace();
//		    }
//		driver.findElement(By.className("multi_add_field_button")).click(); // Add Multiple Skill Button
		
		// Profile Summary
		jsExecutor.executeScript("window.scrollTo(0, 500)");
		WebElement profile_iframe = driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe"));
		driver.switchTo().frame(profile_iframe); // Switch to IFrame
		WebElement inside_iframe = driver.findElement(By.xpath("/html/body"));
		inside_iframe.sendKeys("lorem ipsum"); // Profile Summary
		driver.switchTo().defaultContent();	 // Outside IFrame
		driver.findElement(By.id("candidate_submit")).click(); // Submit button	

		
		
	}

}
