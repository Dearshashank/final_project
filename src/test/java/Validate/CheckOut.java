package Validate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckOut extends DriverSetup{

	
	@Test
	public void CheckOut() throws InterruptedException{
			driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();
			
			WebElement fname= driver.findElement(By.xpath("//input[@id='first-name']"));
			
			WebElement lname=driver.findElement(By.xpath("//input[@id='last-name']"));
		
			WebElement postalcode=driver.findElement(By.xpath("//input[@id='postal-code']"));
		
			sendKeys(driver,fname,10,"Shashank");
			sendKeys(driver,lname,10,"parmar");
			sendKeys(driver,postalcode,10,"453771");
			Thread.sleep(4000);
			TakeScreenShot("Screenshots\\CheckOut.jpg");

			//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			WebElement submit =driver.findElement(By.xpath("//input[@class='btn_primary cart_button']"));
			ClickOn(driver,submit,10);

			System.out.println("CheckOut Validated");
			
			WebElement cart = driver.findElement(By.xpath("//a[@class='btn_action cart_button']"));
			
			ClickOn(driver,cart,10);
			
			String Order =driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
			System.out.println(Order);
		
	}

	@Test 
	public void logout() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='menu_button_container']/div/div[3]/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='logout_sidebar_link']")).click();
		System.out.println("LogOut Validated");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.close();
	}
}
