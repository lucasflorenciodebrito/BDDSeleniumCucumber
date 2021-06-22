package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {
	public SearchCustomerPage searchCustomer;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
	    System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
		lp = new LoginPage(driver);
		
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		
		lp.setUserName(email);
		lp.setPassword(password);
	    
	}


	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
	    lp.clickLogin();
	    Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	   if(driver.getPageSource().contains("Login was unsucessful.")) {
		   driver.close();
		   Assert.assertTrue(false);
	   } else {
		  Assert.assertEquals(title, driver.getTitle()); 
	   }
		
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
	  lp.clickLogout();
	  Thread.sleep(3000);
	  
	}

	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	     addCust = new AddCustomerPage(driver);
	     Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	     
	    
	}

	@When("User click on costumers Menu")
	public void user_click_on_costumers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	}

	@When("click on costumers Menu Item")
	public void click_on_costumers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
	    addCust.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
	    addCust.clickOnAddnew();
	}

		
	@Then("User can view Add new costumer page")
	public void user_can_view_add_new_costumer_page() {
	     
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());

	}
	
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = "testemail9@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("Test123");
		addCust.setFirstName("Lucas");
		addCust.setGender("Male");
		addCust.setLastName("Brito");
		addCust.setDob("10/11/1993");
		addCust.setCompanyName("My Company");
		addCust.setAdminContent("Testing...");
		//addCust.setManagerOfVendor("Vendor 2");
		//addCust.setCustomerRoles("Guest");
		Thread.sleep(3000);
		
		
	}
	
	@Then("click on Save button")
	public void click_on_save_button() throws InterruptedException {
	    addCust.clickOnSave();
	    Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("successfully"));
	}
	
	@When("Enter customer Email")
	public void enter_customer_email() {
		searchCustomer = new SearchCustomerPage(driver);
		searchCustomer.setEmail("victoria_victoria@nopCommerce.com");
	    
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCustomer.clickSearch();
		Thread.sleep(3000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status = searchCustomer.searchCustomerByEmail("victoria_victoria@nopCommerce.com"); 
		Assert.assertEquals(true, status);
	}
}
