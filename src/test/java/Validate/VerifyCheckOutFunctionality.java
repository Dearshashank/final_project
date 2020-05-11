package Validate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyCheckOutFunctionality extends DriverSetup{

	
      @Test
      public void selectproduct() throws InterruptedException{
    	  
    	driver.navigate().refresh();
    	driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
  		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
  		driver.findElement(By.xpath("//input[@class='btn_action']")).click();
  		
  		// Find the no of items which we can add to cart
  		List<WebElement> links = driver.findElements(By.xpath("//button[contains(text(),'ADD TO CART')]"));
		int products = links.size();
		
  		String[] arr = new String[6] ;
  					// Approch to tick and save all the checked product in a Array
  		int j=0 ;
		for(int i =1 ;i<=products ;i++){	
		driver.findElement(By.xpath("//div[@class='inventory_list']//div["+i+"]//div[3]//button[1]")).click();
		arr[j] = driver.findElement(By.xpath("//*[@id='item_"+j+"_title_link']/div")).getText();
		j++;
		}
		
		TakeScreenShot("Screenshots\\SelectProduct.jpg");
		Thread.sleep(1000);
		// click to send to cart
		driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]")).click();
		//*[@id='item_'0'_title_link']/div
		//*[@id="item_0_title_link"]/div
		
		
		
				// validate that the selected item is equals to the item in the cart or not
		int productcount=0 ;
		for(int k =0 ;k<=5 ;k++){
			String pname =driver.findElement(By.xpath("//*[@id='item_"+k+"_title_link']/div")).getText();
			//System.out.println(pname+"####"+arr[k]);
			if(arr[k].equalsIgnoreCase(pname)){
				productcount++ ;
			}
		}
		TakeScreenShot("Screenshots\\CartProduct.jpg");
		Thread.sleep(1000);
		//System.out.println(productcount) ;
		Assert.assertEquals(productcount ,products);
		System.out.println("Verify Check Out Functionality validated");
      }
}
