package com.exadel.automation.testng;

import org.testng.annotations.*;

import com.exadel.automation.BaseTest;

public class TngTestParameters extends BaseTest {
	
	@DataProvider(name = "Users")
	public static Object[][] users() { 
		return new Object[][] {{"Alex"},  //, Arrays.asList(1,2,3)
								{"Garry"}, 
								{"Bill"}, 
								{"Mark"}}; 
	} 
	
	@Test
	@Parameters({"UserName", "Password"})
	public void testLoginWithCredentials(@Optional("default-user") String user, @Optional("default-password") String password) {
		System.out.println("run testLoginWithCredentials: " + user +"/"+ password);
	}

	@Test(dataProvider="Users")
	@Parameters({"User"})
	public void testUsersList(@Optional("default-user") String user) {
		System.out.println("run testUsersList: " + user + ": ");  // + numbers);
	}
}
