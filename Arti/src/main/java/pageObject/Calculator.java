package pageObject;

import java.io.IOException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

public class Calculator {
	WebDriver driver;

	public Calculator(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='borrow__error__text'])")
	public WebElement borrow_error;
	@FindBy(xpath = "//input[@id='application_type_single']")
	public WebElement application_type_single;
	
	@FindBy(xpath = "//input[@id='application_type_joint']")
	public WebElement application_type_joint;
	@FindBy(xpath = "//ul[@class=\"borrow__question__answer clearfix\"]//following-sibling::input[@id=\"borrow_type_home\"]")
	public WebElement property_home_to_live_in;
	
	@FindBy(xpath = "//ul[@class='borrow__question__answer clearfix']//following-sibling::input[@id='borrow_type_investment']")
	public WebElement property_commercial;
	@FindBy(xpath = "//span[@id=\"q2q1i1\"]//following-sibling::input[@value=0]")
	public WebElement annual_income;

	
	@FindBy(xpath = "//span[@id=\"q2q2i1\"]//following-sibling::input[@value=0]")
	public WebElement other_income;
	@FindBy(xpath = "//input[@id=\"expenses\"]")
	public WebElement monthly_expenses;
	@FindBy(xpath = "//input[@id=\"homeloans\"]")
	public WebElement homeloan_repayments;
	@FindBy(xpath = "//input[@id=\"otherloans\"]")
	public WebElement other_loan_repayments;
	@FindBy(xpath = "//span[@id=\"q3q4i1\"]//following-sibling::input")
	public WebElement other_monthly_commitments;
	@FindBy(xpath = "//input[@id=\"credit\"]")
	public WebElement creditcard_limit;
	
	public WebElement getApplication_type_single() {
		return application_type_single;
	}
	public WebElement getApplication_type_joint() {
		return application_type_joint;
	}

	public WebElement getProperty_home_to_live_in() {
		return property_home_to_live_in;
	}
	public WebElement getProperty_commercial() {
		return property_commercial;
	}

	public WebElement getAnnual_income() {
		return annual_income;
	}

	public WebElement getOther_income() {
		return other_income;
	}

	public WebElement getMonthly_expenses() {
		return monthly_expenses;
	}

	public WebElement getHomeloan_repayments() {
		return homeloan_repayments;
	}

	public WebElement getOther_loan_repayments() {
		return other_loan_repayments;
	}

	public WebElement getOther_monthly_commitments() {
		return other_monthly_commitments;
	}

	public WebElement getCreditcard_limit() {
		return creditcard_limit;
	}

	public WebElement getStart_over() {
		return start_over;
	}

	public WebElement getWork_out_how_much_could_be_borrowed() {
		return work_out_how_much_could_be_borrowed;
	}

	public WebElement dependent() {
		return dependent;
	}


	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getBorrow_error() {
		return borrow_error;
	}
	public String getDefaultdependant() {
		Select select = new Select(dependent);
		WebElement option = select. getFirstSelectedOption();
		return  option. getText();
	}
	
	public WebElement getDependent() {
		return dependent;
	}

	@FindBy(xpath = "//span[@aria-live=\"assertive\"]//span[@id=\"borrowResultTextAmount\"]")
	public WebElement estimate;
	@FindBy(xpath = "//span[@id=\"borrowResultTextAmount\"]")
	public WebElement estimateDefault;
	public String getDefaultEstimate()
	{
		return estimateDefault.getText();
	}
	@FindBy(xpath = "//div[@class=\"borrow__error__text\"]//ancestor::div[@style=\"display: none;\"]")
	public WebElement eligibilityError;
	
	
	
	@FindBy(xpath = "//button[@class=\"start-over\"]")
	public WebElement start_over;

	@FindBy(xpath = "//button[@id=\"btnBorrowCalculater\"]")
	public WebElement work_out_how_much_could_be_borrowed;

	public String getEstimate() {
		return estimate.getText();
	}

	@FindBy(xpath = "//div[@class=\"borrow__question__answer borrow__question__answer--select\"]//select")
	public WebElement dependent;

	public void clickOnApplicationTypeSingle() {
		application_type_single.click();
	}
	public void clickOnApplicationTypeJoint() {
		application_type_joint.click();
	}

	public void clickOnHomeProperty() {
		property_home_to_live_in.click();
	}
	public void clickOnCommercialProperty() {
		property_commercial.click();
	}

	public void clickOnStartOver() {
		start_over.click();
	}
	public String title()
	{
		return driver.getTitle();
	}

	public void selectNumberofDependents(int number) {
		Select no_of_dependants = new Select(dependent);
		no_of_dependants.selectByIndex(number);
	}

	public void scroll_down() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	public void scroll_up() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_UP).build().perform();
	}

	public void enterOtherLoanRepayment(String number) {
		other_loan_repayments.sendKeys(number);
	}

	public void enterAnnualIncome(String number) {
		annual_income.sendKeys(number);
	}

	public void enterOtherIncome(String number) {
		other_income.sendKeys(number);
	}

	public void enterMonthlyExpense(String number) {
		monthly_expenses.sendKeys(number);
	}

	public void enterHomeLoanRepayments(String number) {
		homeloan_repayments.sendKeys(number);
	}

	public void enterOtherMonthlyCommitments(String number) {
		other_monthly_commitments.sendKeys(number);
	}

	public void enterCreditCardLimit(String number) {
		creditcard_limit.sendKeys(number);
	}

	public void clickOnHowMuchCouldBeBorrowed() {
		work_out_how_much_could_be_borrowed.click();
	}
}
