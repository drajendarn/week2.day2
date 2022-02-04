package week2.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day2Assn2CreateContact {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
       	driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Contacts")).click();
		driver.findElement(By.partialLinkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Divya");				
		driver.findElement(By.id("lastNameField")).sendKeys("Rajendran");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Divyalocal");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Rajendranlocal");
		driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys("Functional");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Description");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("abc@gmail.com");
		WebElement state=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd=new Select(state);
		dd.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important Note update");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();		
		System.out.println("Page Title is :"+ driver.getTitle());
		
			}
	

}
