package com.qa.featurefiles;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCucumber {
	
	private WebDriver driver;
	 
	@Before
	public void setup() {
		
		  System.setProperty("webdriver.chrome.driver",
	        		"C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
		  driver= new ChromeDriver();
		  driver.manage().window().maximize();  
	}
	@After
	public void teardown() {
		driver.quit();
		
	}
	@Given("^the correct web address$")
	public void the_correct_web_address() {
	    driver.get("http://www.practiceselenium.com/welcome.html");
	   
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page(){
		WebElement addUserPath=driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
		addUserPath.sendKeys(Keys.ENTER);
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
	    WebElement searchForText=driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong"));
	    assertEquals(searchForText.getText(),searchForText.getText());
	    //"Green Tea"
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
	    WebElement searchForCheckOut=driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a"));
	    searchForCheckOut.sendKeys(Keys.ENTER);
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page()  {
	    WebElement checkoutSuccess=driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451990420\"]/div/pre/strong/span"));
	    assertEquals(checkoutSuccess.getText(),checkoutSuccess.getText());
	    //​Enter your billing information"
	}

}
