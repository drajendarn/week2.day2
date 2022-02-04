package week2.day02;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Week2Day2Assignment4CheckBox 
{

	public static void main(String[] args)
	{
		System.setProperty("WebDriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();	
		
		//Select the languages that you know?
		driver.findElement(By.xpath("//div[contains(text(),'Java')]/input")).click();
		
		//Confirm Selenium is checked
		WebElement check=driver.findElement(By.xpath("//div[contains(text(),'Selenium')]/input"));
		System.out.println("Selenium Checked box is selected ? " + check.isSelected());
				
		//DeSelect only checked
		driver.findElement(By.xpath("//div[contains(text(),'I am Selected')]/input")).click();
		
		//Select all checkbox
		driver.findElement(By.xpath("//div[contains(text(),'Option 1')]/input")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Option 2')]/input")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Option 3')]/input")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Option 4')]/input")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Option 5')]/input")).click();
		
	}
}

