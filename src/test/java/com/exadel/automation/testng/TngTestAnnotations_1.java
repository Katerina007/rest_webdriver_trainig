package com.exadel.automation.testng;

import org.testng.annotations.*;

import com.exadel.automation.BaseTest;

public class TngTestAnnotations_1 extends BaseTest {

	@BeforeGroups("api")
	public void beforeGroups() {
		System.out.println("@BeforeGroups");
	}

	@AfterGroups("api")
	public void afterGroups() {
		System.out.println("@AfterGroups");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
	}
	
	@Test(groups = {"api"})
    public void testAPI() {
		System.out.println("--Test: testAPI");
    }

    @Test(groups = {"ui"})
    public void testUI() {
		System.out.println("--Test: testUI");
    }

    @Test()
    public void testUnit() {
		System.out.println("--Test: testUnit");
    }
}
