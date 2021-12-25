package com.AutomationTesterinterview.pageObjectModel;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HotelBookingPages {

	WebDriver ldriver;

	// Constructor
	public HotelBookingPages(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Locating all WebElements
	
	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/div")
	@CacheLookup
	List<WebElement> countryRadio;

	@FindBy(xpath = "//*[@id=\"downshift-1-input\"]")
	@CacheLookup
	WebElement searchLoc;

	@FindBy(xpath = "//*[@data-testid=\"openCheckinCalendar\"]")
	@CacheLookup
	WebElement openCalender;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/div[1]/ul[2]//span")
	@CacheLookup
	List<WebElement> CalenderTableIn;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[2]/div[1]/ul[2]//span")
	@CacheLookup
	List<WebElement> CalenderTableOut;

	@FindBy(xpath = "//*[@value=\"2 Guests in 1 Room \"]")
	@CacheLookup
	WebElement rooms;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[1]/div[3]/div[1]/div[3]")
	@CacheLookup
	WebElement noNightCount;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/h4[1]")
	@CacheLookup
	WebElement noOfRooms;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]")
	@CacheLookup
	WebElement addRoom;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")
	@CacheLookup
	WebElement removeRoom;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/h4[1]")
	@CacheLookup
	WebElement noOfAdults;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]")
	@CacheLookup
	WebElement addAdults;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]")
	@CacheLookup
	WebElement removeAdults;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/h4[1]")
	@CacheLookup
	WebElement noOfChilds;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/span[2]")
	@CacheLookup
	WebElement addChilds;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/span[1]")
	@CacheLookup
	WebElement removeChilds;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[4]")
	@CacheLookup
	WebElement FChild;

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[4]/ul[1]/li")
	@CacheLookup
	WebElement addFChilds;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement clickDoneBtn;

	@FindBy(xpath = "//button[contains(text(),'Search Hotels')]")
	@CacheLookup
	WebElement searchBtn;

	public void setcountry(String country) throws InterruptedException {
		//Radio Button Working
		for(WebElement c:countryRadio)
		{
			if(c.getText().equalsIgnoreCase(country))
			{
				c.click();
				break;
			}
		}
	}

	public void setSearchLoc(String city) throws InterruptedException {
		//City is searched
		searchLoc.sendKeys(city);
		Thread.sleep(1500);
		searchLoc.sendKeys(Keys.DOWN);
		searchLoc.sendKeys(Keys.ENTER);
	}

	public void openCalender(String inDate, String outDate) throws InterruptedException {
		//to select the required dates
		
		openCalender.click();
		Thread.sleep(1500);
		for (WebElement c : CalenderTableIn) {
			if (c.getText().equalsIgnoreCase(inDate)) {
				c.click();
				break;
			}
		}
		for (WebElement d : CalenderTableOut) {
			if (d.getText().equalsIgnoreCase(outDate)) {
				d.click();
				break;
			}
		}

	}

	public void checkNightCount(String nightCount) throws InterruptedException {
		//Verifying the night counts
		Assert.assertSame(noNightCount.getText(), nightCount);
	}

	public void setRooms(String noOfRoom, String noOfAdult, String noOfChild, String childAge)
			throws InterruptedException {
		rooms.click();
		Thread.sleep(1500);
		
		// Setting roomsCount
		while (true) {
			String room = noOfRooms.getText();
			int condition = room.compareTo(noOfRoom);
			if (condition == -1) {
				addRoom.click();
			} else if (condition == 1) {
				removeRoom.click();
			} else if (condition == 0) {
				break;
			}
		}

		// Setting AdultsCount
		while (true) {
			String adult = noOfAdults.getText();
			int condition = adult.compareTo(noOfAdult);
			if (condition == -1) {
				addAdults.click();
			} else if (condition == 1) {
				removeAdults.click();
			} else if (condition == 0) {
				break;
			}
		}

		// Setting ChildrenCount
		while (true) {

			Integer actchild = Integer.parseInt(noOfChilds.getText());
			Integer expChild = Integer.parseInt(noOfChild);

			if (actchild < expChild) {
				addChilds.click();
			} else if (actchild > expChild) {
				removeChilds.click();
			} else {
				break;
			}
		}
		for (int i = 0; i < Integer.parseInt(noOfChild); i++) {
			
			// Setting ChildAge
			ldriver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div["+(4 + i)+"]/div[1]/span[1]")).click();
			Thread.sleep(1500);
			ldriver.findElement(By.xpath("//li[text()='" + childAge + "']")).click();

		}

		clickDoneBtn.click();
		Thread.sleep(1500);
	}

	public void clickSearchBtn() throws InterruptedException {
		//Click Search button
		searchBtn.click();
	}

}
