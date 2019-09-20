package week2.selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLead {
	WebDriver driver;


	

	public static void main(String[] args) throws InterruptedException, IOException {
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
		String name ="Vediraj";
		String surnameXpath ="//input[@id='createLeadForm_lastName']";
		driver.findElementByXPath("//a[text()='Create Lead']").click();

		driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys("CTS");
		driver.findElementByXPath("//input[@id='createLeadForm_firstName']").sendKeys(name);
		driver.findElementByXPath(surnameXpath).sendKeys("B");

		WebElement eleSource = driver.findElementById("createLeadForm_dataSourceId");
		Select select = new Select(eleSource);
		select.selectByVisibleText("Employee");



		WebElement eleMarketing= driver.findElementById("createLeadForm_marketingCampaignId");
		Select select1 = new Select(eleMarketing);
		select1.selectByVisibleText("eCommerce Site Internal Campaign");

		driver.findElementById("createLeadForm_firstNameLocal").sendKeys("Ronish");
		driver.findElementById("createLeadForm_lastNameLocal").sendKeys("V");
		driver.findElementById("createLeadForm_personalTitle").sendKeys("Compay Details");
		driver.findElementById("createLeadForm_birthDate").sendKeys("06/02/1988");
		driver.findElementById("createLeadForm_generalProfTitle").sendKeys("Compay User Details");
		driver.findElementById("createLeadForm_departmentName").sendKeys("IT");
		driver.findElementById("createLeadForm_annualRevenue").sendKeys("450000");

		WebElement eleCurrency = driver.findElementById("createLeadForm_currencyUomId");
		Select select2 = new Select(eleCurrency);
		select2.selectByValue("INR");


		WebElement eleIndustry = driver.findElementById("createLeadForm_industryEnumId");
		Select select3 = new Select(eleIndustry);
		select3.selectByVisibleText("Computer Software");

		WebElement eleOwner = driver.findElementById("createLeadForm_ownershipEnumId");
		Select select4 = new Select(eleOwner);
		select4.selectByVisibleText("Corporation");
		



		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("8489787373");
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("vediraj@gmail.com");


		driver.findElementByXPath("//input[@name='submitButton']").click();

		String firstName = driver.findElementByXPath("(//span[text()='First name']/following::span)[1]").getText();
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File obj = new File("./snap/Meargeimage.png");
		FileUtils.copyFile(src, obj);

		if(firstName.equals(name)){
			System.out.println("First name (Vediraj) is correct : "+firstName);
		}

		else{
			System.out.println("First name (Vediraj) is incorrect : "+firstName);
		}
		driver.close();

	}



}
