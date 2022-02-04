package week2.day02;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day2Assignment1 
{

	public static void main(String[] args)
	{
		System.setProperty("WebDriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		// create New Account 
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
		driver.findElement(By.name("firstname")).sendKeys("Divya");
		driver.findElement(By.name("lastname")).sendKeys("Rajendran");
		driver.findElement(By.name("reg_email__")).sendKeys("divya123@abc.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("divya123@abc.com");		
		driver.findElement(By.id("password_step_input")).sendKeys("Pass@123");
     	WebElement day=driver.findElement(By.id("day"));
     	Select dd1=new Select(day);
     	dd1.selectByValue("12");
     	WebElement month=driver.findElement(By.id("month"));
     	Select dd2=new Select(month);
     	dd2.selectByIndex(6);
     	WebElement year=driver.findElement(By.id("year"));
     	Select dd3=new Select(year);
     	dd3.selectByVisibleText("1991");
     	driver.findElement(By.xpath("//input[@name='sex' and @value='1']")).click();
		
			
	}
	

}
