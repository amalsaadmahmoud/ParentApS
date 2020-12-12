package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;
import Utils.Helper;

public class Events extends PageBase {

	WebDriverWait wait = new WebDriverWait(driver, 50);
	private static By email = By.id("txtEmail");
	private static By password = By.id("txtPassword");
	private static By loginBtn = By.id("submitBtn");
	private static By kidsPlalace = By.xpath("(.//div[@class='data-cell title-cell list__item-row'])[1]");
	private static By calender = By.id("calendarTab");
	private static By createEventBtn = By.id("createEventBtn");
	private static By eventTitle = By.id("eventTitle");
	private static By RecipientsComboBox = By.id("Recipients");
	private static By startDatepicker = By.xpath("(//div[@class='p-relative input_form clickable'])[1]");
	private static By submitCreateEventBtn = By.id("submitCreateEventBtn");

	public void login() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) email));
		driver.findElement(email).sendKeys("demo@parent.eu");
		driver.findElement(password).sendKeys("12345678");
		driver.findElement(loginBtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/app-main-layout/main/app-institution/div/div[2]/div/div[2]/div[1]/div[5]/span")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(kidsPlalace));
		driver.findElement(kidsPlalace).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(calender));
		driver.findElement(calender).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(createEventBtn));
		driver.findElement(createEventBtn).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(eventTitle));
		driver.findElement(eventTitle).sendKeys("ChrismasEvent");

		wait.until(ExpectedConditions.visibilityOfElementLocated(RecipientsComboBox));
		Helper.SelectComboValues(driver, RecipientsComboBox);

		wait.until(ExpectedConditions.visibilityOfElementLocated(startDatepicker));
		driver.findElement(startDatepicker).click();

		String currentDay = Helper.getCurrentDay();

		// To pick the start date
		By currentDaySpan = By.xpath("//span[text()='" + currentDay + "'and not(@class)]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(currentDaySpan));
		driver.findElement(currentDaySpan).click();

		// Start hour
		By fromBtn = By.id("timepickerStartTime timepickerStartTime");
		wait.until(ExpectedConditions.visibilityOfElementLocated(fromBtn));
		driver.findElement(fromBtn).click();

		// start hour value
		By HourUpArrow = By.xpath("(.//span[@class='timeslots-list-wrapper__item'])[1]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(HourUpArrow));
		driver.findElement(HourUpArrow).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(submitCreateEventBtn));
		driver.findElement(submitCreateEventBtn).click();

	}

	public String getCurrentURLTest() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}

	public boolean isElementDisplayed() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(createEventBtn));
		boolean isElementPresent = driver.findElement(createEventBtn).isDisplayed();
		return isElementPresent;
	}

}
