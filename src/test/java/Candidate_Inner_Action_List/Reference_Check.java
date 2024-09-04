package Candidate_Inner_Action_List;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reference_Check {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
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
        
        WebElement assessmentTest = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/ul/li[20]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", assessmentTest);
        Thread.sleep(1000);
        assessmentTest.click(); // Reference Check

        Thread.sleep(1000);
        WebElement noOf_References = driver.findElement(By.id("references_required"));
        noOf_References.clear();
        noOf_References.sendKeys("2");

        Thread.sleep(1000);
        WebElement questionnarie = driver.findElement(By.id("reference_questionnaire_id"));
        Select Questionnarie = new Select(questionnarie);
        Questionnarie.selectByIndex(2);

        driver.findElement(By.className("select2-selection__rendered")).click();
        driver.findElement(By.className("select2-search__field")).sendKeys("Testing Job 1");
        Thread.sleep(1000);
        driver.findElement(By.id("select2-reference_request_job_id-results")).click();

        driver.findElement(By.xpath("//*[@id='sendCareerApplicationForm']/div[3]/div/input[2]")).click();
    }
}
