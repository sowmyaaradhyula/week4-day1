package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Login
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//Merger Contacts
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		
		//click on widget of from contact
		
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		
		//Get list of windows
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> allWindowHandleList = new ArrayList<String>(windowHandles);
		allWindowHandleList.addAll(allWindowHandleList);
		
		//Switch to new Window
		
		String newWindow = allWindowHandleList.get(1);
		
		driver.switchTo().window(newWindow);
		System.out.println(driver.getTitle());
		
		driver.manage().window().maximize();
		
		//get the first resulting contact
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		
		//switch back to original window
		
		String originalWindow = allWindowHandleList.get(0);
		driver.switchTo().window(originalWindow);
		System.out.println(driver.getTitle());
		
		//click on widget of To contact
		
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		
		//Get list of windows
		
        Set<String> windowHandles1 = driver.getWindowHandles();
		
		List<String> allWindowHandleList1 = new ArrayList<String>(windowHandles1);
		allWindowHandleList.addAll(allWindowHandleList1);
		
		//switch to new window(2nd time)
		
		String newWindow1 = allWindowHandleList1.get(1);
		
		driver.switchTo().window(newWindow1);
		System.out.println(driver.getTitle());
	    driver.manage().window().maximize();
	    
	    //click on second resulting contact
	    
	    driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
	    
	    //Siwtch back to original window(2nd time)
	    
	    String originalWindow1 = allWindowHandleList1.get(0);
		
		driver.switchTo().window(originalWindow1);
		System.out.println(driver.getTitle());
		
		//click on merge
	    
	    driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
	    
	    //Accepting the alert
	    
	    driver.switchTo().alert().accept();
	    
	    //print the Title of the page
	    
	    System.out.println(driver.getTitle());
	    
	    
	    driver.quit();
	    
		
        

	}

}
