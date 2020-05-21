package pages;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;



public class PageConsructor extends ProductPageElementConstants{
	protected static WebDriver driver;
	//Do mouse-hovers
	public static void MouseOver(WebElement we){
		Actions actObj=new Actions(driver);
		actObj.moveToElement(we).build().perform();
		}
	
	//Take Snapshot for analysing the failures
	public static String fn_TakeSnapshot(WebDriver driver, String DestFilePath) throws IOException{
		String TS=fn_GetTimeStamp();
		TakesScreenshot tss=(TakesScreenshot) driver;
		File srcfileObj= tss.getScreenshotAs(OutputType.FILE);
		DestFilePath=DestFilePath+TS+".png";
		File DestFileObj=new File(DestFilePath);
		FileUtils.copyFile(srcfileObj, DestFileObj);
		return DestFilePath;
		}

	//Get current Time-stamp
	public static String fn_GetTimeStamp(){
		DateFormat DF=DateFormat.getDateTimeInstance();
		Date dte=new Date(0, 0, 0);
		String DateValue=DF.format(dte);
		DateValue=DateValue.replaceAll(":", "_");
		DateValue=DateValue.replaceAll(",", "");
		return DateValue;
		}
	
	//open URL
	public static void openWebpage(String url) {
		driver.get(url);
	}
	
	
	public static void fn_Select(WebElement WE, String VisibleText){
		Select selObj=new Select(WE);
		selObj.selectByVisibleText(VisibleText);
		}
	
	//wait until Element
	public static String waitVisibility(WebDriver driver, String strLocType, String strLocValue) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,20);
    	
		switch(strLocType)
        {	
            case "id":
            	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strLocValue)));      
            	break;
            case "xpath":
            	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strLocValue)));            	
            	break;
            case "name":
            	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strLocValue)));            	 	
                break;
        }
        Thread.sleep(5000);
	
		return strLocValue;
				
		  }
	public static String scrollDown_element(String strLocType,String strLocValue) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement Element;
		switch(strLocType)
        {	
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
	
}

