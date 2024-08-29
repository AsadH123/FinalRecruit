package JobOrder_Action_List;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Video_Application_Question {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Scanner input = new Scanner(System.in);
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
		driver.findElement(By.linkText("Job Orders")).click(); // Job Orders Tab
		Thread.sleep(2000);

		// Click on job orders in which user wants to click reminder button

		List<WebElement> JobTitles = driver.findElements(By.cssSelector("table#table2 tbody tr td a.item-detail-linkedin-view"));
		for (WebElement element : JobTitles) {
			if (element.getText().equals("Selenium Java")) {
				element.click();
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("li a.dropdown-toggle i.fa-ellipsis-h")).click(); // Click on More Icon
		List <WebElement> more_drop = driver.findElements(By.cssSelector("ul.dropdown-menu li a span"));
		Thread.sleep(1000);
		for(WebElement element: more_drop) {
			if(element.getText().equals("Video Application Questions")) {
				element.click();
				break;
			}
		}
		
		int no_of_question = 3;
		for(int i = 0; i<no_of_question; i++) {
			System.out.println("Enter Questions Here: ");
			String Add_Question = input.nextLine();
			driver.findElement(By.cssSelector("form#frmQuestions div input.form-control")).sendKeys(Add_Question);
			if (i != (no_of_question - 1)) {
				driver.findElement(By.className("multi_add_question_button")).click();		
            } else {
                System.out.println("Skipping the last iteration.");
            }
		}
		driver.findElement(By.id("btnSaveQuestion")).click(); // Save Question Button
	}

}
