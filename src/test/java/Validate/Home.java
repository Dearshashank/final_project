package Validate;

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Home extends DriverSetup{
//	public static WebDriver driver=Validate.DriverSetup.getDriver();
	@Test
	public void Header(){
		String successtxt = driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		Assert.assertEquals("Products",successtxt );
		System.out.println("Header validated");	
	}
	
	@Test
	public void footer() throws InterruptedException{
		String getfooter = driver.findElement(By.xpath("//div[@class='footer_copy']")).getText();
		String footer ="© 2019 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		Assert.assertEquals(footer,getfooter );
		System.out.println("Footer validated");
		Thread.sleep(1000);
	}
	
	@Test(dependsOnMethods={"Header"})
	public void Hamburger() throws InterruptedException{
		driver.findElement(By.xpath("//button[contains(text(),'Open Menu')]")).click();
		String hamleft=driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']")).getText();
		Assert.assertEquals("All Items",hamleft );
		System.out.println("Hamburger Left Validated");
		WebElement hamburger =driver.findElement(By.xpath("//button[contains(text(),'Close Menu')]"));
		ClickOn(driver,hamburger,5);
		Thread.sleep(1000);
		TakeScreenShot("D:\\Selenium Project\\SaucedemoValidation\\Screenshots\\HomePage.jpg");

	}
}