package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrame {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://leafground.com/pages/frame.html");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='default.html']")));
		 driver.findElement(By.id("Click")).click();
		 File src = driver.getScreenshotAs(OutputType.FILE);		
			File dst= new File("./snap/ClickME_Frame1.png");		
			FileUtils.copyFile(src, dst);
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='page.html']")));
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='nested.html']")));
		 WebElement clickEle = driver.findElement(By.id("Click1"));
		 driver.findElement(By.id("Click1")).click();
		 File src1 = clickEle.getScreenshotAs(OutputType.FILE);		
			File dst1 = new File("./snap/ClickME_NestedFramenew.png");		
			FileUtils.copyFile(src1, dst1);
		 driver.switchTo().defaultContent();
		 List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		 int size = iframeList.size();
		 int totalFrames = driver.findElements(By.tagName("iframe")).size();			
			System.out.println("Number of frames are "+totalFrames);
			System.out.println("Number of frames are "+size);
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='count.html']")));
		 
	}

}
