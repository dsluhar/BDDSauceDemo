package com.myRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = ".\\features\\Login2.feature", glue = {"com.stepDefintion"}, tags = "@Tag2")

public class testRunner extends AbstractTestNGCucumberTests {

	@BeforeClass
	public static void setup() {
		System.out.println("Ran the before");
	}

	@AfterClass
	public static void teardown() {
		System.out.println("Ran the after");
	}

}
