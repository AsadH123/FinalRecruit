package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Expense {

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
		
		driver.findElement(By.xpath("//*[@class='hidden-xs' and text()='New']")).click(); // New Link Text
		driver.findElement(By.linkText("Expense")).click(); // Click Link Text Expense
		
		driver.findElement(By.xpath("//*[@name='expense_report_title']")).sendKeys("Expense Report");
		WebElement expenseType = driver.findElement(By.id("type"));
		Select selectType = new Select(expenseType);
		selectType.selectByVisibleText("Internal Expenses");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-expense_approver_id-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("talha");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-expense_approver_id-results")).click();
		
		driver.findElement(By.xpath("//*[@name='expense_items[0][expense_date]']")).click();
		driver.findElement(By.className("ui-datepicker-today")).click();
		
		WebElement expense_Type = driver.findElement(By.xpath("//*[@name='expense_items[0][expense_type]']"));
		Select select_Type = new Select(expense_Type);
		select_Type.selectByVisibleText("Billable");
		
		WebElement billType = driver.findElement(By.xpath("//*[@name='expense_items[0][expense_bill_type]']"));
		Select selectBill = new Select(billType);
		selectBill.selectByVisibleText("Food");
		
		WebElement category = driver.findElement(By.xpath("//*[@name='expense_items[0][expense_category]']"));
		Select categoryType = new Select(category);
		categoryType.selectByVisibleText("Amount Payable");
		
		driver.findElement(By.xpath("//*[@name='expense_items[0][expense_amount]']")).sendKeys("12");
		driver.findElement(By.xpath("//*[@name='expense_items[0][expense_comments]']")).sendKeys("Testing");
		
		//driver.findElement(By.id("expense_receipt")).click();
		
		Thread.sleep(2000);
		WebElement upload_file = driver.findElement(By.id("expense_receipt"));
		upload_file.sendKeys("C:\\Users\\Asad\\Desktop\\Candidates.csv");
		//driver.findElement(By.id("import_submit")).click();
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement process = driver.findElement(By.xpath("//*[@value='Submit Expense']"));
		process.click();
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		WebElement finish = driver.findElement(By.xpath("//*[@value='Finish']"));
//		finish.click();
	}

}
