package Validate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddOrRemoveProduct extends DriverSetup{
	
	@Test
	public void AddProduct() throws InterruptedException{
		try {
			driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]")).click();  
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='inventory_list']//div[4]//div[3]//button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='inventory_list']//div[5]//div[3]//button[1]")).click();
			
				Thread.sleep(1000);
			TakeScreenShot("Screenshots\\AddProducts.jpg");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    System.out.println("AddProduct Validated");
		}
	
	@Test(dependsOnMethods={"AddProduct"})
	public void RemoveProduct() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]")).click();
		System.out.println("RemoveProduct Validated");
		
	}	
}