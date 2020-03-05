package com.exadel.automation.testng;

import java.sql.Timestamp;
import java.util.Date;

import org.testng.annotations.*;

import com.exadel.automation.BaseTest;

public class TngTestTimings extends BaseTest {
	
	@BeforeMethod
	public void dumpStartTime() {
		System.out.println("Started  at: " + new Timestamp(new Date().getTime()));		
	}
	
	@AfterMethod
	public void dumpFinishTime() {
		System.out.println("Finished  at: " + new Timestamp(new Date().getTime()));		
	}
	
	@Test(timeOut = 3000) 
	public void testInsideLimits() throws InterruptedException {
		System.out.println("run testInsideLimits");
		Thread.sleep(2700);
	}

	@Test(timeOut = 7000)
	public void testOutOfLimits() throws InterruptedException {
		System.out.println("run testOutOfLimits");
		while (true) {
			Thread.sleep(1000);
			System.out.print(".");
		}
	}

}
