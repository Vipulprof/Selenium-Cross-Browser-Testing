package baselibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baselibrary 
{
	WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void geturl(String browser)
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
		WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
		driver.manage().window().maximize();
		break;
		
		case "edge":
		WebDriverManager.edgedriver().setup();
	    driver= new EdgeDriver();
		driver.manage().window().maximize();
		break;
		
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
		    driver= new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		
		default:
			driver = null;
			break;
		}
	}
	@Test
	public void verifytitle()
	{
		driver.get("https://master.d3u2qbic13a7jo.amplifyapp.com/home");
		String expectedtitle="Marketplace - Referrizer";
		String actualtitle= driver.getTitle();
		
		Assert.assertEquals(expectedtitle,expectedtitle);
	}
	@AfterMethod
	public void quittt()
	{
		driver.quit();
	}

}
