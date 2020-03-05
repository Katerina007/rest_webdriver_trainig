package com.exadel.automation.testng;

import org.testng.annotations.*;

import com.exadel.automation.BaseTest;

public class TngTestGroups extends BaseTest {

	@BeforeGroups("db")
	public void setupDB() {
		System.out.println("Load DB dump");
	}
	
	@AfterGroups("db")
	public void cleanDB() {
		System.out.println("Clean up DB");
	}
	
	@Test(groups= "rest")
	public void testRest1() {
		System.out.println("run TestRest1()");
	}

	@Test(groups= "rest")
	public void testRest2() {
		System.out.println("run TestRest2()");
	}
	
	@Test(groups = "db")
	public void testDBConnection() {
		System.out.println("run testDBConnection()");
	}

	@Test(groups = "db")
	public void testDataConsistency() {
		System.out.println("run testDataConsistency()");
		// What's happen in case an exception will be thrown here?
	}
	
	@Test(dependsOnGroups = {"db","rest"})
	public void testE2E() {
		System.out.println("run testE2E()");
	}

}
