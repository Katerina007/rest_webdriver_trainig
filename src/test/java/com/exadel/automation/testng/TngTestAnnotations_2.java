package com.exadel.automation.testng;

import org.testng.annotations.*;

import com.exadel.automation.BaseTest;

public class TngTestAnnotations_2 extends BaseTest {

	@Test
    public void testAPI2() {
		System.out.println("--Test: testAPI2");
    }

    @Test
    public void testUI2() {
		System.out.println("--Test: testUI2");
    }

}
