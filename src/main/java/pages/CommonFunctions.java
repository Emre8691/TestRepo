package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class CommonFunctions extends PageConsructor {

	public static String navigate_to(WebDriver driver, String url) throws Exception {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		// System.setProperty("webdriver.chrome.driver",
		// "C:/Users/burak.turkpencesi/Desktop/PythonOtomasyon/Data/chromedriver.exe");
		driver.get(url);
		// Maximize the Browser window
		driver.manage().window().maximize();
		Thread.sleep(5000);
		return null;
	}

	public static String Sendkeys(WebDriver driver, String strLocType, String strLocValue, String param1)
			throws InterruptedException {
		switch (strLocType) {
		case "id":
			driver.findElement(By.id(strLocValue)).sendKeys(param1);
			break;
		case "xpath":
			driver.findElement(By.xpath(strLocValue)).sendKeys(param1);
			break;
		case "name":
			driver.findElement(By.name(strLocValue)).sendKeys(param1);
			break;
		}
		Thread.sleep(5000);
		return param1;
	}

	static public String clickButton(WebDriver driver, String strLocType, String strLocValue)
			throws InterruptedException {
		switch (strLocType) {
		case "id":
			driver.findElement(By.id(strLocValue)).click();
			break;
		case "xpath":
			driver.findElement(By.xpath(strLocValue)).click();
			break;
		case "name":
			driver.findElement(By.name(strLocValue)).click();
			break;
		}

		Thread.sleep(5000);
		return strLocValue;
	}

	static public String clear(WebDriver driver, String strLocType, String strLocValue) throws InterruptedException {
		switch (strLocType) {
		case "id":
			driver.findElement(By.id(strLocValue)).clear();
			break;
		case "xpath":
			driver.findElement(By.xpath(strLocValue)).clear();
			break;
		case "name":
			driver.findElement(By.name(strLocValue)).clear();
			break;
		}
		Thread.sleep(5000);
		return strLocValue;
	}


	static public String scroll(WebDriver driver, String strLocType, String strLocValue) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element;

		switch (strLocType) {
		case "id":
			Element = driver.findElement(By.id(strLocValue));
			js.executeScript("arguments[0].scrollIntoView();", Element);
			break;
		case "xpath":
			Element = driver.findElement(By.xpath(strLocValue));
			js.executeScript("arguments[0].scrollIntoView();", Element);
			break;
		case "name":
			Element = driver.findElement(By.name(strLocValue));
			js.executeScript("arguments[0].scrollIntoView();", Element);
			break;
		}
		Thread.sleep(5000);
		return strLocValue;
	}

	public static void quit_driver(WebDriver driver) {
		driver.quit();
	}
}
