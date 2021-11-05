package week4.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCherTech {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		 driver.switchTo().frame(driver.findElement(By.id("frame1")));			
		 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Framestext field");
		 driver.switchTo().frame(driver.findElement(By.id("frame3")));	
		driver.findElement(By.id("a")).click();		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("frame2")));			
		WebElement animalDrop = driver.findElement(By.id("animals"));	
		//eleSource.click();
		Select animalDropDown=new Select(animalDrop);
		animalDropDown.selectByVisibleText("Avatar");
		Thread.sleep(1000);
		driver.close();
	}

}
