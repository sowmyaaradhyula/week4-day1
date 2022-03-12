package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomLearnFrames {

	public static void main(String[] args) 
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Switch to frame
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//switch to alert
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Box says " +alert.getText());
		alert.sendKeys("Dhruv");
		alert.accept();
		
		System.out.println("Alert Box after updating name says " +driver.findElement(By.xpath("//p[@id='demo']")).getText());
		
	
	}

}
