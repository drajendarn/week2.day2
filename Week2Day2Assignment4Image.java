package week2.day02;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Week2Day2Assignment4Image 
{

	public static void main(String[] args)
	{
		System.setProperty("WebDriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		
		
		//Go to Home Page
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		
		// Am I Broken Image?
		driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).isEnabled();
		
		//Click me using Keyboard or Mouse
		WebElement img= driver.findElement(By.xpath("//img[@src='../images/keyboard.png']"));
		Actions builder=new Actions(driver);
		Actions seriesOfAction= builder.moveToElement(img).click();
		seriesOfAction.perform();
		System.out.println("Click Successful using Keyboard" + driver.getTitle());		
	}
}

