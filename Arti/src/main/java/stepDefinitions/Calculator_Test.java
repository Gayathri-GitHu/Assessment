package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObject.Calculator;

public class Calculator_Test extends BaseClass {

	WebDriver driver;
	static Calculator c;

	public Calculator_Test() throws IOException {

		BaseClass.initialization();
		c = new Calculator(BaseClass.driver);
	}

	@Given("Launch the application")
	public void launch_the_application() throws IOException {

		Assert.assertTrue(c.title().equals("Home loan borrowing power calculator | ANZ"),
				"Applications is not as expected");
	}

	@Then("Enter data into the fields and validate the eligibility")
	public void enter_data_into_the_fieldsandvalidatetheeligibility(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> detailmap = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> e : detailmap) {
			if (e.get("applicationType").equals("Single")) {
				c.clickOnApplicationTypeSingle();
			} else {
				c.clickOnApplicationTypeJoint();
			}
			c.scroll_down();
			c.selectNumberofDependents(Integer.parseInt(e.get("numberofDependant")));
			if (e.get("propertytoBuy").equals("home")) {
				c.clickOnHomeProperty();
			} else {
				c.clickOnCommercialProperty();
			}
			c.scroll_up();
			c.enterAnnualIncome(e.get("annualIncome"));
			c.scroll_down();
			c.enterOtherIncome(e.get("otherIncome"));
			c.enterMonthlyExpense(e.get("livingExpense"));
			c.enterHomeLoanRepayments(e.get("homeLoanRepayment"));
			c.enterOtherLoanRepayment(e.get("otherRepayment"));
			c.enterOtherMonthlyCommitments(e.get("commitment"));
			c.enterCreditCardLimit(e.get("creditCardLimit"));
			c.scroll_down();
			c.clickOnHowMuchCouldBeBorrowed();
			c.scroll_down();
			/*
			 * if(!c.eligibilityError.isDisplayed()) {Assert.assertEquals(c.getEstimate(),
			 * "$" + e.get("eligibility"), "Value is not Matching"); }
			 * 
			 * else {
			 */
			Assert.assertEquals(c.getBorrow_error().getText().contains(
					"Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on "),
					true, "Error message is not as expected");

		}
	}

	@Then("Click on Start over button")
	public void click_on_start_over_button() throws InterruptedException {
		Thread.sleep(10000);
		c.clickOnStartOver();

	}

	@Then("Validate all the fields are empty")
	public void validate_all_the_fields_are_empty() {
		Assert.assertTrue(c.getApplication_type_single().isSelected(), "Not selected");
		Assert.assertEquals(c.getDefaultdependant(), "0", "Not Default value");
		Assert.assertEquals(c.getProperty_home_to_live_in().isSelected(), true,
				"Home To live is not selected as Default");
		Assert.assertEquals(c.getAnnual_income().getText(), "", "Annual Income is not blank by default");
		Assert.assertEquals(c.getOther_income().getText(), "", "Other Income is not blank by default");
		Assert.assertEquals(c.getMonthly_expenses().getText(), "", "monthly Expense is not blank by default");
		Assert.assertEquals(c.getHomeloan_repayments().getText(), "", "Homeloan repayment is not blank by default");
		Assert.assertEquals(c.getOther_loan_repayments().getText(), "", "Other Loan Repayment is not blank by default");
		Assert.assertEquals(c.getOther_monthly_commitments().getText(), "", "Commitments is not blank by default");
		Assert.assertEquals(c.getCreditcard_limit().getText(), "", "CC Limit is not blank by default");
		c.scroll_down();
		Assert.assertEquals(c.getDefaultEstimate(), "$0", "Estimate is not $0 by default");
	}

}
