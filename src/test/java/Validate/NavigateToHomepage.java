package Validate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateToHomepage extends DriverSetup {

	@Test
	public void naviagtetohome() throws InterruptedException{
		driver.navigate().refresh();
//		Thread.sleep(3000);
//		WebElement openmenu=
				driver.findElement(By.xpath("//button[contains(text(),'Open Menu')]")).click();;
//		ClickOn(driver,openmenu,10);
//		WebElement sidebar=
				driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']")).click();
//		ClickOn(driver,sidebar,10);
		
	    String successtxt = driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		Assert.assertEquals("Products",successtxt );
		System.out.println("NavigateToHomepage Validated");	
	}
	
	@Test
	public void remove(){
		WebElement r1 =driver.findElement(By.xpath("//*[@id='inventory_container']/div/div[2]/div[3]/button"));  
		WebElement r2 =driver.findElement(By.xpath("//*[@id='inventory_container']/div/div[3]/div[3]/button"));
		WebElement r3 =driver.findElement(By.xpath("//*[@id='inventory_container']/div/div[6]/div[3]/button"));
		ClickOn(driver,r1,5);
		ClickOn(driver,r2,5);
		ClickOn(driver,r3,5);
	}
}
