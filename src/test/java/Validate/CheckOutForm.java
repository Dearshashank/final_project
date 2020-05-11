package Validate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutForm extends DriverSetup {
	String expectederror1 = "Error: First Name is required";
	String expectederror2 = "Error: Last Name is required";
	String expectederror3 = "Error: Postal Code is required";

	@Test
	public void CheckoutBox() {
		driver.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();
	}

	// if we press continue without filling form it should return an error.
	@Test
	public void Validate1() throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
		String error = driver.findElement(By.xpath("//*[@id='checkout_info_container']/div/form/h3")).getText();
		driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
		Assert.assertEquals(error, expectederror1);
		System.out.println("Validate without writting anything");
		TakeScreenShot("Screenshots\\Validate1.jpg");
		Thread.sleep(1000);
	}

	@Test
	public void Validate2() throws InterruptedException {
		driver.navigate().refresh();
		WebElement fname = driver.findElement(By.xpath("//input[@id='first-name']"));
		sendKeys(driver, fname, 10, "Shashank");
		WebElement buttonclick = driver.findElement(By.xpath("//input[@class='btn_primary cart_button']"));
		ClickOn(driver, buttonclick, 10);

		String error = driver.findElement(By.xpath("//*[@id='checkout_info_container']/div/form/h3")).getText();
		Assert.assertEquals(error, expectederror2);
		System.out.println("Validate with writting only FirstName");
		TakeScreenShot("Screenshots\\Validate2.jpg");
		Thread.sleep(1000);
	}

	@Test
	public void Validate3() throws InterruptedException {
		driver.navigate().refresh();
		WebElement fname = driver.findElement(By.xpath("//input[@id='first-name']"));

		WebElement lname = driver.findElement(By.xpath("//input[@id='last-name']"));

		sendKeys(driver, fname, 10, "Shashank");
		sendKeys(driver, lname, 10, "Parmar");
		WebElement buttonclick = driver.findElement(By.xpath("//input[@class='btn_primary cart_button']"));
		ClickOn(driver, buttonclick, 10);
		String error = driver.findElement(By.xpath("//*[@id='checkout_info_container']/div/form/h3")).getText();
		Assert.assertEquals(error, expectederror3);
		System.out.println("Validate with writting FirstName and LastName");
		TakeScreenShot("Screenshots\\Validate3.jpg");
	}
}
