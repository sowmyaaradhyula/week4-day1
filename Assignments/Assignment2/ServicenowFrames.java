package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServicenowFrames {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("https://dev115655.service-now.com/navpage.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement element = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(element);
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		
		driver.findElement(By.id("user_password")).sendKeys("Sweety@2204");
		
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		
		
		WebElement element2 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(element2);
		driver.findElement(By.xpath("//button[@value='sysverb_new']")).click();
		
			
		
		driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys("admin",Keys.ENTER);		
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Sample case");
		
		
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");		
		System.out.println("Incident Number is " + incidentNumber);
		
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber,Keys.ENTER);
		
		//capture screenshot
		File snapshot = driver.getScreenshotAs(OutputType.FILE);
		
		//create image file
		
		File file = new File("./snapshots/image1.jpg");
		
		//combining
		
		FileUtils.copyFile(snapshot, file);
		
		driver.quit();
		
		
		
		
		
		
			
		
		
		
	
		

	}

}
