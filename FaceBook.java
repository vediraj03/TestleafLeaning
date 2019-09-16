package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FaceBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://www.facebook.com/");
		
		driver.findElementByXPath("//input[@id='email']").sendKeys("username");
		driver.findElementByXPath("//input[@id='pass']").sendKeys("Password");
		driver.findElementByXPath("//input[@type='submit']").click();
		
		driver.findElementByXPath("(//input[@placeholder='Search'])[1]").sendKeys("TestLeaf",Keys.ENTER);
		//driver.findElementByXPath("(//button[@type='submit'])[1]").click();
		
		WebElement eleTestLeaf = driver.findElementByLinkText("TestLeaf");
		//driver.switchTo().alert().accept();
		
		if(eleTestLeaf.getText().contains("TestLeaf")){
			
			String textLike = driver.findElementByXPath("(//button[@type='submit'])[2]//i").getText();
			if(textLike.equalsIgnoreCase("Like")){
				driver.findElementByXPath("(//button[@type='submit'])[2]").click();
				
				
			}
			else{
				System.out.println("Already Linked");
				
			}
			
		}
		driver.findElementByXPath("(//a[text()='TestLeaf'])[1]").click();
		String titleTest= driver.getTitle();
		System.out.println(titleTest);
		
		String textLikeTest = driver.findElementByXPath("//a[text()='Invite your friends']//following::div[10]").getText();
		System.out.println(textLikeTest);
		
		 String numberOnly= textLikeTest.replaceAll("[^0-9]", "");
		 System.out.println("Number of likes : "+numberOnly);

	}

}
