package test.tools.webapp.automation.Smoke;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;

import utils.ExtentReports.ExtentTestManager;

public class DigiTest extends TestBase {
	
	@BeforeClass
	public void Browserchoose() throws Exception {
		// This will launch browser and specific url
		initialization();
		// Created Page Object using Page Factory
		Thread.sleep(3000);
	}

	@Test(priority = 0, description = "Digi Scenario.")
	public void DigiTestAdd(Method method) throws InterruptedException {
		ExtentTestManager.startTest(method.getName(), "Digi Scenario subscribe.");

		waitVisibility(driver, "xpath", Subscribe);
		clickButton(driver, "xpath", Subscribe);

		waitVisibility(driver, "xpath", OneMonth);
		clickButton(driver, "xpath", OneMonth);

		scroll(driver, "xpath", ValidateSubscribe);
		waitVisibility(driver, "xpath", ValidateSubscribe);
		clickButton(driver, "xpath", ValidateSubscribe);

		waitVisibility(driver, "xpath", Nametxt);
		Sendkeys(driver, "xpath", Nametxt, "Emre");
		Sendkeys(driver, "xpath", LastNametxt, "Diker");
		Sendkeys(driver, "xpath", Emailtxt, "melos13517@aprimail.com");
		Sendkeys(driver, "xpath", Passwordtxt, "Admin8691");
		scroll(driver, "xpath", tick);
		clickButton(driver, "xpath", tick);
		clickButton(driver, "xpath", CreateAccount);

		waitVisibility(driver, "id", x);
		clickButton(driver, "id", x);
		clickButton(driver, "xpath", PayTick);
		clickButton(driver, "xpath", PayNow);

		waitVisibility(driver, "id", CardName);
		Sendkeys(driver, "id", CardName, "Emre");
		Sendkeys(driver, "id", CardNumber, "1234567898763456");

		Select selectMonth = new Select(driver.findElement(By.id(CardMonthButton)));
		selectMonth.selectByVisibleText("01");

		Select selectYear = new Select(driver.findElement(By.id(CardYearButton)));
		selectYear.selectByVisibleText("2021");

		Sendkeys(driver, "id", CardVerification, "3456");
		clickButton(driver, "id", CardSubmit);

		Thread.sleep(3000);
	}
}
