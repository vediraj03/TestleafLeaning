package week2.selenium;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MargeLead {
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

				
		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByLinkText("Merge Leads").click();
		driver.findElementByXPath("//input[@id='partyIdFrom']//following::img[1]").click();
		
		String name="Vediraj";
		
		Set<String> currentWindows = driver.getWindowHandles();
		List<String> ls = new ArrayList<String>(currentWindows);
		driver.switchTo().window(ls.get(1));
		
		driver.findElementByXPath("//input[@name='firstName']").sendKeys(name);
		driver.findElementByXPath("(//button[contains(@type,'button')])[1]").click();
		WebElement eleFrom = driver.findElementByXPath("(//table[contains(@class,'row-table')]//a)[1]");
		String eleFromdata = eleFrom.getText();
		eleFrom.click();
		driver.switchTo().window(ls.get(0));
		driver.findElementByXPath("//input[@id='partyIdTo']//following::img[1]").click();
		
		Set<String> scondWindows = driver.getWindowHandles();
		List<String> ls1 = new ArrayList<String>(scondWindows);
		driver.switchTo().window(ls1.get(1));
		driver.findElementByXPath("//input[@name='firstName']").sendKeys(name);
		driver.findElementByXPath("(//button[contains(@type,'button')])[1]").click();
		Thread.sleep(2000);
		WebElement eleTo = driver.findElementByXPath("(//div[contains(@class,'partyId')]//a)[3]");
		String eleTodata = eleTo.getText();
		eleTo.click();
		
		driver.switchTo().window(ls1.get(0));
		driver.findElementByLinkText("Merge").click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("(//input[contains(@id,'ext-gen')])[30]").sendKeys(eleFromdata);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		WebElement resultsVal = driver.findElementByXPath("//div[contains(@class,'paging')]");
		String resultsText = resultsVal.getText();
		System.out.println(resultsText);
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File obj = new File("./snap/Meargeimage.png");
		FileUtils.copyFile(src, obj);
		
		if(resultsText.equalsIgnoreCase("No records to display")){
			System.out.println(eleFromdata+" is Sucessfully Marged with : " +eleTodata);
		}
		else{
			System.out.println(eleFromdata+"is not Marged with : " +eleTodata);
		}
	}



}
