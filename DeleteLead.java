package week2.selenium;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

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
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("8489787373");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		WebElement eleFirstrow = driver.findElementByXPath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a");
	
		String valueFirstrow = eleFirstrow.getText();
		System.out.println(valueFirstrow);
		eleFirstrow.click();
		
		driver.findElementByXPath("//a[text()='Delete']").click();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//input[@name='id']").sendKeys(valueFirstrow);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		WebElement elefindLead = driver.findElementByXPath("//div[text()='No records to display']");
		String findLeadText = elefindLead.getText();
		
		if(findLeadText.equalsIgnoreCase("No records to display")){
			System.out.println("Lead record is sucessfully deleted :"+findLeadText);
		}
		
		Thread.sleep(2000);
		//driver.close();

	}

}
