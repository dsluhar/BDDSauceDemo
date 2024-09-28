package com.stepDefintion;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep2 {

	WebDriver driver;
	
	@Given("^user is already on Login Page1$")
	public void user_already_on_login_page() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@When("^title of Login Page is Free CRM1$")
	public void title_of_login_page_free_CRM()
	{
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Swag Labs", title);
	}
	@Then("user enter credentials using Data table1 and user click on Login Button1")
	public void user_enter_credentials_using_Datatable(DataTable datatable) throws InterruptedException
	{
//		List<List<String>> userList = datatable.asLists(String.class);
//		
//		for(List<String> e : userList) {
//			driver.findElement(By.name("email")).sendKeys(e.get(0));
//			driver.findElement(By.name("password")).sendKeys(e.get(1));
//		}
		
		List <Map<String, String>> userData = datatable.asMaps(String.class,String.class);
		
		for (Map<String, String> udata : userData) {
			String uName = udata.get("username");
			String uPwd = udata.get("password");
			driver.findElement(By.id("user-name")).sendKeys(uName);
			driver.findElement(By.id("password")).sendKeys(uPwd);
			driver.findElement(By.id("login-button")).click();
			Boolean Logo = (driver.findElement(By.xpath("//div[@class='app_logo' and text()='Swag Labs']")).isDisplayed());
			Assert.assertTrue(Logo);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
		}
	}
	@And("^close the browser1$")
	public void close_the_browser() {
		driver.close();
		driver.quit();
	}
}
