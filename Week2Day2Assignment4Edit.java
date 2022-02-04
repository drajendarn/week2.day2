package week2.day02;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import net.jodah.failsafe.internal.util.Assert;

public class Week2Day2Assignment4Edit 
{

	public static void main(String[] args)
	{
		System.setProperty("WebDriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");	
		WebElement edit=driver.findElement(By.xpath("//label[contains(text(),'Append a text and press keyboard tab')]/following-sibling::input"));
		edit.sendKeys("AppendValue");
		edit.sendKeys(Keys.TAB);
		WebElement getValue=driver.findElement(By.xpath("//input[@name='username']"));
		System.out.println(getValue.getAttribute("value"));
		driver.findElement(By.xpath("//label[contains(text(),'Clear the text')]/following-sibling::input")).clear();
		WebElement anytextfield = driver.findElement(By.xpath("//label[contains(text(),'Confirm that edit field is disabled')]/following-sibling::input"));//.isEnabled();
		String aa= anytextfield.getAttribute("disabled");
		System.out.println(aa);
		if(aa.equals("true"))
		{
			System.out.println("Text fied disabled");
		}
		
			else {
			System.out.println("Text fied enabled");
		}
		
     		//driver.close();
				
	}
	

}
