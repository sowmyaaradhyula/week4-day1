package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3Frames {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//find the frame,switch to it and enter some value to textbox Topic
		
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Selenium");
		
		//since frame3 is nested frame in frame2 not switching to default frame
		
		 WebElement frame3 = driver.findElement(By.id("frame3"));
		 driver.switchTo().frame(frame3);
		    
		 driver.findElement(By.xpath("//input[@id='a']")).click();
		 
		//switch back to default frame
			
		driver.switchTo().defaultContent();
			
		//switch to the frame  
			
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
			
		//select value from dropdown
			
		WebElement element = driver.findElement(By.id("animals"));
		Select dd = new Select(element);
		dd.selectByIndex(2);
		
		driver.close();
		
		

	}

}
