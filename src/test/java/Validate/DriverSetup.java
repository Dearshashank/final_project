package Validate;

import org.openqa.selenium.firefox.FirefoxBinary;   
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	public static WebDriver driver;
	public static String baseUrl = "https://www.saucedemo.com/";
    
	public  static WebDriver getDriver() {
		String UptoProject = System.getProperty("user.dir");   // Upto the project path
		String Completepath= UptoProject + "\\BrowserDrivers\\geckodriver.exe";   // upto the driver exe file
		System.setProperty("webdriver.gecko.driver",Completepath); 
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		return driver;
	}
	public static void sendKeys(WebDriver driver,WebElement element, int timeout, String value){
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	public static void ClickOn(WebDriver driver,WebElement element, int timeout){
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public static void TakeScreenShot(String Filename){
		
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File(Filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

