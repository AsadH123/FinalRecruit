package Candidate_Action_List;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Review_Candidate {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
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
		driver.findElement(By.linkText("Candidates")).click(); // Candidates Tab
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Asghar", Keys.ENTER); // First Name Search Box
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Zaidi", Keys.ENTER); // Last Name Search Box
		driver.findElement(By.linkText("Asghar")).click(); // Contact Link Text
		driver.findElement(By.xpath("//*[@data-original-title='Review Candidate']")).click(); // Click on Review Candidate Icon
		// Rating Skills
        try {
        	Thread.sleep(2000);
            List<WebElement> starRatingElements = driver.findElements(By.className("rating-stars"));

            // Iterate over each star rating element and simulate hover
            for (WebElement starElement : starRatingElements) {
                actions.moveToElement(starElement).perform();
                

                Thread.sleep(3000);

                // Verify if the star is highlighted by checking its CSS class
                String starClass = starElement.getAttribute("style");
                System.out.println(starClass);
                if (starClass.equals("width: 0%;")) {
                    System.out.println("Star is highlighted on hover!");
                    actions.moveByOffset(60, 0).click().perform();
                    break;
                } else {
                    System.out.println("Star is not highlighted on hover!");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
    }
        driver.findElement(By.xpath("//*[@placeholder='Note']")).sendKeys("Test NOte"); // Note
        driver.findElement(By.xpath("//*[@type='submit' and text()='Submit']")).click(); // Submit Button
	}

}
