package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Thread.sleep(3000);
		Set<String> setWin = driver.getWindowHandles();
		List<String> listWin = new ArrayList<String>(setWin);
		System.out.println("window size is "+ listWin.size() );
		System.out.println("window 1 title is" + driver.getTitle());
		driver.switchTo().window(listWin.get(1));
		driver.findElement(By.xpath("//table//tbody//tr//td/div//a")).click();
		driver.switchTo().window(listWin.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> setWin1 = driver.getWindowHandles();
		List<String> listWin1 = new ArrayList<String>(setWin1);
		driver.switchTo().window(listWin1.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//table//tbody//tr//td/div//a)[5]")).click();	
		driver.switchTo().window(listWin1.get(0));
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();	
		Alert simpleaAlert = driver.switchTo().alert();
		simpleaAlert.accept();
		System.out.println("page title is " + driver.getTitle());
		
		driver.close();
		
	}

}
