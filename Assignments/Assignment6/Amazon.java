package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price of the first product is " + price);
		
		String ratings = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("Number of ratings are " + ratings);
		
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-popover'])[2]")).click();
		
		String fiveStar = driver.findElement(By.xpath("(//span[@class='a-size-base'])[2]/a")).getText();
		System.out.println("Number of five star ratings are " + fiveStar);
		
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		ArrayList<String> windowHandleslist = new ArrayList<>(windowHandles);
		
		String newWindow = windowHandleslist.get(1);
		driver.switchTo().window(newWindow);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//span[@id='attach-sidesheet-view-cart-button'])[1]")).click();
		
		String cart = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']")).getText();
		System.out.println("Cart total is " + cart);
		
		if(cart.contains(price))
		{
			System.out.println("Success");
		}
		else
		{
			System.out.println("Retry");
		}
		
		File snapshot = driver.getScreenshotAs(OutputType.FILE);
		
		File amazon = new File("./snapshots/amazon.jpg");
		
		FileUtils.copyFile(snapshot, amazon);
		
		driver.quit();
	
        
        
        
        
        
        
        
        
	}

}
