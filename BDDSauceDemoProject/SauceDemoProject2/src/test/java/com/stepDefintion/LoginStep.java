package com.stepDefintion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

	WebDriver driver;
	
	@Given("^user is already on Login Page$")
	public void user_already_on_login_page() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@When("^title of Login Page is Free CRM$")
	public void title_of_login_page_free_CRM()
	{
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cogmento CRM", title);
	}
	@Then("user enter {string} and {string}")
	public void user_enter_username_password(String username, String password)
	{
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		
	}
	@Then("^user click on Login Button$")
	public void user_click_on_login_Buttons() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		Thread.sleep(3000);
	}
	@Then("^user is on Home Page$")
	public void user_is_on_Homp_Page()
	{
		Boolean Logo = (driver.findElement(By.xpath("//span[@class='ui header' and text()='System messages']")).isDisplayed());
		
		Assert.assertTrue(Logo);
		
//		WebElement User1 = null;
//		try {
//			User1 = driver.findElement(By.xpath("//span[@class='user-display' and text()='Dilip Luhar']"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		WebElement User2 = null;
//		try {
//			User2 = driver.findElement(By.xpath("//span[@class='user-display' and text()='Milan L']"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (User1 !=null) {
//		String LoggedUser = driver.findElement(By.xpath("//span[@class='user-display' and text()='Dilip Luhar']")).getText();
//		Assert.assertEquals("Dilip Luhar", LoggedUser);
//		}
//		else {
//			System.out.println("Dilip Luhar is User1");
//		}
//		if (User2 !=null) {
//		String LoggedUser1 = driver.findElement(By.xpath("//span[@class='user-display' and text()='Milan L']")).getText();
//		Assert.assertEquals("Milan L", LoggedUser1);
//		}
//		else {
//			System.out.println("Milan L is User2");
//		}
//		
//		System.out.println("User is on Home Page");
	}
	@And("^close the browser$")
	public void close_the_browser() {
		driver.close();
		driver.quit();
	}
}
