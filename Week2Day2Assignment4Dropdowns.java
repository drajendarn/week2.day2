package week2.day02;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Week2Day2Assignment4Dropdowns 
{

	public static void main(String[] args)
	{
		System.setProperty("WebDriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();	
		
		//dropdown selection by Index
		
				WebElement dropdown1=driver.findElement(By.id("dropdown1"));
				Select dd=new Select(dropdown1);
				dd.selectByIndex(1);
		//dropdown selection by VisibleText
				WebElement dropdown2=driver.findElement(By.name("dropdown2"));
				Select dd1=new Select(dropdown2);
				dd1.selectByVisibleText("Selenium");
		//dropdown selection by Value	
				WebElement dropdown3=driver.findElement(By.id("dropdown3"));
				Select dd3=new Select(dropdown3);
				dd3.selectByValue("2");
	    //Size of the dropdown
				List<WebElement> dropdown4=driver.findElements(By.className("dropdown"));
				int size=dropdown4.size();
				System.out.println("Total number of drodpwn options :" + size);
		// Using SendKeys					
				WebElement dropdown5=driver.findElement(By.xpath("//option[contains(text(),'You can also use sendKeys to select')]/.."));
				dropdown5.sendKeys("Selenium");
					
				WebElement dropdown6=driver.findElement(By.xpath("//option[contains(text(),'Select your programs')]/.."));
				Select dd6=new Select(dropdown6);
				dd6.selectByValue("2");
					
				
				
	}
}

