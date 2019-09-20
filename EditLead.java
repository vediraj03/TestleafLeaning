package week2.selenium;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

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
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("vediraj");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		driver.findElementByXPath("(//a[text()='vediraj'])[1]").click();
		
		driver.findElementByXPath("//a[text()='Edit']").click();
		
		WebElement eleEditCompany = driver.findElementById("updateLeadForm_companyName");
		eleEditCompany.clear();
		eleEditCompany.sendKeys("Amazon");
		
		driver.findElementByXPath("//input[@value='Update']").click();
		
		String eleUpdatedCompany = driver.findElementByXPath("//span[text()='Company Name']/following::span").getText();
		 String []UpdatedCompany = eleUpdatedCompany.split(" ");
		 System.out.println(UpdatedCompany[0]);
		 
		 if(UpdatedCompany[0].equalsIgnoreCase("Amazon")){
			 System.out.println("Updated Company Name is:" +UpdatedCompany[0]);
		 }
		
		if(eleUpdatedCompany.contains("Amazon")){
			System.out.println("Updated Company Name is:" +eleUpdatedCompany);
		}
			
		
		
		Thread.sleep(2000);
		driver.close();

	}

}
