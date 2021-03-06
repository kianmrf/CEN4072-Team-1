package systemTests;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;

import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;


@RunWith(Parameterized.class)
public class SecurityQuestionTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	private String empID;
	private String username;
	private String secQ1;
	private String ans1;
	private String secQ2;
	private String ans2;
	private String secQ3;
	private String ans3;


	public SecurityQuestionTest(String empID, String username, String secQ1, String ans1, 
			String secQ2, String ans2, String secQ3, String ans3) {
		super();
		this.empID = empID;
		this.username = username;
		this.secQ1 = secQ1;
		this.ans1 = ans1;
		this.secQ2 = secQ2;
		this.ans2 = ans2;
		this.secQ3 = secQ3;
		this.ans3 = ans3;
	}


	@Before
	public void setUp() {
		// Setting up path to Google Chrome driver (chdriver)
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kianm\\repos\\CEN4072-Team-1\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] { 
			{"1", "adam", "Favorate Color?", "pink", "First PEt Name?", "adam", "Favorate Color?", "adam"},
			{"1", "adam", "Favorate Color?", "pink", "First PEt Name?", "adam", "First PEt Name", "lisa"},
			{"99", "john", "Favorate Color?", "pink", "First PEt Name?", "adam", "First PEt Name", "lisa"},
			{"1", "adam", "Favorate Color?", "pink", "First PEt Name?", "adam", "First PEt Name", ""},
			{"1", "adam", "Favorate Color?", "", "First PEt Name?", "adam", "", ""},
			{"2", "adam", "Favorate Color?", "pink", "First PEt Name?", "adam", "Favorite Movie?", "adam"}
		});
	}



	@After
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void securityQuestion() {
		// Test name: SecurityQuestion
		// Step # | name | target | value | comment
		// 1 | open | http://localhost:8080/PMS/emplogin.jsp |  | 
		driver.get("http://localhost:8080/PMS/emplogin.jsp");
		// 2 | setWindowSize | 1200x781 |  | 
		driver.manage().window().setSize(new Dimension(1200, 781));
		// 3 | click | id=c |  | 
		driver.findElement(By.id("c")).click();
		// 4 | click | css=i |  | 
		driver.findElement(By.cssSelector("i")).click();
		// 5 | click | id=c |  | 
		driver.findElement(By.id("c")).click();
		// 6 | type | id=c | 1 | 
		driver.findElement(By.id("c")).sendKeys(empID);
		// 7 | click | name=uid |  | 
		driver.findElement(By.name("uid")).click();
		// 8 | type | name=uid | adam | 
		driver.findElement(By.name("uid")).sendKeys(username);
		// 9 | click | name=s1 |  | 
		driver.findElement(By.name("s1")).click();
		// 10 | select | name=s1 | label=Favorate Color? | 
		{
			WebElement dropdown = driver.findElement(By.name("s1"));
			dropdown.findElement(By.xpath(String.format("//option[. = '%s']", secQ1))).click();
		}
		// 11 | click | name=a1 |  | 
		driver.findElement(By.name("a1")).click();
		// 12 | type | name=a1 | Pink | 
		driver.findElement(By.name("a1")).sendKeys(ans1);
		// 13 | click | name=s2 |  | 
		driver.findElement(By.name("s2")).click();
		// 14 | select | name=s2 | label=First PEt Name? | 
		{
			WebElement dropdown = driver.findElement(By.name("s2"));
			dropdown.findElement(By.xpath(String.format("//option[. = '%s']", secQ2))).click();
		}
		// 15 | click | name=a2 |  | 
		driver.findElement(By.name("a2")).click();
		// 16 | type | name=a2 | Adam | 
		driver.findElement(By.name("a2")).sendKeys(ans2);
		// 17 | click | name=s3 |  | 
		driver.findElement(By.name("s3")).click();
		// 18 | select | name=s3 | label=First PEt Name? | 
		{
			WebElement dropdown = driver.findElement(By.name("s3"));
			dropdown.findElement(By.xpath(String.format("//option[. = '%s']", secQ3))).click();
		}
		//
		// 21 | click | name=a3 |  | 
		driver.findElement(By.name("a3")).click();
		// 22 | type | name=a3 | Adam | 
		driver.findElement(By.name("a3")).sendKeys(ans3);
		// 23 | click | id=submit |  | 
		driver.findElement(By.id("submit")).click();
		
		try 
		{
			//Handle the alert pop-up 
			Alert alert = driver.switchTo().alert();

			//get the message which is present on pop-up
			String message = alert.getText();

			assertTrue(message.contains("user details not found"));

			//print the pop-up message
			System.out.println(message);
			//Click on OK button on pop-up
			alert.accept();
		} 
		catch (NoAlertPresentException e) 
		{
			//if alert is not present print message
			System.out.println("alert is not present");
			assertTrue(false);
		}
		
		driver.close();
	}
}
