package week2.day02;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day2Assn2EditLead {

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
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Divya");		
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(3000);
		WebElement firstLinkName=driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-firstName')]/a[@class]"));
		//String linkText=firstLinkName.getText();
		//System.out.println("Captured Name is : " +linkText); 
		firstLinkName.click();		 
		Thread.sleep(2000);
				
		String actualTitle=driver.getTitle();
		String expectedTitle="View Lead | opentaps CRM";
		
		if(actualTitle.equals(expectedTitle))
		{		
		System.out.println(" Title is displayed : " +actualTitle);
		
		}
		else
			System.out.println("Title is not displayed");
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeaf Updated");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(2000);
		WebElement updatedCompanyName=driver.findElement(By.id("viewLead_companyName_sp"));
		String dName=updatedCompanyName.getText();
		System.out.println("Updated Name is : " +dName);
		
		if(dName.contains("TestLeaf Updated"))
		{		
		System.out.println("Company Name Updated successfully!");
		
		
		}
		else
			System.out.println("Company Name not updated!");
			
		driver.close();

}
}