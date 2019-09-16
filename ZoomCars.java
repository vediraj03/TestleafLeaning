package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomCars {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.zoomcar.com/chennai");
		driver.findElementByLinkText("Start your wonderful journey").click();
		driver.findElementByXPath("//div[contains(text(),'Kodambakkam')]").click();
		driver.findElementByXPath("//button[text()='Next']").click();
		driver.findElementByXPath("//div[@class='days']//following::div[2]").click();
		driver.findElementByXPath("//button[text()='Next']").click();
		driver.findElementByXPath("//button[text()='Done']").click();
		
		
		List<Integer> ls = new ArrayList<Integer>();
			
		List<WebElement> elePrice = driver.findElementsByClassName("price");
		String textPrice;
		System.out.println(elePrice.get(1).getText());
		String[] splitPrice;
		for (WebElement lsprice : elePrice) {
			System.out.println(lsprice.getText());
			 textPrice = lsprice.getText();
			splitPrice = textPrice.split(" ");
			String priceValue =splitPrice[1];
			 
			if(priceValue.contains(",")) {
				
				String StringPrint = priceValue.replaceAll(",", "");
			int priceValue1 =Integer.parseInt(StringPrint);
			ls.add(priceValue1);
			}
			else {
			ls.add(Integer.parseInt(priceValue));
			//System.out.println(lsprice.getText());
			}
		}
		Collections.sort(ls);			
		String lowestPrice = ls.get(0).toString();
		List<WebElement> eleBrandName = driver.findElementsByXPath("//div[@class='details']/h3");
		System.out.println(eleBrandName.get(1).getText());
		for (int i = 0; i < eleBrandName.size(); i++) {
			String[] split = elePrice.get(i).getText().split(" ");
			if(lowestPrice.contains(split[1])) {
				System.out.println("Lowest Price car Brand Name :"+eleBrandName.get(i).getText());
				
				break;
			}
		} 
		
		File eleSnap = driver.getScreenshotAs(OutputType.FILE);
		File obj = new File("./Snaps/img.png");
		FileUtils.copyFile(eleSnap, obj);
		
		
     driver.close();
	}

}
