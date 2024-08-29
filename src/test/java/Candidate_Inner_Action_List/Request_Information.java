package Candidate_Inner_Action_List;

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

public class Request_Information {
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
		
		driver.findElement(By.cssSelector("li[data-sort='6'] a.activeAncher span i.dropdown-chevron")).click();
		driver.findElement(By.className("candidates_listing")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"table2_wrapper\"]/div[3]/div[3]/div[2]/div/table/tbody/tr[5]/td[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[8]/a")).click(); // Request Information

        Thread.sleep(1000);
        WebElement salutation = driver.findElement(By.xpath("//*[@name='email_salutation']"));
        Select Salutation = new Select(salutation);
        Salutation.selectByIndex(2);

        Thread.sleep(1000);
        WebElement emailTemplate = driver.findElement(By.id("email_template_id"));
        Select email_Template = new Select(emailTemplate);
        email_Template.selectByIndex(2);

        driver.findElement(By.xpath("//*[@name='subject']")).sendKeys(" Successfully");

        driver.findElement(By.className("select2-selection__rendered")).click();
        driver.findElement(By.className("select2-search__field")).sendKeys("Request Testing");
        Thread.sleep(1000);
        driver.findElement(By.id("select2-request_id-results")).click();

        WebElement sendBtn = driver.findElement(By.xpath("//*[@name='btnSend']"));
        js.executeScript("arguments[0].scrollIntoView(true);", sendBtn);
        sendBtn.click();

    }
}