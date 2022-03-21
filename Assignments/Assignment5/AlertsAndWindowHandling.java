package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAndWindowHandling {

	public static void main(String[] args) 
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		
		//get the list of windows
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> windowsList = new ArrayList<>(windowHandles);
		
		
		//navigate to first window
		
		String currentWindow = windowsList.get(0);
		String newWindow = windowsList.get(1);
		driver.switchTo().window(newWindow);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//button[@class='izooto-optin--cta izooto-optin--cta-later']")).click();
		
		driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
	    
	    String text = driver.findElement(By.xpath("(//div[@class='dropdown-menu show']/a)[3]")).getText();
        System.out.println("Customer Care Email ID is " + text);
        
        
		driver.switchTo().window(currentWindow);
		driver.close();
	}

}
