package Validate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LockedOut extends DriverSetup {

	@Test
	public void LockedOut() throws InterruptedException{
		// locked_out_user
		driver=Validate.DriverSetup.getDriver();
		
		WebElement username =driver.findElement(By.xpath("//input[@id='user-name']"));

		WebElement password =driver.findElement(By.xpath("//input[@id='password']"));

		sendKeys(driver,username,5,"locked_out_user");
		sendKeys(driver,password,5,"secret_sauce");

		WebElement submit =driver.findElement(By.xpath("//input[@class='btn_action']"));

		ClickOn(driver,submit,10);
		TakeScreenShot("Screenshots\\LockedOut.jpg");
		Thread.sleep(1000);
		
		String error = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/h3")).getText();

		System.out.println("LockedOut Validated");
	}
}
