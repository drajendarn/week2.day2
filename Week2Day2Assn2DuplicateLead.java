package week2.day02;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day2Assn2DuplicateLead {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       	driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Leads")).click();		
		driver.findElement(By.partialLinkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("divya123@abc.com");		
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		WebElement firstLinkName=driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-firstName')]/a[@class]"));
		String linkText=firstLinkName.getText();
		System.out.println("Captured Name is : " +linkText); 
		firstLinkName.click();		 
		Thread.sleep(2000);
		driver.findElement(By.linkText("Duplicate Lead")).click();
		String actualTitle=driver.getTitle();
		String expectedTitle="Duplicate Lead | opentaps CRM";
		
		if(actualTitle.equals(expectedTitle))
		{		
		System.out.println("Dulicate Title is displayed : " +actualTitle);
		
		}
		else
			System.out.println("Dulicate Title is not displayed");
		
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		Thread.sleep(2000);
		WebElement duplicateName=driver.findElement(By.id("viewLead_firstName_sp"));
		String dName=duplicateName.getText();
		System.out.println("Duplicate Name is " +dName);
		
		if(dName.equals(linkText))
		{		
		System.out.println("Duplicate Name and Captured Names are Matched!");
		
		
		}
		else
			System.out.println("Duplicate Name and Captured Names are Not Matched!");
			
		driver.close();

}
}