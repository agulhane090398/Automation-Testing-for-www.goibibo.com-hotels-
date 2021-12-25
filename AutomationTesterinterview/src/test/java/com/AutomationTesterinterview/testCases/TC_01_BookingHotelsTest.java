package com.AutomationTesterinterview.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.AutomationTesterinterview.pageObjectModel.HotelBookingPages;

public class TC_01_BookingHotelsTest extends BaseClass {
	@Test
	public void booking() throws IOException, InterruptedException {
		try {
			//Step by step all fields are filled by required data
			
			HotelBookingPages h = new HotelBookingPages(driver);
			h.setcountry(country);
			logger.info("Country is selected");

			h.setSearchLoc(city);
			logger.info("City is Enetered");

			h.openCalender(inDate, outDate);
			logger.info("Date is Entered");

			h.checkNightCount(nightCount);
			logger.info("Night Cout verified");

			h.setRooms(noOfRoom, noOfAdult, noOfChild, childAge);
			logger.info("Room allocation done");

			h.clickSearchBtn();
			logger.info("Search button is clicked");

			if (driver.getTitle().equals("Results")) //Use  "Results 123" instead to see working of captureScreen() Method
			{
				Assert.assertTrue(true);
				logger.info("Login Test Passed!");
			} else {
				captureScreen(driver, "loginTest");
				Assert.assertTrue(false);
				logger.info("Login Test Failed!");
			}
		} 
		catch (Exception e) {
			// Screenshot will be taken if any Exception is caught
			
			captureScreen(driver, "TC_01_BookingHotelsTest");
		}
	}
}
