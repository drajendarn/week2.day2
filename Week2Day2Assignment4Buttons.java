package week2.day02;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Week2Day2Assignment4Buttons 
{

	public static void main(String[] args)
	{
		System.setProperty("WebDriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();	
		
		//Click button to travel home page

		driver.findElement(By.id("home")).click();
		System.out.println(driver.getTitle());
		
		// Find position of button (x,y)
		driver.get("http://leafground.com/pages/Button.html");
		WebElement btnPosition=driver.findElement(By.id("position"));
		Point point = btnPosition.getLocation();
		int xcord = point.getX();
		System.out.println("Position of the webelement from left side is "+xcord +" pixels");
		int ycord = point.getY();
		System.out.println("Position of the webelement from top side is "+ycord +" pixels");
		
		//Find button color
			
		WebElement color=driver.findElement(By.id("color"));
		System.out.println("Color of the button is : "+ color.getCssValue("background-color"));
		
	         
        //Find the height and width
		    
		WebElement size=driver.findElement(By.id("size"));
		System.out.println("Size of the button is : "+ size.getSize());
	    				
	}
}

