package Dentsu_QA_Firefox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Broswer_Init {
	private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
	}
		@Test
		 public void run() {
		
		
		driver.get("https://www.youtube.com/watch?v=MrLUTu-pYz4");
		
		
	}
	
	
	

}
