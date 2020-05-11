package Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortingMechanism extends DriverSetup{

	@Test
	public void sort() throws InterruptedException{
		// Find the no of items which we can add to cart
		driver.navigate().refresh();
  		List<WebElement> links = driver.findElements(By.xpath("//button[contains(text(),'ADD TO CART')]"));
		int products = links.size();
		
  		String[] arr = new String[products] ;
  		// Approch to tick and save all the checked product in a Array
  		ArrayList<String> list = new ArrayList<String>();
//  		list.add("as");
  		
  		int j=0 ;
		for(int i =1 ;i<=products ;i++){	
		list.add(driver.findElement(By.xpath("//*[@id='item_"+j+"_title_link']/div")).getText());
		j++;
		}
	    ArrayList<String> newList = list;
		Collections.sort(newList);

		Assert.assertEquals(list ,newList);
		System.out.println("Verify Sorting Mechanism");	
		TakeScreenShot("Screenshots\\SortingMechanism.jpg");
		Thread.sleep(1000);
	}
	@Test(dependsOnMethods={"sort"})
	public void CloseDriver(){
		driver.close();
	}
}
