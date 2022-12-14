import java.io.IOException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AutomateWebApplication {
	public static void main(String[] args) throws IOException, InterruptedException {
		AutomateWebApplication thisObj = new AutomateWebApplication();
		thisObj.registration();
		thisObj.login();
	}
	@Test
	public void registration(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("C:/Users/hp/Downloads/JFD-PH-ae8b9bc6c13578074b3e8f473309b6c72d3bb5c2/JFD-PH-ae8b9bc6c13578074b3e8f473309b6c72d3bb5c2/Phase 5/Lesson 1/Automate_a_Web_Application/Web App/HTML/registration.html");               
					
		WebElement firstname = driver.findElement(By.name("firstname"));
		WebElement lastname = driver.findElement(By.name("lastname"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement phone = driver.findElement(By.name("number"));
		WebElement uname = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));

		String emailAddress= "test@mailinator.com";
			 
		firstname.sendKeys("Shubham");
		lastname.sendKeys("Srivastava");
		email.sendKeys(emailAddress);
		phone.sendKeys("123456789");
		uname.sendKeys("shubham");
		password.sendKeys("jack@123");
			 
		driver.findElement(By.id("registerButton")).click();
		try {		 
			WebDriverWait wait2 = new WebDriverWait(driver, 5);		
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("success")));
    } catch (TimeoutException e) {
      driver.findElement(By.id("registerButton")).click();
      WebDriverWait wait3 = new WebDriverWait(driver, 5);		
			wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("success")));
    }
			
		if (driver.getPageSource().contains("You successfully registered yourself.")) {
			System.out.println("PASS: Registration successful");
		} else {
			System.out.println("Fail registration process");
		}
	}
	
    @Test
	public void login(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("C:/Users/hp/Downloads/JFD-PH-ae8b9bc6c13578074b3e8f473309b6c72d3bb5c2/JFD-PH-ae8b9bc6c13578074b3e8f473309b6c72d3bb5c2/Phase 5/Lesson 1/Automate_a_Web_Application/Web App/HTML/login.html");               
					
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));

		String emailAddress= "test@mailinator.com";
			 
		email.sendKeys(emailAddress);
		password.sendKeys("jack@123");
			 
		driver.findElement(By.id("loginButton")).click();
		try {		 
			WebDriverWait wait2 = new WebDriverWait(driver, 5);		
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail")));
    } catch (TimeoutException e) {
      driver.findElement(By.id("loginButton")).click();
      WebDriverWait wait3 = new WebDriverWait(driver, 5);		
			wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail")));
    }
			
		if (driver.getPageSource().contains("Shubham")) {
			System.out.println("PASS: Login successful");
		} else {
			System.out.println("Fail Login process");
		}
	}
}