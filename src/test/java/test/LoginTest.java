package test;

import java.io.BufferedReader;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		String csvFilePath = "C:\\Users\\Asad\\Desktop\\login_credentials.csv";
		
		try {
			FileReader fileReader = new FileReader(csvFilePath);
            BufferedReader reader = new BufferedReader(fileReader);
            //CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withQuote(null));
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null) {
            	String[] data = line.split(",");
                String email = data[0];
                String password = data[1];

                // Navigate to the login page
        		driver.navigate().to("https://xdev.recruitbpm.com/users/login");
        		
                // Find the email and password input fields and enter the credentials
        		driver.findElement(By.name("identity")).sendKeys(email.replace("\"",""));
        		driver.findElement(By.id("password")).sendKeys(password.replace("\"",""));
        		
        		driver.findElement(By.id("submit")).click();
        		
        		// Add appropriate if required for the login process to complete.
                // Verify if the login was successful
                if (driver.getCurrentUrl().equals("https://xdev.recruitbpm.com/")) {
                    System.out.println("Login successful for user: " + email);
                } else {
                    System.out.println("Login failed for user: " + email);
                }
        		//driver.quit();
            }
		} catch (Exception e) {
            e.printStackTrace();
		}
	}
}
