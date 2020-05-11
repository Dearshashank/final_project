package Validate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebLogin extends DriverSetup{
	
	@Test
	public void Login() throws InterruptedException{
		
		driver=Validate.DriverSetup.getDriver();
		WebElement username =driver.findElement(By.xpath("//input[@id='user-name']")) ;
//				.sendKeys("standard_user");
		
		WebElement password =driver.findElement(By.xpath("//input[@id='password']")) ;
//				.sendKeys("secret_sauce");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//This function is available in driver class consist of selenium webdriver waits as well sending keys 
		sendKeys(driver,username,20,"standard_user");
		sendKeys(driver,password,20,"secret_sauce");
		
		TakeScreenShot("Screenshots\\Homelogin.jpg");
		Thread.sleep(1000);
		
		WebElement loginbutton =driver.findElement(By.xpath("//input[@class='btn_action']"));
		
		// Implementation of SeleniumWaits and click
		ClickOn(driver,loginbutton,5) ;
		
		String login = driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		Assert.assertEquals("Products",login );
		System.out.println("Login Validated");
	}
}
