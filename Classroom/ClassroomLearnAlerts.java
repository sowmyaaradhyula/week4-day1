package week4.day1;



import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomLearnAlerts {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//alert Box		
		
        driver.findElement(By.xpath("//button[contains(text(),'Alert Box')]")).click();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println("Text of Alert Box is " + text);
        alert.accept();
        
        //Confirm Box
        
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println("confirm Box says " +alert1.getText());
        alert.dismiss();
        
        //Prompt Box
        
        driver.findElement(By.xpath("//button[contains(text(),'Prompt Box')]")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println("Prompt box says " +alert2.getText());
        alert.accept();
        
        driver.close();
        
        
        

	}

}
