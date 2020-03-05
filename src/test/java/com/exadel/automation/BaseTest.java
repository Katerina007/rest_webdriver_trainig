package com.exadel.automation;

import org.testng.annotations.*;

//import com.exadel.automation.listeners.ApiAllureListener;

/**
 * Base class for TestNG-based test classes
 */
// @Listeners({ApiAllureListener.class})
public class BaseTest {

	@BeforeSuite
    public void initTestSuite() {
		System.out.println("@@BeforeSuite");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownTestSuite() {
		System.out.println("@@AfterSuite");
    }

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
	}

	@AfterTest
	public void afterTests() {
		System.out.println("@AfterTest");
	}	   
}
