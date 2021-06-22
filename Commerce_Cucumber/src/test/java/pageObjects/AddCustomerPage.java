package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	By lnkCustomers_menu = By.xpath("//nav/ul/li[4]/a/p");
	By lnkCustomers_menuitem = By.xpath("//li[4]/ul/li/a/p");
	
	By btnAddnew = By.xpath("//a[@class = 'btn btn-primary']");
	
	By txtEmail= By.xpath("//input[@id = 'Email']");
	By txtPassword = By.xpath("//input[@id = 'Password']");
	
	By txtCustomerRoles = By.xpath("//div[@class= 'k-widget k-multiselect k-multiselect-clearable']");
	
	By lstitemAdministrators = By.xpath("//li[contains(text(), 'Administrators')]");
	By lstitemRegistrered = By.xpath("//li[contains(text(), 'Registered')]");
	By lstitemGuests = By.xpath("//li[contains(text(), 'Guests')]");
	By lstimemVendors = By.xpath("//li[contains(text(), 'Vendors')]");
	
	By drpmgrOfVendor = By.xpath("//*[@id = 'Company']");
	By rdMaleGender = By.id("Gender_Male");
	By rdFemaleGender = By.id("Gender_Female");
	
	By txtFirstName = By.xpath("//input[@id = 'FirstName']");
	By txtLastName = By.xpath("//input[@id = 'LastName']");
	
	By txtDob = By.xpath("//input[@id = 'DateOfBirth']");
	
	By txtCompanyName = By.xpath("//input[@id = 'Company']");
	
	By txtAdminContent = By.xpath("//textarea[@id = 'AdminComment']");
	
	By btnSave = By.xpath("//button[@name = 'save']");
	
	//Actions Methods
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException {
		ldriver.findElement(txtCustomerRoles).click();
		WebElement listitem;
		Thread.sleep(3000);
		
		if(role.equals("Administrators")) {
			listitem = ldriver.findElement(lstitemAdministrators);
		}
		
		else if(role.equals("Guests")) {
			listitem = ldriver.findElement(lstitemGuests);
		}
		
		else if(role.equals("Registered")) {
			listitem = ldriver.findElement(lstitemRegistrered);
			
		}
		
		else if(role.equals("Vendors")) {
			listitem = ldriver.findElement(lstimemVendors);
			
		}
		
		else {
			
			listitem = ldriver.findElement(lstitemGuests);
		}
		
		listitem.click();
			
		
	}
	
	public void setManagerOfVendor(String value) {
		Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
		drp.deselectByVisibleText(value);
		
	}
	
		
	public void setGender (String gender) {
		
		if(gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();
		}
		
		else if(gender.equals("Female")) {
			ldriver.findElement(rdFemaleGender).click();
		}
		
		else {
			ldriver.findElement(rdMaleGender).click(); //Default
		}
	}
	
	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setDob (String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyName(String comname) {
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}
	
	public void clickOnSave() {
		
		ldriver.findElement(btnSave).click();
	}

	public void setAdminContent(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
		
	}
	
	

}
