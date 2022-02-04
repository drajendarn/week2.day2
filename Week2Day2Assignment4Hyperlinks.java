package week2.day02;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Week2Day2Assignment4Hyperlinks 
{

	public static void main(String[] args)
	{
		System.setProperty("WebDriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();	
		
		//Go to Home Page
		driver.findElement(By.xpath("//a[contains(text(),'Go to Home Page')]")).click();
		System.out.println(driver.getTitle());
		
		// Find where am supposed to go without clicking me?
		driver.get("http://leafground.com/pages/Link.html");
		WebElement linkUrl=driver.findElement(By.xpath("//a[contains(text(),'Find where am supposed to go without clicking me?')]"));
		String lUrl=linkUrl.getAttribute("href");
		System.out.println(lUrl);
		
		//broken URL
		driver.get("http://leafground.com/pages/Link.html");
		WebElement brokenUrl=driver.findElement(By.xpath("//a[contains(text(),'Verify am I broken?')]"));
		String bUrl=brokenUrl.getAttribute("href");
		System.out.println(bUrl);
		brokenUrl.click();
		driver.getTitle();		
		if(bUrl.contains("error"))
				{
		System.out.println("URL is broken");
				}
		else
			System.out.println("URL is not broken");
	         
        // Go to Home Page (Interact with same link name)
		
	     driver.get("http://leafground.com/pages/Link.html");
	     driver.findElement(By.xpath("//a[contains(text(),'Go to Home Page')]")).click();
	     driver.navigate().to("http://leafground.com/pages/Link.html");
	     driver.findElement(By.xpath("//a[contains(text(),'Go to Home Page')]"));
	     System.out.println("Navigated Back to this page again " + driver.getTitle());
	     // Number of Links in this page
	   
	     List<WebElement> links =driver.findElements(By.tagName("a"));
	     int linkCount = links.size();   
	     System.out.println("Number of Links in this page is:"+ linkCount);
	     driver.close();
				
	}
}

