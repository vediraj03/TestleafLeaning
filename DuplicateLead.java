package week2.selenium;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps");
		
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();

		Thread.sleep(2000);
		
		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("vediraj@gmail.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		WebElement findElementByXPath = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a");
		String firstLeadName = findElementByXPath.getText();
		System.out.println(firstLeadName);
		findElementByXPath.click();
		
		driver.findElementByXPath("//a[text()='Duplicate Lead']").click();
		
		WebElement firstNameDup = driver.findElementByXPath("//input[@id='createLeadForm_firstName']");
		
		String firstNameDuptext = firstNameDup.getText();
		String title = driver.getTitle();
		if(title.contains("Duplicate Lead")){
			System.out.println("Title is verified :"+title);
		}
				
		driver.findElementByXPath("//input[@name='submitButton']").click();
		
		String firstNameViewLead = driver.findElementByXPath("//span[text()='First name']/following::span").getText();
		if(firstLeadName.equalsIgnoreCase(firstNameViewLead)){
			System.out.println(firstLeadName+" First name validated sucessfully: "+firstNameViewLead);
		}
		Thread.sleep(2000);
		driver.close();

	}

}
