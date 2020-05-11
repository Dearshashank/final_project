package Validate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Add3Remove1 extends DriverSetup{
	List<WebElement> ItemSelected ;
	int selected ;
	@Test
	public void Navigate(){
		driver.navigate().back();
	}
	@Test(dependsOnMethods={"Navigate"})
	public void Add3Product(){
		try {
		driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]")).click();  
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='inventory_list']//div[4]//div[3]//button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='inventory_list']//div[5]//div[3]//button[1]")).click();
		
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> list = driver.findElements(By.xpath("//button[contains(text(),'REMOVE')]"));
		
		selected = list.size();
		System.out.println(selected+" Add3Product Validated");
	}
	
	@Test(dependsOnMethods={"Add3Product"})
	public void remove1() throws InterruptedException{
		driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]")).click();
		List<WebElement> list2 = driver.findElements(By.xpath("//button[contains(text(),'REMOVE')]")); 
		int remove =list2.size();
		
		Thread.sleep(1000);
		//System.out.println(selected+" "+remove);
		Assert.assertEquals(selected ,remove );
		
		System.out.println("Remove1 Validated");
	}
}
