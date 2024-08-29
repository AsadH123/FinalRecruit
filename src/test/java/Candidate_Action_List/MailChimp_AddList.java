package Candidate_Action_List;

import java.io.BufferedReader;
import java.io.FileReader;
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
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailChimp_AddList {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
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

		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Asghar", Keys.ENTER); // First Name
																										// Search Box
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Zaidi", Keys.ENTER); // Last Name Search
																										// Box
		driver.findElement(By.linkText("Asghar")).click(); // Candidate Link Text
		driver.findElement(By.cssSelector("ul.vertical-menu li a.dropdown-toggle")).click(); // Click on DropDown Toggle
																								// Menu Icon

		List<WebElement> vertical_sub_menu = driver.findElements(By.cssSelector("ul.vertical-submenu li a ")); // Vertical
																												// SubMenu
		for (WebElement element : vertical_sub_menu) {
			if (element.getText().equals("MailChimp")) {
				element.click();
				break;
			}
		}
		driver.findElement(By.xpath("//*[text()='Add List']")).click(); // Add List Button

		String csvFilePath = "C:\\Users\\Asad\\Desktop\\Add List.csv";

		try {
			FileReader fileReader = new FileReader(csvFilePath);
			BufferedReader reader = new BufferedReader(fileReader);
			// CSVParser csvParser = new CSVParser(fileReader,
			// CSVFormat.DEFAULT.withQuote(null));
			String line;
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				String List_Name = data[0];
				String Company = data[1];
				String Location = data[2];
				String Location_City = data[3];
				String Location_State = data[4];
				String Location_ZipCode = data[5];
				String From_Name = data[6];
				String From_Email = data[7];
				String Reminder = data[8];

				driver.findElement(By.xpath("//*[@name='name']")).sendKeys(List_Name.replace("\"", "")); // List Name
				driver.findElement(By.xpath("//*[@name='contact[company]']")).sendKeys(Company.replace("\"", "")); // Company
				driver.findElement(By.xpath("//*[@name='contact[address1]']")).sendKeys(Location.replace("\"", "")); // Location
				driver.findElement(By.xpath("//*[@name='contact[city]']")).sendKeys(Location_City.replace("\"", "")); // City
				driver.findElement(By.xpath("//*[@name='contact[state]']")).sendKeys(Location_State.replace("\"", "")); // State
				driver.findElement(By.xpath("//*[@name='contact[zip]']")).sendKeys(Location_ZipCode.replace("\"", "")); // ZipCode
				driver.findElement(By.xpath("//*[@name='campaign_defaults[from_name]']"))
						.sendKeys(From_Name.replace("\"", "")); // From Name
				driver.findElement(By.xpath("//*[@name='campaign_defaults[from_email]']"))
						.sendKeys(From_Email.replace("\"", "")); // From Email
				driver.findElement(By.xpath("//*[@name='permission_reminder']")).sendKeys(Reminder.replace("\"", "")); // Reminder

				driver.findElement(By.cssSelector("div.modal-footer button.btn-primary")).click(); // Save button
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
