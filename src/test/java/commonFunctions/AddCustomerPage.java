package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage {
	WebDriver driver;

//constructor for invoking webdriver methods
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

//define Repository for add customer
	@FindBy(xpath = "(//a[contains(text(),'Customers')])[2]")
	WebElement ObjClickCustomerLink;
	@FindBy(xpath = "(//span[@data-caption='Add'])[1]")
	WebElement ObjClickAddIcon;
	@FindBy(name = "x_Customer_Number")
	WebElement ObjCustomerNumber;
	@FindBy(name = "x_Customer_Name")
	WebElement ObjCustomerName;
	@FindBy(name = "x_Address")
	WebElement ObjAddress;
	@FindBy(name = "x_City")
	WebElement ObjCity;
	@FindBy(name = "x_Country")
	WebElement ObjCountry;
	@FindBy(name = "x_Contact_Person")
	WebElement ObjContactPerson;
	@FindBy(name = "x_Phone_Number")
	WebElement ObjPhoneNumber;
	@FindBy(name = "x__Email")
	WebElement ObjEmail;
	@FindBy(name = "x_Mobile_Number")
	WebElement ObjMobileNumber;
	@FindBy(name = "x_Notes")
	WebElement ObjNotes;
	@FindBy(id = "btnAction")
	WebElement ObjAddButton;
	@FindBy(xpath = "//button[normalize-space()='OK!']")
	WebElement ObjClickConfirmOk;
	@FindBy(xpath = "(//button[starts-with(text(),'OK')])[6]")
	WebElement ObjClickAlertOk;
	@FindBy(xpath = "//span[@data-caption='Search']")
	WebElement ObjSearchPanel;
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement ObjSearchTextbox;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjSearchButton;
	@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement customerTable;

//method for add customer
	public boolean addCustomer(String Cname, String Address, String city, String Country, String cPerson,
			String pNumber, String Emial, String Mnumber, String Notes) throws Throwable {
		Actions ac = new Actions(driver);
		ac.moveToElement(this.ObjClickCustomerLink).click().perform();
		ac.moveToElement(this.ObjClickAddIcon).click().perform();
		// capture cnumber
		String Exp_Data = this.ObjCustomerNumber.getAttribute("value");
		this.ObjCustomerName.sendKeys(Cname);
		this.ObjAddress.sendKeys(Address);
		this.ObjCity.sendKeys(city);
		this.ObjCountry.sendKeys(Country);
		this.ObjContactPerson.sendKeys(cPerson);
		this.ObjPhoneNumber.sendKeys(pNumber);
		this.ObjEmail.sendKeys(Emial);
		this.ObjMobileNumber.sendKeys(Mnumber);
		this.ObjNotes.sendKeys(Notes);
		ac.moveToElement(this.ObjAddButton).click().perform();
		this.ObjClickConfirmOk.click();
		Thread.sleep(2000);
		this.ObjClickAlertOk.click();
		Thread.sleep(2000);
		if (!this.ObjSearchTextbox.isDisplayed())
			this.ObjSearchPanel.click();
		this.ObjSearchTextbox.clear();
		this.ObjSearchTextbox.sendKeys(Exp_Data);
		this.ObjSearchButton.click();
		Thread.sleep(2000);
		String Act_Data = this.customerTable.getText();
		if (Act_Data.equals(Exp_Data)) {
			Reporter.log(Act_Data + "       " + Exp_Data + "   " + "Customer Number Matching", true);
			return true;
		} else {
			Reporter.log(Act_Data + "       " + Exp_Data + "   " + "Customer Number is Not Matching", true);
			return false;
		}

	}

}
